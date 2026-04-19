package com.example.kotlinpractice

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CalculatorActivity : AppCompatActivity() {
    var currentInput = ("")
    var firstOperand = (0.0)
    var secondOperand = (0.0)
    var currentOperator = ("")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_calculator)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val tv_display = findViewById<TextView>(R.id.tv_display)
        val Digits = mapOf(
            R.id.btn_0 to "0",
            R.id.btn_1 to "1",
            R.id.btn_2 to "2",
            R.id.btn_3 to "3",
            R.id.btn_4 to "4",
            R.id.btn_5 to "5",
            R.id.btn_6 to "6",
            R.id.btn_7 to "7",
            R.id.btn_8 to "8",
            R.id.btn_9 to "9"
        )
        for ((id, digit) in Digits) {
            findViewById<Button>(id).setOnClickListener {
                currentInput += digit
                tv_display.text = currentInput
            }
        }
        val operatorButtons = mapOf(
            R.id.btn_add to "+",
            R.id.btn_subtract to "-",
            R.id.btn_multiply to "*",
            R.id.btn_divide to "/"
        )

        for ((id, operator) in operatorButtons) {
            findViewById<Button>(id).setOnClickListener {
                firstOperand = currentInput.toDoubleOrNull() ?: 0.0
                currentOperator = operator
                currentInput = ""
            }
        }
        findViewById<Button>(R.id.btn_equals).setOnClickListener {
            secondOperand = currentInput.toDoubleOrNull() ?: 0.0
            val result = compute(currentOperator)
            tv_display.text = result.toString()
            currentInput = result.toString()  // allows chaining results
            currentOperator = ""
        }
    }

    fun addNumbers(a: Double, b:Double): Double{
        return a + b
    }
    fun subtractNumbers(a: Double, b:Double): Double{
        return a - b
    }
    fun multiplyNumbers(a: Double, b:Double): Double{
        return a * b
    }
    fun divideNumbers(a: Double, b:Double): Double{
        return a / b
    }
    val number = currentInput.toDoubleOrNull()?: (0.0)
    fun compute(Op: String):Double{
        var num = (0.0)
        when (Op) {
            "+" -> num = addNumbers(firstOperand,secondOperand)
            "-" -> num = subtractNumbers(firstOperand,secondOperand)
            "*" -> num = multiplyNumbers(firstOperand,secondOperand)
            "/" -> num = divideNumbers(firstOperand,secondOperand)
        }
        return num
    }

}