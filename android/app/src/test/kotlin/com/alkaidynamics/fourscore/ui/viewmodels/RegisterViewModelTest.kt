package com.alkaidynamics.fourscore.ui.viewmodels

import com.alkaidynamics.fourscore.data.firebase.AuthResult
import com.alkaidynamics.fourscore.data.firebase.AuthService
import com.alkaidynamics.fourscore.data.firebase.AuthState
import com.alkaidynamics.fourscore.data.firebase.UserProfileService
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
import kotlin.test.assertTrue

/**
 * Unit tests for RegisterViewModel
 * Tests form validation, password strength calculation, and registration functionality in isolation
 * Following the one-test-at-a-time approach for systematic testing
 */
@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class RegisterViewModelTest {

    // System under test
    private lateinit var viewModel: RegisterViewModel

    // Mocks
    @Mock
    private lateinit var mockAuthService: AuthService

    @Mock
    private lateinit var mockUserProfileService: UserProfileService

    @Mock
    private lateinit var mockFirebaseUser: FirebaseUser

    // Test dispatcher for coroutines
    private val testDispatcher = StandardTestDispatcher()

    @Before
    fun setup() {
        // Set the main dispatcher for coroutines
        Dispatchers.setMain(testDispatcher)

        // Setup auth service mock
        `when`(mockAuthService.authState).thenReturn(MutableStateFlow(AuthState.Unauthenticated))

        // Create the view model with mocked dependencies
        viewModel = RegisterViewModel(mockAuthService, mockUserProfileService)
    }

    @After
    fun tearDown() {
        // Reset the main dispatcher
        Dispatchers.resetMain()
    }

    @Test
    fun `test initial state`() {
        // Verify initial state
        assertEquals("", viewModel.email.value)
        assertEquals("", viewModel.password.value)
        assertEquals("", viewModel.confirmPassword.value)
        assertEquals("", viewModel.displayName.value)
        assertFalse(viewModel.acceptTerms.value)
        
        // Verify validation state
        assertFalse(viewModel.isEmailValid.value)
        assertFalse(viewModel.isPasswordValid.value)
        assertFalse(viewModel.isConfirmPasswordValid.value)
        assertFalse(viewModel.isDisplayNameValid.value)
        assertEquals(PasswordStrength.WEAK, viewModel.passwordStrength.value)
        
        // Verify cannot submit with empty form
        assertFalse(viewModel.canSubmit.value)
    }

    @Test
    fun `test email validation - valid email`() {
        // When
        viewModel.updateEmail("user@example.com")
        
        // Then
        assertEquals("user@example.com", viewModel.email.value)
        assertTrue(viewModel.isEmailValid.value)
    }

    @Test
    fun `test email validation - invalid email`() {
        // Test various invalid email formats
        val invalidEmails = listOf(
            "", // Empty
            "userexample.com", // Missing @
            "user@", // Missing domain
            "@example.com", // Missing username
            "user@example" // Missing TLD
        )
        
        for (email in invalidEmails) {
            // When
            viewModel.updateEmail(email)
            
            // Then
            assertEquals(email, viewModel.email.value)
            assertFalse(viewModel.isEmailValid.value, "Email '$email' should be invalid")
        }
    }

    @Test
    fun `test password validation - valid password`() {
        // When
        viewModel.updatePassword("password123")
        
        // Then
        assertEquals("password123", viewModel.password.value)
        assertTrue(viewModel.isPasswordValid.value)
    }

    @Test
    fun `test password validation - invalid password`() {
        // When
        viewModel.updatePassword("short")
        
        // Then
        assertEquals("short", viewModel.password.value)
        assertFalse(viewModel.isPasswordValid.value)
    }

    @Test
    fun `test confirm password validation - matching passwords`() {
        // Given
        viewModel.updatePassword("password123")
        
        // When
        viewModel.updateConfirmPassword("password123")
        
        // Then
        assertEquals("password123", viewModel.confirmPassword.value)
        assertTrue(viewModel.isConfirmPasswordValid.value)
    }

    @Test
    fun `test confirm password validation - non-matching passwords`() {
        // Given
        viewModel.updatePassword("password123")
        
        // When
        viewModel.updateConfirmPassword("different")
        
        // Then
        assertEquals("different", viewModel.confirmPassword.value)
        assertFalse(viewModel.isConfirmPasswordValid.value)
    }

    @Test
    fun `test display name validation - valid name`() {
        // When
        viewModel.updateDisplayName("John Doe")
        
        // Then
        assertEquals("John Doe", viewModel.displayName.value)
        assertTrue(viewModel.isDisplayNameValid.value)
    }

    @Test
    fun `test display name validation - invalid name`() {
        // When
        viewModel.updateDisplayName("Jo")
        
        // Then
        assertEquals("Jo", viewModel.displayName.value)
        assertFalse(viewModel.isDisplayNameValid.value)
    }

    @Test
    fun `test terms acceptance`() {
        // When
        viewModel.updateAcceptTerms(true)
        
        // Then
        assertTrue(viewModel.acceptTerms.value)
    }

    @Test
    fun `test password strength calculation - weak password`() {
        // Test various weak passwords
        val weakPasswords = listOf(
            "", // Empty
            "pass", // Too short
            "12345678", // Only digits, but long enough
            "abcdefgh" // Only lowercase, but long enough
        )
        
        for (password in weakPasswords) {
            // When
            viewModel.updatePassword(password)
            
            // Then
            assertEquals(PasswordStrength.WEAK, viewModel.passwordStrength.value, 
                "Password '$password' should be weak")
        }
    }

    @Test
    fun `test password strength calculation - medium password`() {
        // Test various medium-strength passwords
        val mediumPasswords = listOf(
            "Password1", // Has uppercase, lowercase, and digit
            "abcd1234", // Has lowercase and digits
            "ABCD1234", // Has uppercase and digits
            "Abcdefgh" // Has uppercase and lowercase
        )
        
        for (password in mediumPasswords) {
            // When
            viewModel.updatePassword(password)
            
            // Then
            assertEquals(PasswordStrength.MEDIUM, viewModel.passwordStrength.value, 
                "Password '$password' should be medium strength")
        }
    }

    @Test
    fun `test password strength calculation - strong password`() {
        // Test various strong passwords
        val strongPasswords = listOf(
            "Password1!", // Has uppercase, lowercase, digit, and special char
            "Abcdefg1!", // Has uppercase, lowercase, digit, and special char
            "abcdefg1!@" // Has lowercase, digit, and multiple special chars
        )
        
        for (password in strongPasswords) {
            // When
            viewModel.updatePassword(password)
            
            // Then
            assertEquals(PasswordStrength.STRONG, viewModel.passwordStrength.value, 
                "Password '$password' should be strong")
        }
    }

    @Test
    fun `test password strength calculation - very strong password`() {
        // Test various very strong passwords
        val veryStrongPasswords = listOf(
            "Password123!@#", // Has uppercase, lowercase, digits, special chars, and is long
            "ThisIsAVeryStr0ng!Pass", // Has uppercase, lowercase, digits, special chars, and is very long
            "P@ssw0rd123!SECURE" // Has uppercase, lowercase, digits, special chars, and is long
        )
        
        for (password in veryStrongPasswords) {
            // When
            viewModel.updatePassword(password)
            
            // Then
            assertEquals(PasswordStrength.VERY_STRONG, viewModel.passwordStrength.value, 
                "Password '$password' should be very strong")
        }
    }

    @Test
    fun `test can submit when all fields are valid`() = runTest {
        // Given
        viewModel.updateEmail("user@example.com")
        viewModel.updatePassword("Password123!")
        viewModel.updateConfirmPassword("Password123!")
        viewModel.updateDisplayName("John Doe")
        viewModel.updateAcceptTerms(true)
        
        // Then
        assertTrue(viewModel.canSubmit.value)
    }

    @Test
    fun `test cannot submit when any field is invalid`() = runTest {
        // Setup all fields as valid first
        viewModel.updateEmail("user@example.com")
        viewModel.updatePassword("Password123!")
        viewModel.updateConfirmPassword("Password123!")
        viewModel.updateDisplayName("John Doe")
        viewModel.updateAcceptTerms(true)
        
        // Then test each invalid field one by one
        
        // Invalid email
        viewModel.updateEmail("invalid")
        assertFalse(viewModel.canSubmit.value)
        viewModel.updateEmail("user@example.com") // Reset to valid
        
        // Invalid password
        viewModel.updatePassword("short")
        assertFalse(viewModel.canSubmit.value)
        viewModel.updatePassword("Password123!") // Reset to valid
        
        // Invalid confirm password
        viewModel.updateConfirmPassword("different")
        assertFalse(viewModel.canSubmit.value)
        viewModel.updateConfirmPassword("Password123!") // Reset to valid
        
        // Invalid display name
        viewModel.updateDisplayName("Jo")
        assertFalse(viewModel.canSubmit.value)
        viewModel.updateDisplayName("John Doe") // Reset to valid
        
        // Terms not accepted
        viewModel.updateAcceptTerms(false)
        assertFalse(viewModel.canSubmit.value)
    }

    @Test
    fun `test successful registration`() = runTest {
        // Given
        viewModel.updateEmail("user@example.com")
        viewModel.updatePassword("Password123!")
        viewModel.updateConfirmPassword("Password123!")
        viewModel.updateDisplayName("John Doe")
        viewModel.updateAcceptTerms(true)
        
        // Mock successful registration
        `when`(mockFirebaseUser.uid).thenReturn("test-user-id")
        `when`(mockAuthService.registerUser("user@example.com", "Password123!"))
            .thenReturn(AuthResult.Success(mockFirebaseUser))
        
        // When
        viewModel.register()
        
        // Then
        verify(mockAuthService).registerUser("user@example.com", "Password123!")
        verify(mockUserProfileService).createOrUpdateProfile(
            eq("test-user-id"),
            eq(mapOf(
                "displayName" to "John Doe",
                "email" to "user@example.com"
            ))
        )
    }

    @Test
    fun `test failed registration`() = runTest {
        // Given
        viewModel.updateEmail("user@example.com")
        viewModel.updatePassword("Password123!")
        viewModel.updateConfirmPassword("Password123!")
        viewModel.updateDisplayName("John Doe")
        viewModel.updateAcceptTerms(true)
        
        // Mock failed registration
        `when`(mockAuthService.registerUser("user@example.com", "Password123!"))
            .thenReturn(AuthResult.Error("Registration failed"))
        
        // When
        viewModel.register()
        
        // Then
        verify(mockAuthService).registerUser("user@example.com", "Password123!")
        verify(mockUserProfileService, never()).createOrUpdateProfile(anyString(), any())
    }
}
