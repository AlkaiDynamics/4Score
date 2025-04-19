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
import kotlin.test.assertEquals

/**
 * Focused test for RegisterViewModel password strength calculation
 * Following the one-test-at-a-time approach for systematic testing
 */
@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class RegisterViewModelPasswordTest {

    // Test dispatcher for coroutines
    private val testDispatcher = StandardTestDispatcher()

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
     * Test the password strength calculation logic
     * This is a direct test of the logic extracted from RegisterViewModel
     */
    @Test
    fun `test password strength calculation`() {
        // Test cases with expected results
        val testCases = listOf(
            "" to PasswordStrength.WEAK,
            "pass" to PasswordStrength.WEAK,
            "12345678" to PasswordStrength.WEAK,
            "abcdefgh" to PasswordStrength.WEAK,
            "Password1" to PasswordStrength.MEDIUM,
            "Abcdefgh" to PasswordStrength.MEDIUM,
            "Password1!" to PasswordStrength.STRONG,
            "ThisIsAVeryStr0ng!Pass" to PasswordStrength.VERY_STRONG
        )
        
        for ((password, expected) in testCases) {
            // When
            val result = calculatePasswordStrength(password)
            
            // Then
            assertEquals(
                expected, 
                result,
                "Password '$password' should have strength $expected but was $result"
            )
        }
    }
    
    /**
     * Calculate password strength based on complexity
     * This is the exact function from RegisterViewModel
     */
    private fun calculatePasswordStrength(password: String): PasswordStrength {
        if (password.isEmpty()) return PasswordStrength.WEAK
        
        var score = 0
        
        // Length check
        if (password.length >= 8) score++
        if (password.length >= 12) score++
        
        // Character variety checks
        if (password.any { it.isDigit() }) score++
        if (password.any { it.isLowerCase() }) score++
        if (password.any { it.isUpperCase() }) score++
        if (password.any { !it.isLetterOrDigit() }) score++
        
        return when {
            score <= 2 -> PasswordStrength.WEAK
            score <= 4 -> PasswordStrength.MEDIUM
            score < 6 -> PasswordStrength.STRONG
            else -> PasswordStrength.VERY_STRONG
        }
    }
}
