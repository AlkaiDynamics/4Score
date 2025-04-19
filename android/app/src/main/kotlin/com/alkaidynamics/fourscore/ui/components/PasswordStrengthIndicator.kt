package com.alkaidynamics.fourscore.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.alkaidynamics.fourscore.ui.viewmodels.PasswordStrength

/**
 * Password strength indicator component
 * Provides clear visual feedback on password strength
 * Implements accessibility-first approach with color and text indicators
 */
@Composable
fun PasswordStrengthIndicator(
    strength: PasswordStrength,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        // Strength label
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Password Strength:",
                style = MaterialTheme.typography.bodyMedium
            )
            
            Text(
                text = when (strength) {
                    PasswordStrength.WEAK -> "Weak"
                    PasswordStrength.MEDIUM -> "Medium"
                    PasswordStrength.STRONG -> "Strong"
                    PasswordStrength.VERY_STRONG -> "Very Strong"
                },
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Bold,
                color = getColorForStrength(strength)
            )
        }
        
        Spacer(modifier = Modifier.height(4.dp))
        
        // Strength bar
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(8.dp)
        ) {
            // Segment 1 - always filled
            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(8.dp)
                    .background(getColorForStrength(strength))
            )
            
            Spacer(modifier = Modifier.width(2.dp))
            
            // Segment 2 - filled for MEDIUM and above
            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(8.dp)
                    .background(
                        if (strength.ordinal >= PasswordStrength.MEDIUM.ordinal)
                            getColorForStrength(strength)
                        else
                            Color.Gray.copy(alpha = 0.3f)
                    )
            )
            
            Spacer(modifier = Modifier.width(2.dp))
            
            // Segment 3 - filled for STRONG and above
            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(8.dp)
                    .background(
                        if (strength.ordinal >= PasswordStrength.STRONG.ordinal)
                            getColorForStrength(strength)
                        else
                            Color.Gray.copy(alpha = 0.3f)
                    )
            )
            
            Spacer(modifier = Modifier.width(2.dp))
            
            // Segment 4 - filled only for VERY_STRONG
            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(8.dp)
                    .background(
                        if (strength == PasswordStrength.VERY_STRONG)
                            getColorForStrength(strength)
                        else
                            Color.Gray.copy(alpha = 0.3f)
                    )
            )
        }
        
        Spacer(modifier = Modifier.height(4.dp))
        
        // Strength hint
        Text(
            text = getHintForStrength(strength),
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

/**
 * Get appropriate color for password strength level
 */
@Composable
private fun getColorForStrength(strength: PasswordStrength): Color {
    return when (strength) {
        PasswordStrength.WEAK -> Color.Red
        PasswordStrength.MEDIUM -> Color(0xFFFF9800) // Orange
        PasswordStrength.STRONG -> Color(0xFF4CAF50) // Green
        PasswordStrength.VERY_STRONG -> Color(0xFF2E7D32) // Dark Green
    }
}

/**
 * Get helpful hint text based on password strength
 */
private fun getHintForStrength(strength: PasswordStrength): String {
    return when (strength) {
        PasswordStrength.WEAK -> "Try adding numbers, symbols, and mixed case letters"
        PasswordStrength.MEDIUM -> "Good start! Add more variety for a stronger password"
        PasswordStrength.STRONG -> "Great password! Consider adding more characters"
        PasswordStrength.VERY_STRONG -> "Excellent password! Very secure"
    }
}
