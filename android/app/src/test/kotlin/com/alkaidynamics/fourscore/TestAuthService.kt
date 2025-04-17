package com.alkaidynamics.fourscore

import org.junit.Test
import kotlin.test.assertEquals

/**
 * Simple test to verify the testing environment is working
 */
class TestAuthService {
    
    @Test
    fun `test simple assertion`() {
        // Given
        val expected = 2
        
        // When
        val actual = 1 + 1
        
        // Then
        assertEquals(expected, actual, "Basic math should work")
    }
}
