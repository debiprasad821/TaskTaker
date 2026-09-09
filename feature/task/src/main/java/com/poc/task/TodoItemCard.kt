package com.poc.task

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.poc.data.local.Task
import com.poc.task.theme.Gray
import com.poc.task.util.toFormattedDate

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun TodoItemCard(task: Task) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(5.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 5.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Text(
                text = task.title,
                fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                style = MaterialTheme.typography.titleMedium
            )

            Text(
                text = task.description,
                fontFamily = FontFamily(Font(R.font.poppins_regular)),
                style = MaterialTheme.typography.bodyMedium.copy(
                    color = Color.Black
                )
            )

            Row {
                Text(
                    text = "Due Date: ",
                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                    style = MaterialTheme.typography.bodySmall.copy(
                        fontWeight = FontWeight.W300,
                        color = Gray
                    )
                )

                Text(
                    text = task.dueDateTime?.toFormattedDate() ?: "N/A",
                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                    style = MaterialTheme.typography.bodySmall.copy(
                        color = Color.Black
                    )
                )
            }

            Spacer(
                modifier = Modifier
                    .height(5.dp)
            )

            Box(
                modifier = Modifier
                    .wrapContentWidth()
                    .background(
                        shape = RoundedCornerShape(50.dp),
                        color = Color.Red
                    )
                    .padding(
                         horizontal =  5.dp,
                        vertical = 2.dp
                    )
            ) {
                Text(
                    text = task.priority,
                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                    style = MaterialTheme.typography.labelSmall.copy(
                        fontWeight = FontWeight.W300,
                        color = Color.White
                    )
                )
            }
        }
    }
}