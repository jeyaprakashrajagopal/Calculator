package com.anonymous.calculator.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.anonymous.calculator.CalculatorAction
import com.anonymous.calculator.CalculatorViewModel
import com.anonymous.calculator.components.CalculatorButton
import com.anonymous.calculator.model.CalculatorOperation

@Composable
fun CalculatorScreen(calculatorViewModel: CalculatorViewModel = hiltViewModel()) {
    val calculatorState by calculatorViewModel.calculatorState.collectAsState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.DarkGray),
        verticalArrangement = Arrangement.Bottom
    ) {
        Text(
            text =
            "${calculatorState.number1} ${calculatorState.operator ?: ""} ${calculatorState.number2}",
            maxLines = 2,
            color = Color.White,
            style = MaterialTheme.typography.h2,
            modifier = Modifier
                .fillMaxWidth(),
            textAlign = TextAlign.End
        )

        Column(
            modifier = Modifier
                .wrapContentSize()
                .background(Color.DarkGray),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            CreateRow1() {
                calculatorViewModel.performAction(it)
            }
            CreateRow2() {
                calculatorViewModel.performAction(it)
            }
            CreateRow3() {
                calculatorViewModel.performAction(it)
            }
            CreateRow4() {
                calculatorViewModel.performAction(it)
            }
            CreateRow5() {
                calculatorViewModel.performAction(it)
            }
        }
    }
}

@Composable
fun CreateRow1(onAction: (CalculatorAction) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        horizontalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        CalculatorButton(symbol = "AC", modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .aspectRatio(2f)
            .weight(2f), backgroundColor = Color.Gray, onAction = {
            onAction(CalculatorAction.Clear)
        })
        CalculatorButton(symbol = "Del", modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .aspectRatio(1f)
            .weight(1f), backgroundColor = Color.Gray, onAction = {
            onAction(CalculatorAction.Delete)
        })

        CalculatorButton(symbol = CalculatorOperation.Divide.symbol, modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .aspectRatio(1f)
            .weight(1f), backgroundColor = Color.Magenta.copy(alpha = 0.5f), onAction = {
            onAction(CalculatorAction.CalculatorOperators(CalculatorOperation.Divide))
        })
    }
}

@Composable
fun CreateRow2(onAction: (CalculatorAction) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        CalculatorButton(symbol = "7", modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .aspectRatio(1f)
            .weight(1f), backgroundColor = Color.Black, onAction = {
            onAction(CalculatorAction.Number(7))
        })
        CalculatorButton(symbol = "8", modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .aspectRatio(1f)
            .weight(1f), backgroundColor = Color.Black, onAction = {
            onAction(CalculatorAction.Number(8))
        })

        CalculatorButton(symbol = "9", modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .aspectRatio(1f)
            .weight(1f), backgroundColor = Color.Black, onAction = {
            onAction(CalculatorAction.Number(9))
        })

        CalculatorButton(symbol = CalculatorOperation.Multiply.symbol, modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .aspectRatio(1f)
            .weight(1f), backgroundColor = Color.Magenta.copy(alpha = 0.5f), onAction = {
            onAction(CalculatorAction.CalculatorOperators(CalculatorOperation.Multiply))
        })
    }
}

@Composable
fun CreateRow3(onAction: (CalculatorAction) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        CalculatorButton(symbol = "4", modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .aspectRatio(1f)
            .weight(1f), backgroundColor = Color.Black, onAction = {
            onAction(CalculatorAction.Number(4))
        })
        CalculatorButton(symbol = "5", modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .aspectRatio(1f)
            .weight(1f), backgroundColor = Color.Black, onAction = {
            onAction(CalculatorAction.Number(5))
        })

        CalculatorButton(symbol = "6", modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .aspectRatio(1f)
            .weight(1f), backgroundColor = Color.Black, onAction = {
            onAction(CalculatorAction.Number(6))
        })

        CalculatorButton(symbol = CalculatorOperation.Minus.symbol, modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .aspectRatio(1f)
            .weight(1f), backgroundColor = Color.Magenta.copy(alpha = 0.5f), onAction = {
            onAction(CalculatorAction.CalculatorOperators(CalculatorOperation.Minus))
        })
    }
}

@Composable
fun CreateRow4(onAction: (CalculatorAction) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        CalculatorButton(symbol = "1", modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .aspectRatio(1f)
            .weight(1f), backgroundColor = Color.Black, onAction = {
            onAction(CalculatorAction.Number(1))
        })
        CalculatorButton(symbol = "2", modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .aspectRatio(1f)
            .weight(1f), backgroundColor = Color.Black, onAction = {
            onAction(CalculatorAction.Number(2))
        })

        CalculatorButton(symbol = "3", modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .aspectRatio(1f)
            .weight(1f), backgroundColor = Color.Black, onAction = {
            onAction(CalculatorAction.Number(3))
        })

        CalculatorButton(symbol = CalculatorOperation.Add.symbol, modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .aspectRatio(1f)
            .weight(1f), backgroundColor = Color.Magenta.copy(alpha = 0.5f), onAction = {
            onAction(CalculatorAction.CalculatorOperators(CalculatorOperation.Add))
        })
    }
}

@Composable
fun CreateRow5(onAction: (CalculatorAction) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        CalculatorButton(symbol = "0", modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .aspectRatio(2f)
            .weight(2f), backgroundColor = Color.Black, onAction = {
            onAction(CalculatorAction.Number(0))
        })
        CalculatorButton(symbol = ".", modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .aspectRatio(1f)
            .weight(1f), backgroundColor = Color.Black, onAction = {
            onAction(CalculatorAction.Decimal)
        })

        CalculatorButton(symbol = "=", modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .aspectRatio(1f)
            .weight(1f), backgroundColor = Color.Magenta.copy(alpha = 0.5f), onAction = {
            onAction(CalculatorAction.Calculate)
        })

    }
}

@Preview(showBackground = true)
@Composable
fun CalculatorPreview() {
    CalculatorScreen()
}
