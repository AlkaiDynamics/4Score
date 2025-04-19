package com.alkaidynamics.fourscore.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Sleep quality chart component
 * Visualizes sleep quality data over time
 * Implements accessibility-first approach with clear visual representation
 */
@Composable
fun SleepQualityChart(
    data: List<Pair<String, Int>>,
    modifier: Modifier = Modifier,
    lineColor: Color = Color(0xFF96854A) // Metallic Gold
) {
    if (data.isEmpty()) return
    
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Canvas(
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
                .padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            val maxQuality = 10f // Maximum quality value
            val width = size.width
            val height = size.height
            val pointCount = data.size
            
            // Calculate x step based on available width
            val xStep = width / (pointCount - 1)
            
            // Draw horizontal grid lines
            val gridLineCount = 5
            val gridLineStep = height / gridLineCount
            
            for (i in 0..gridLineCount) {
                val y = height - (i * gridLineStep)
                
                // Draw grid line
                drawLine(
                    color = Color.Gray.copy(alpha = 0.2f),
                    start = Offset(0f, y),
                    end = Offset(width, y),
                    strokeWidth = 1.dp.toPx()
                )
            }
            
            // Create path for the line chart
            val path = Path()
            
            // Create path for the area under the line
            val fillPath = Path()
            
            // Move to the first point
            val firstX = 0f
            val firstY = height - (height * (data[0].second / maxQuality))
            path.moveTo(firstX, firstY)
            fillPath.moveTo(firstX, height)
            fillPath.lineTo(firstX, firstY)
            
            // Draw points and connect them with lines
            for (i in 1 until pointCount) {
                val x = i * xStep
                val y = height - (height * (data[i].second / maxQuality))
                
                path.lineTo(x, y)
                fillPath.lineTo(x, y)
                
                // Draw point
                drawCircle(
                    color = lineColor,
                    radius = 4.dp.toPx(),
                    center = Offset(x, y)
                )
            }
            
            // Complete the fill path
            fillPath.lineTo(width, height)
            fillPath.close()
            
            // Draw the fill
            drawPath(
                path = fillPath,
                color = lineColor.copy(alpha = 0.1f)
            )
            
            // Draw the line
            drawPath(
                path = path,
                color = lineColor,
                style = Stroke(
                    width = 2.dp.toPx(),
                    cap = StrokeCap.Round
                )
            )
            
            // Draw the first point (was covered by the fill)
            drawCircle(
                color = lineColor,
                radius = 4.dp.toPx(),
                center = Offset(firstX, firstY)
            )
        }
        
        // X-axis labels
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .align(Alignment.BottomCenter)
                .padding(bottom = 4.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            data.forEach { (day, _) ->
                Text(
                    text = day,
                    style = MaterialTheme.typography.bodySmall.copy(fontSize = 10.sp),
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.width(32.dp)
                )
            }
        }
        
        // Y-axis labels
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(vertical = 8.dp)
                .align(Alignment.CenterStart)
                .padding(start = 4.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "10",
                style = MaterialTheme.typography.bodySmall.copy(fontSize = 10.sp),
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
            )
            
            Text(
                text = "5",
                style = MaterialTheme.typography.bodySmall.copy(fontSize = 10.sp),
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
            )
            
            Text(
                text = "0",
                style = MaterialTheme.typography.bodySmall.copy(fontSize = 10.sp),
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
            )
        }
    }
}
