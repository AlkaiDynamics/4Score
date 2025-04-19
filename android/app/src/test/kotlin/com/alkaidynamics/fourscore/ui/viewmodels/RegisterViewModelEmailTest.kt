package com.alkaidynamics.fourscore.ui.viewmodels

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner
import kotlin.test.assertFalse
import kotlin.test.assertTrue
import java.util.regex.Pattern

/**
 * Focused test for RegisterViewModel email validation
 * Following the one-test-at-a-time approach for systematic testing
 */
@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class RegisterViewModelEmailTest {

    // Test dispatcher for coroutines
    private val testDispatcher = StandardTestDispatcher()
    
    // Email validation pattern (extracted from RegisterViewModel)
    private val emailPattern = Pattern.compile(
        "[a-zA-Z0-9+._%\\-]{1,256}" +
        "@" +
        "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
        "(" +
        "\\." +
        "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
        ")+"
    )

    @Before
    fun setup() {
        // Set the main dispatcher for coroutines
        Dispatchers.setMain(testDispatcher)
    }

    @After
    fun tearDown() {
        // Reset the main dispatcher
        Dispatchers.resetMain()
    }

    /**
     * Test the email validation logic with valid emails
     * This is a direct test of the logic extracted from RegisterViewModel
     */
    @Test
    fun `test email validation with valid emails`() {
        // Test cases with valid emails
        val validEmails = listOf(
            "user@example.com",
            "user.name@example.com",
            "user+tag@example.com",
            "user-name@example.co.uk",
            "user123@example.com"
        )
        
        for (email in validEmails) {
            // When
            val result = validateEmail(email)
            
            // Then
            assertTrue(
                result,
                "Email '$email' should be valid"
            )
        }
    }
    
    /**
     * Test the email validation logic with invalid emails
     * This is a direct test of the logic extracted from RegisterViewModel
     */
    @Test
    fun `test email validation with invalid emails`() {
        // Test cases with invalid emails
        val invalidEmails = listOf(
            "", // Empty
            "userexample.com", // Missing @
            "user@", // Missing domain
            "@example.com", // Missing username
            "user@example", // Missing TLD
            "user@.com", // Missing domain name
            "user@example..com" // Double dot in domain
        )
        
        for (email in invalidEmails) {
            // When
            val result = validateEmail(email)
            
            // Then
            assertFalse(
                result,
                "Email '$email' should be invalid"
            )
        }
    }
    
    /**
     * Validate email format
     * This is the exact function from RegisterViewModel
     */
    private fun validateEmail(email: String): Boolean {
        return email.isNotEmpty() && emailPattern.matcher(email).matches()
    }
}
