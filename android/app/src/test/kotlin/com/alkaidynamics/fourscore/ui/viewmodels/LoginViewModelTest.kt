package com.alkaidynamics.fourscore.ui.viewmodels

import com.alkaidynamics.fourscore.data.firebase.AuthResult
import com.alkaidynamics.fourscore.data.firebase.AuthService
import com.alkaidynamics.fourscore.data.firebase.AuthState
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertNull
import kotlin.test.assertTrue

/**
 * Unit tests for LoginViewModel
 * Tests form validation and login functionality in isolation
 */
@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class LoginViewModelTest {

    // System under test
    private lateinit var viewModel: LoginViewModel

    // Mocks
    @Mock
    private lateinit var mockAuthService: AuthService

    @Mock
    private lateinit var mockFirebaseUser: FirebaseUser

    // Test dispatcher for coroutines
    private val testDispatcher = StandardTestDispatcher()

    @Before
    fun setup() {
        // Set the main dispatcher for coroutines
        Dispatchers.setMain(testDispatcher)

        // Mock auth state flow
        val authStateFlow = MutableStateFlow(AuthState(false, null))
        `when`(mockAuthService.authState).thenReturn(authStateFlow)

        // Create view model with mocked dependencies
        viewModel = LoginViewModel(mockAuthService)
    }

    @After
    fun tearDown() {
        // Reset the main dispatcher
        Dispatchers.resetMain()
    }

    @Test
    fun `test initial state`() = runTest {
        // Verify initial state
        assertEquals("", viewModel.email.value)
        assertEquals("", viewModel.password.value)
        assertFalse(viewModel.rememberMe.value)
        assertFalse(viewModel.isEmailValid.value)
        assertFalse(viewModel.isPasswordValid.value)
        assertFalse(viewModel.canSubmit.first())
        assertFalse(viewModel.isLoading.value)
        assertNull(viewModel.error.value)
    }

    @Test
    fun `test email validation - valid email`() = runTest {
        // When
        viewModel.updateEmail("test@example.com")

        // Then
        assertEquals("test@example.com", viewModel.email.value)
        assertTrue(viewModel.isEmailValid.value)
    }

    @Test
    fun `test email validation - invalid email`() = runTest {
        // When
        viewModel.updateEmail("invalid-email")

        // Then
        assertEquals("invalid-email", viewModel.email.value)
        assertFalse(viewModel.isEmailValid.value)
    }

    @Test
    fun `test password validation - valid password`() = runTest {
        // When
        viewModel.updatePassword("password123")

        // Then
        assertEquals("password123", viewModel.password.value)
        assertTrue(viewModel.isPasswordValid.value)
    }

    @Test
    fun `test password validation - invalid password`() = runTest {
        // When
        viewModel.updatePassword("short")

        // Then
        assertEquals("short", viewModel.password.value)
        assertFalse(viewModel.isPasswordValid.value)
    }

    @Test
    fun `test remember me toggle`() = runTest {
        // When
        viewModel.updateRememberMe(true)

        // Then
        assertTrue(viewModel.rememberMe.value)
    }

    @Test
    fun `test login success`() = runTest {
        // Given
        viewModel.updateEmail("test@example.com")
        viewModel.updatePassword("password123")
        `when`(mockAuthService.signInWithEmailAndPassword("test@example.com", "password123"))
            .thenReturn(AuthResult.Success(mockFirebaseUser))

        // When
        viewModel.login()
        testDispatcher.scheduler.advanceUntilIdle() // Process all coroutines

        // Then
        verify(mockAuthService).signInWithEmailAndPassword("test@example.com", "password123")
        assertFalse(viewModel.isLoading.value)
        assertNull(viewModel.error.value)
    }

    @Test
    fun `test login failure`() = runTest {
        // Given
        viewModel.updateEmail("test@example.com")
        viewModel.updatePassword("password123")
        val errorMessage = "Invalid credentials"
        `when`(mockAuthService.signInWithEmailAndPassword("test@example.com", "password123"))
            .thenReturn(AuthResult.Error(errorMessage))

        // When
        viewModel.login()
        testDispatcher.scheduler.advanceUntilIdle() // Process all coroutines

        // Then
        verify(mockAuthService).signInWithEmailAndPassword("test@example.com", "password123")
        assertFalse(viewModel.isLoading.value)
        assertEquals(errorMessage, viewModel.error.value)
    }

    @Test
    fun `test clear error`() = runTest {
        // Given
        viewModel.updateEmail("test@example.com")
        viewModel.updatePassword("password123")
        val errorMessage = "Invalid credentials"
        `when`(mockAuthService.signInWithEmailAndPassword("test@example.com", "password123"))
            .thenReturn(AuthResult.Error(errorMessage))

        // When - trigger error
        viewModel.login()
        testDispatcher.scheduler.advanceUntilIdle() // Process all coroutines
        assertEquals(errorMessage, viewModel.error.value)

        // When - clear error
        viewModel.clearError()

        // Then
        assertNull(viewModel.error.value)
    }

    @Test
    fun `test cannot submit with invalid form`() = runTest {
        // Given
        viewModel.updateEmail("invalid-email")
        viewModel.updatePassword("short")

        // When
        viewModel.login()
        testDispatcher.scheduler.advanceUntilIdle() // Process all coroutines

        // Then
        verify(mockAuthService, never()).signInWithEmailAndPassword(any(), any())
    }
}
