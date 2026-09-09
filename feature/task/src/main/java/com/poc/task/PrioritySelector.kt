package com.poc.task

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PrioritySelector(
    selectedPriority: String,
    onPrioritySelected: (String) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(space = 10.dp)
    ) {
        Priority.entries.forEach { priority ->
            FilterChip(
                selected = priority.name == selectedPriority,
                onClick = {
                    onPrioritySelected(priority.name)
                },
                colors = FilterChipDefaults.filterChipColors(
                    selectedContainerColor = Color.Black
                ),
                label = {
                    Box(
                        modifier = Modifier
                            .width(80.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = priority.label,
                            fontSize = 14.sp,
                            fontFamily = FontFamily(Font(R.font.poppins_regular)),
                            color = if (selectedPriority == priority.name) Color.White else Color.Black
                        )
                    }
                }
            )
        }
    }
}