package com.poc.tasktaker.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusProperties
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.poc.tasktaker.R
import com.poc.tasktaker.ui.theme.Gray

@Composable
fun CustomInputField(
    value: String,
    onValueChange: (String) -> Unit,
    placeHolder: String = "",
    isSingleLine: Boolean = true,
    maxLines: Int = 1,
    endIcon: ImageVector? = null,
    isFocusable: Boolean = true,
    onEndIconClick: () -> Unit = {}
) {
    BasicTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = Modifier
            .fillMaxWidth()
            .focusProperties {
                canFocus = isFocusable
            },
        singleLine = isSingleLine,
        maxLines = maxLines,
        textStyle = TextStyle(
            fontSize = 14.sp
        )
    ) { innerTextField ->
        Box(
            modifier = Modifier
                .height(if (isSingleLine) 40.dp else 100.dp)
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(4.dp)
                )
                .border(
                    width = (.4).dp,
                    color = Gray,
                    shape = RoundedCornerShape(4.dp)
                )
                .padding(
                    start = 8.dp,
                    end = 8.dp,
                    top = if (isSingleLine) 0.dp else 8.dp
                ),
            contentAlignment = if (isSingleLine) Alignment.CenterStart else Alignment.TopStart
        ) {
            if (value.isEmpty()) {
                Text(
                    text = placeHolder,
                    fontSize = 12.sp,
                    color = Gray,
                    fontFamily = FontFamily(Font(R.font.poppins_regular))
                )
            }

            endIcon?.let {
                Icon(
                    modifier = Modifier
                        .size(20.dp)
                        .align(Alignment.CenterEnd)
                        .clickable(
                            onClick = onEndIconClick
                        ),
                    imageVector = it,
                    contentDescription = ""
                )
            }

            innerTextField()
        }
    }
}