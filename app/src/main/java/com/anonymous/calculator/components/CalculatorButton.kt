package com.anonymous.calculator.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun CalculatorButton(modifier: Modifier = Modifier, symbol: String, backgroundColor: Color, onAction: () -> Unit) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .clip(CircleShape)
            .background(backgroundColor)
            .then(modifier)
            .clickable { onAction() }
    ) {
        Text(text = symbol, color = Color.White, fontWeight = FontWeight.ExtraBold, modifier = Modifier.padding(10.dp), style = MaterialTheme.typography.h4)
    }
}