package com.anonymous.calculator.model

sealed class CalculatorOperation(val symbol: String) {
    object Divide: CalculatorOperation("/")
    object Multiply: CalculatorOperation("x")
    object Add: CalculatorOperation("+")
    object Minus: CalculatorOperation("-")
}