package com.anonymous.calculator

import com.anonymous.calculator.model.CalculatorOperation

sealed class CalculatorAction {
    data class Number(val number: Int): CalculatorAction()
    object Clear: CalculatorAction()
    object Decimal: CalculatorAction()
    object Calculate: CalculatorAction()
    object Delete: CalculatorAction()
    data class CalculatorOperators(val calculatorOperation: CalculatorOperation): CalculatorAction()
}