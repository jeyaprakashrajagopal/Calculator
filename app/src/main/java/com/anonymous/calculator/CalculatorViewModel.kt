package com.anonymous.calculator

import androidx.lifecycle.ViewModel
import com.anonymous.calculator.data.CalculatorState
import com.anonymous.calculator.model.CalculatorOperation
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class CalculatorViewModel @Inject constructor() : ViewModel() {
    private val _calculatorState = MutableStateFlow(CalculatorState())
    val calculatorState = _calculatorState.asStateFlow()

    fun performAction(calculatorAction: CalculatorAction) {
        when (calculatorAction) {
            CalculatorAction.Calculate -> onCalculateSelected()
            is CalculatorAction.CalculatorOperators -> onOperatorsSelected(calculatorAction.calculatorOperation)
            CalculatorAction.Clear -> onClearSelected()
            CalculatorAction.Decimal -> onDecimalEntered()
            is CalculatorAction.Number -> onNumberEntered(calculatorAction.number)
            CalculatorAction.Delete -> onDeleteEntered()
        }
    }

    private fun onOperatorsSelected(calculatorOperation: CalculatorOperation) {
        if(_calculatorState.value.number1.isBlank()) return
        when (calculatorOperation) {
            CalculatorOperation.Add -> _calculatorState.value =
                _calculatorState.value.copy(operator = CalculatorOperation.Add.symbol)
            CalculatorOperation.Divide -> _calculatorState.value =
                _calculatorState.value.copy(operator = CalculatorOperation.Divide.symbol)
            CalculatorOperation.Minus -> _calculatorState.value =
                _calculatorState.value.copy(operator = CalculatorOperation.Minus.symbol)
            CalculatorOperation.Multiply -> _calculatorState.value =
                _calculatorState.value.copy(operator = CalculatorOperation.Multiply.symbol)
        }
    }

    private fun onCalculateSelected() {
        if (!isValidCalculatorState()) return
        val result = when (_calculatorState.value.operator) {
            CalculatorOperation.Add.symbol -> _calculatorState.value.number1.toFloat() + _calculatorState.value.number2.toFloat()
            CalculatorOperation.Divide.symbol -> _calculatorState.value.number1.toFloat() / _calculatorState.value.number2.toFloat()
            CalculatorOperation.Minus.symbol -> _calculatorState.value.number1.toFloat() - _calculatorState.value.number2.toFloat()
            CalculatorOperation.Multiply.symbol -> _calculatorState.value.number1.toFloat() * _calculatorState.value.number2.toFloat()
            else -> 0.0
        }
        _calculatorState.value = CalculatorState(number1 = "%.2f".format(result))
    }

    private fun isValidCalculatorState() =
        _calculatorState.value.number1.isNotBlank()
                && !_calculatorState.value.number1.startsWith(".")
                && !_calculatorState.value.number1.endsWith(".")
                && _calculatorState.value.operator != null
                && _calculatorState.value.number2.isNotBlank()
                && !_calculatorState.value.number2.startsWith(".")
                && !_calculatorState.value.number2.endsWith(".")

    private fun onDeleteEntered() {
        if (calculatorState.value == CalculatorState()) return

        if (calculatorState.value.number2.isNotBlank()) {
            _calculatorState.value =
                _calculatorState.value.copy(number2 = calculatorState.value.number2.dropLast(1))
        } else if (calculatorState.value.operator != null) {
            _calculatorState.value = _calculatorState.value.copy(operator = null)
        } else if (calculatorState.value.number1.isNotBlank()) {
            _calculatorState.value =
                _calculatorState.value.copy(number1 = calculatorState.value.number1.dropLast(1))
        }
    }

    private fun onClearSelected() {
        _calculatorState.value = CalculatorState()
    }

    private fun onDecimalEntered() {
        if (calculatorState.value.operator == null) {
            if (calculatorState.value.number1.isBlank() &&
                calculatorState.value.number1.length > MAX_LEN
            ) {
                return
            }
            _calculatorState.value =
                _calculatorState.value.copy(number1 = _calculatorState.value.number1 + ".")
        } else {
            if (calculatorState.value.number2.isBlank() &&
                calculatorState.value.number2.length > MAX_LEN
            ) {
                return
            }
            _calculatorState.value =
                _calculatorState.value.copy(number2 = _calculatorState.value.number2 + ".")
        }
    }

    private fun onNumberEntered(number: Int) {
        if (calculatorState.value.operator == null) {
            if (calculatorState.value.number1.length > MAX_LEN) {
                return
            }
            _calculatorState.value =
                _calculatorState.value.copy(number1 = _calculatorState.value.number1 + number)
        } else {
            if (calculatorState.value.number2.length > MAX_LEN) {
                return
            }
            _calculatorState.value =
                _calculatorState.value.copy(number2 = _calculatorState.value.number2 + number)

        }
    }

    private companion object {
        private const val MAX_LEN = 5
    }
}