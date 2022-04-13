package com.bodymassindex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculate.setOnClickListener {

            textViewResult.text = calculatorBodyMassIndex().toString()

            textViewWeightStatus.text = weightStatusResult().toString()

        }

    }

    private fun weightStatusResult(): String {

        val weightStatusResult =
            when {
            calculatorBodyMassIndex() < 18.5 -> "below"

                calculatorBodyMassIndex() > 30 -> "Obese"
            else -> "Error"
        }
        return weightStatusResult
    }

    private fun calculatorBodyMassIndex(): Float {

        val editWeight: Float = editTextWeightKilograms.text.toString().toFloat()
        val editHeight: Float = editTextHeightCentimeters.text.toString().toFloat()

        return (editWeight / (editHeight.pow(2)))
    }
}