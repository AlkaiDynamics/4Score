package com.alkaidynamics.fourscore.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

/**
 * Macro progress bar component for displaying macronutrient progress
 * Provides clear visual feedback on nutrition tracking
 * Implements accessibility-first approach with high contrast and clear typography
 */
@Composable
fun MacroProgressBar(
    label: String,
    consumed: Int,
    goal: Int,
    unit: String,
    color: Color,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxWidth()) {
        // Label and values
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Label
            Text(
                text = label,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold
            )
            
            // Values
            Text(
                text = "$consumed / $goal $unit",
                style = MaterialTheme.typography.bodyMedium
            )
        }
        
        Spacer(modifier = Modifier.height(4.dp))
        
        // Progress bar
        LinearProgressIndicator(
            progress = (consumed.toFloat() / goal).coerceIn(0f, 1f),
            modifier = Modifier
                .fillMaxWidth()
                .height(8.dp),
            color = color
        )
        
        // Percentage text
        val percentage = (consumed.toFloat() / goal * 100).toInt().coerceIn(0, 100)
        Text(
            text = "$percentage%",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f),
            modifier = Modifier.align(Alignment.End)
        )
    }
}
