package com.alkaidynamics.fourscore.data.firebase

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
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
 * Unit tests for AuthService
 * Tests authentication functionality in isolation
 */
@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class AuthServiceTest {

    // System under test
    private lateinit var authService: AuthService

    // Mocks
    @Mock
    private lateinit var mockFirebaseAuth: FirebaseAuth

    @Mock
    private lateinit var mockFirebaseUser: FirebaseUser

    @Before
    fun setup() {
        // Inject mocked FirebaseAuth into AuthService
        authService = AuthService(mockFirebaseAuth)
    }

    @Test
    fun `test initial auth state is unauthenticated`() = runTest {
        // Given
        `when`(mockFirebaseAuth.currentUser).thenReturn(null)

        // When
        val initialAuthState = authService.authState.first()

        // Then
        assertFalse(initialAuthState.isAuthenticated)
        assertNull(initialAuthState.user)
    }

    @Test
    fun `test auth state is authenticated when user is logged in`() = runTest {
        // Given
        `when`(mockFirebaseAuth.currentUser).thenReturn(mockFirebaseUser)
        `when`(mockFirebaseUser.uid).thenReturn("test-user-id")
        `when`(mockFirebaseUser.email).thenReturn("test@example.com")

        // When
        val authState = authService.authState.first()

        // Then
        assertTrue(authState.isAuthenticated)
        assertEquals("test-user-id", authState.user?.uid)
        assertEquals("test@example.com", authState.user?.email)
    }

    @Test
    fun `test sign in with email and password success`() = runTest {
        // Given
        val email = "test@example.com"
        val password = "password123"
        val task = mock(com.google.android.gms.tasks.Task::class.java)
        `when`(mockFirebaseAuth.signInWithEmailAndPassword(email, password)).thenReturn(task)
        `when`(task.isSuccessful).thenReturn(true)

        // When
        val result = authService.signInWithEmailAndPassword(email, password)

        // Then
        assertTrue(result is AuthResult.Success)
        verify(mockFirebaseAuth).signInWithEmailAndPassword(email, password)
    }

    @Test
    fun `test sign in with email and password failure`() = runTest {
        // Given
        val email = "test@example.com"
        val password = "password123"
        val task = mock(com.google.android.gms.tasks.Task::class.java)
        val exception = Exception("Authentication failed")
        `when`(mockFirebaseAuth.signInWithEmailAndPassword(email, password)).thenReturn(task)
        `when`(task.isSuccessful).thenReturn(false)
        `when`(task.exception).thenReturn(exception)

        // When
        val result = authService.signInWithEmailAndPassword(email, password)

        // Then
        assertTrue(result is AuthResult.Error)
        assertEquals("Authentication failed", (result as AuthResult.Error).message)
        verify(mockFirebaseAuth).signInWithEmailAndPassword(email, password)
    }

    @Test
    fun `test create user with email and password success`() = runTest {
        // Given
        val email = "test@example.com"
        val password = "password123"
        val task = mock(com.google.android.gms.tasks.Task::class.java)
        `when`(mockFirebaseAuth.createUserWithEmailAndPassword(email, password)).thenReturn(task)
        `when`(task.isSuccessful).thenReturn(true)

        // When
        val result = authService.createUserWithEmailAndPassword(email, password)

        // Then
        assertTrue(result is AuthResult.Success)
        verify(mockFirebaseAuth).createUserWithEmailAndPassword(email, password)
    }

    @Test
    fun `test create user with email and password failure`() = runTest {
        // Given
        val email = "test@example.com"
        val password = "password123"
        val task = mock(com.google.android.gms.tasks.Task::class.java)
        val exception = Exception("Registration failed")
        `when`(mockFirebaseAuth.createUserWithEmailAndPassword(email, password)).thenReturn(task)
        `when`(task.isSuccessful).thenReturn(false)
        `when`(task.exception).thenReturn(exception)

        // When
        val result = authService.createUserWithEmailAndPassword(email, password)

        // Then
        assertTrue(result is AuthResult.Error)
        assertEquals("Registration failed", (result as AuthResult.Error).message)
        verify(mockFirebaseAuth).createUserWithEmailAndPassword(email, password)
    }

    @Test
    fun `test send password reset email success`() = runTest {
        // Given
        val email = "test@example.com"
        val task = mock(com.google.android.gms.tasks.Task::class.java)
        `when`(mockFirebaseAuth.sendPasswordResetEmail(email)).thenReturn(task)
        `when`(task.isSuccessful).thenReturn(true)

        // When
        val result = authService.sendPasswordResetEmail(email)

        // Then
        assertTrue(result is AuthResult.Success)
        verify(mockFirebaseAuth).sendPasswordResetEmail(email)
    }

    @Test
    fun `test send password reset email failure`() = runTest {
        // Given
        val email = "test@example.com"
        val task = mock(com.google.android.gms.tasks.Task::class.java)
        val exception = Exception("Password reset failed")
        `when`(mockFirebaseAuth.sendPasswordResetEmail(email)).thenReturn(task)
        `when`(task.isSuccessful).thenReturn(false)
        `when`(task.exception).thenReturn(exception)

        // When
        val result = authService.sendPasswordResetEmail(email)

        // Then
        assertTrue(result is AuthResult.Error)
        assertEquals("Password reset failed", (result as AuthResult.Error).message)
        verify(mockFirebaseAuth).sendPasswordResetEmail(email)
    }

    @Test
    fun `test sign out`() = runTest {
        // When
        authService.signOut()

        // Then
        verify(mockFirebaseAuth).signOut()
    }
}
