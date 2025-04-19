package com.alkaidynamics.fourscore

import org.junit.Test
import kotlin.test.assertEquals
import com.alkaidynamics.fourscore.ui.viewmodels.PasswordStrength

/**
 * Test for password strength calculation
 * This test focuses on validating the password strength logic used in our authentication system
 */
class PasswordStrengthTest {
    
    /**
     * Calculate password strength based on complexity
     * This is extracted from RegisterViewModel for testing
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
            score <= 6 -> PasswordStrength.STRONG
            else -> PasswordStrength.VERY_STRONG
        }
    }
    
    @Test
    fun `test weak passwords`() {
        // Given - a list of weak passwords
        val weakPasswords = listOf(
            "",                // Empty
            "pass",            // Too short
            "12345678",        // Only digits, but long enough
            "abcdefgh"         // Only lowercase, but long enough
        )
        
        // When/Then - each password should be classified as weak
        weakPasswords.forEach { password ->
            assertEquals(
                PasswordStrength.WEAK, 
                calculatePasswordStrength(password),
                "Password should be weak: $password"
            )
        }
    }
    
    @Test
    fun `test medium passwords`() {
        // Given - a list of medium-strength passwords
        val mediumPasswords = listOf(
            "Password1",       // Uppercase, lowercase, and digit
            "abcdef123",       // Lowercase and digits
            "ABCDEF123",       // Uppercase and digits
            "Abcdefgh"         // Uppercase and lowercase
        )
        
        // When/Then - each password should be classified as medium
        mediumPasswords.forEach { password ->
            assertEquals(
                PasswordStrength.MEDIUM, 
                calculatePasswordStrength(password),
                "Password should be medium: $password"
            )
        }
    }
    
    @Test
    fun `test strong passwords`() {
        // Given - a list of strong passwords
        val strongPasswords = listOf(
            "Password1!",          // Upper, lower, digit, symbol
            "Abcdef123!@#",        // Upper, lower, digit, symbol
            "SuperSecurePass1",    // Upper, lower, digit, and 12+ chars
            "abcdefgh123!@#"       // Lower, digit, symbol, and 12+ chars
        )
        
        // When/Then - each password should be classified as strong
        strongPasswords.forEach { password ->
            assertEquals(
                PasswordStrength.STRONG, 
                calculatePasswordStrength(password),
                "Password should be strong: $password"
            )
        }
    }
    
    @Test
    fun `test very strong passwords`() {
        // Given - a list of very strong passwords
        val veryStrongPasswords = listOf(
            "SuperSecurePass1!@#",     // Upper, lower, digit, symbol, and 12+ chars
            "This1sAVeryStr0ng!Pass",  // Upper, lower, digit, symbol, and 12+ chars
            "P@ssw0rd123!SECURE",      // Upper, lower, digit, symbol, and 12+ chars
            "Abcdefg12345!@#$%"        // Upper, lower, digit, symbol, and 12+ chars
        )
        
        // When/Then - each password should be classified as very strong
        veryStrongPasswords.forEach { password ->
            assertEquals(
                PasswordStrength.VERY_STRONG, 
                calculatePasswordStrength(password),
                "Password should be very strong: $password"
            )
        }
    }
}
