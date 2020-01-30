package com.example.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_learning_math.*

class LearningMathActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_learning_math)

    }

    fun plus(view: View) {
        val numOne: Int = (editTextNumberOne.text.toString()).toInt()
        val numTwo: Int = (editTextNumberTwo.text.toString()).toInt()
        val result: Int = numOne + numTwo
        textViewResult.text = result.toString()

    }

    fun minus(view: View) {
        val numOne: Int = (editTextNumberOne.text.toString()).toInt()
        val numTwo: Int = (editTextNumberTwo.text.toString()).toInt()
        val result: Int = numOne - numTwo
        textViewResult.text = result.toString()
    }

    fun multi(view: View) {
        val numOne: Int = (editTextNumberOne.text.toString()).toInt()
        val numTwo: Int = (editTextNumberTwo.text.toString()).toInt()
        val result: Int = numOne * numTwo
        textViewResult.text = result.toString()
    }

    fun divide(view: View) {
        val numOne: Int = (editTextNumberOne.text.toString()).toInt()
        val numTwo: Int = (editTextNumberTwo.text.toString()).toInt()
        val result: Int = numOne / numTwo
        textViewResult.text = result.toString()
    }
}
