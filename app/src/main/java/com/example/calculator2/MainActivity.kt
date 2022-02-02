package com.example.calculator2

import android.icu.text.DecimalFormat
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var a = ""
    var number = ""
    var number1 = true
    var check = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        num0.setOnClickListener {
            if (number1)
                textView.text = formatDecimal("${textView.text}0")
            else {
                textView.text = "0"
                number1 = true
            }
        }
        num1.setOnClickListener {
            if (number1)
                textView.text = formatDecimal("${textView.text}1")
            else {
                textView.text = "1"
                number1 = true
            }
        }
        num2.setOnClickListener {
            if (number1)
                textView.text = formatDecimal("${textView.text}2")
            else {
                textView.text = "2"
                number1 = true
            }
        }
        num3.setOnClickListener {
            if (number1)
                textView.text = formatDecimal("${textView.text}3")
            else {
                textView.text = "3"
                number1 = true
            }
        }
        num4.setOnClickListener {
            if (number1)
                textView.text = formatDecimal("${textView.text}4")
            else {
                textView.text = "4"
                number1 = true
            }
        }
        num5.setOnClickListener {
            if (number1)
                textView.text = formatDecimal("${textView.text}5")
            else {
                textView.text = "5"
                number1 = true
            }
        }
        num6.setOnClickListener {
            if (number1)
                textView.text = formatDecimal("${textView.text}6")
            else {
                textView.text = "6"
                number1 = true
            }
        }
        num7.setOnClickListener {
            if (number1)
                textView.text = formatDecimal("${textView.text}7")
            else {
                textView.text = "7"
                number1 = true
            }
        }
        num8.setOnClickListener {
            if (number1)
                textView.text = formatDecimal("${textView.text}8")
            else {
                textView.text = "8"
                number1 = true
            }
        }
        num9.setOnClickListener {
            if (number1)
                textView.text = formatDecimal("${textView.text}9")
            else {
                textView.text = "9"
                number1 = true
            }
        }
        btplus.setOnClickListener {
            a = "+"
            if (a != "" && number == "") {
                number = textView.text.toString()
            }
            if (check) {
                compute()
                number = textView.text.toString()
            }
            check = true
            number1 = false
        }
        btmin.setOnClickListener {
            a = "-"
            if (a != "" && number == "") {
                number = textView.text.toString()
            }
            if (check) {
                compute()
                number = textView.text.toString()
            }
            check = true
            number1 = false
        }
        btmult.setOnClickListener {
            a = "*"
            if (a != "" && number == "") {
                number = textView.text.toString()
            }
            if (check) {
                compute()
                number = textView.text.toString()
            }
            check = true
            number1 = false
        }
        btdiv.setOnClickListener {
            a = "/"
            if (a != "" && number == "") {
                number = textView.text.toString()
            }
            if (check) {
                compute()
                number = textView.text.toString()
            }
            check = true
            number1 = false
        }
        btmod.setOnClickListener {
            a = "%"
            if (a != "" && number == "") {
                number = textView.text.toString()
            }
            if (check) {
                compute()
                number = textView.text.toString()
            }
            check = true
            number1 = false
        }
        btequ.setOnClickListener{
            compute ()
            a = ""
            number = ""
            check = false
        }
        btdel.setOnClickListener {
            textView.text = textView.text.toString().dropLast(1).ifEmpty { "0" }
        }
        btdot.setOnClickListener {
            if (!textView.text.toString().contains(".")&& textView.text.toString().isNotEmpty()) {
                textView.text = "${textView.text}."
            }
        }
        btclear.setOnClickListener {
            a = ""
            number = ""
            number1 = true
            textView.text = "0"
            check = false
        }
    }
        private fun compute () {
            val number1 = textView.text.toString()
            if (a != "" && number1 != "") {
                if (a == "+") {
                    println(number + number1)
                    textView.text =
                            formatDecimal((number.toDouble() + number1.toDouble()).toString())
                } else if (a == "-") {
                    textView.text =
                            formatDecimal((number.toDouble() - number1.toDouble()).toString())
                } else if (a == "*") {
                    textView.text =
                            formatDecimal((number.toDouble() * number1.toDouble()).toString())
                } else if (a == "/") {
                    if (number1 == "0" || number1 == "") {
                        textView.text = "ERROR"
                        return@compute
                    }
                    textView.text =
                            formatDecimal((number.toDouble() / number1.toDouble()).toString())
                } else if (a == "%") {
                    if (number1 == "0" || number1 == "") {
                        textView.text = "ERROR"
                        return@compute
                    }
                    textView.text =
                            formatDecimal((number.toDouble() % number1.toDouble()).toString())
                }
            }
        }
    private fun formatDecimal(num: String): String {
        val format = DecimalFormat("0.#######");
        return format.format(num.ifEmpty { "0" }.toDouble())
    }
}