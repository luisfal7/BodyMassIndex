package com.bodymassindex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.util.rangeTo
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.pow
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculate.setOnClickListener {

            textViewResult.text = calculatorBodyMassIndex().toString()

            textViewWeightStatus.text = weightStatusResult()

        }

    }

    private fun weightStatusResult(): String {

        var underWeight = "For the information you entered:\n" +
                "\n" +
                "Height: ${editTextHeightCentimeters.getText()} meters\n" +
                "\n" +
                "Weight: ${editTextWeightKilograms.getText()} kilograms\n" +
                "\n" +
                "Your BMI is ${textViewResult.getText()}, indicating your weight is in the Underweight category for adults of your height.\n" +
                "\n" +
                "For your height, a normal weight range would be from ${normalLowWeight()} to ${normalHighWeight()} kilograms.\n" +
                "\n" +
                "Talk with your healthcare provider to determine possible causes of underweight and if you need to gain weight."

        var normal = "For the information you entered:\n" +
                "\n" +
                "Height: ${editTextHeightCentimeters.getText()} meters\n" +
                "\n" +
                "Weight: ${editTextWeightKilograms.getText()} kilograms\n" +
                "\n" +
                "Your BMI is ${textViewResult.getText()}, indicating your weight is in the Normal category for adults of your height.\n" +
                "\n" +
                "For your height, a normal weight range would be from ${normalLowWeight()} to ${normalHighWeight()} kilograms.\n" +
                "\n" +
                "Maintaining a healthy weight may reduce the risk of chronic diseases associated with overweight and obesity."

        var overWeight = "For the information you entered:\n" +
                "\n" +
                "Height: ${editTextHeightCentimeters.getText()} meters\n" +
                "\n" +
                "Weight: ${editTextWeightKilograms.getText()} kilograms\n" +
                "\n" +
                "Your BMI is ${textViewResult.getText()}, indicating your weight is in the Overweight category for adults of your height.\n" +
                "\n" +
                "For your height, a normal weight range would be from ${normalLowWeight()} to ${normalHighWeight()} kilograms.\n" +
                "\n" +
                "People who have overweight or obesity are at higher risk for chronic conditions such as high blood pressure, diabetes, and high cholesterol.\n" +
                "If you are overweight, try to avoid gaining additional weight. If you are overweight with other risk factors for chronic diseases, try to lose weight. Other risk factors include high LDL cholesterol, low HDL cholesterol, and high blood pressure.\n" +
                "Even a small weight loss, such as losing 10% of your current weight, may help lower the risk of disease. Talk with your healthcare provider to determine appropriate ways to lose weight.\n" +
                "\n" +
                "For information about the importance of a healthy diet and physical activity in reaching a healthy weight, visit Healthy Weight."


        var obese = "For the information you entered:\n" +
                "\n" +
                "Height: ${editTextHeightCentimeters.getText()} meters\n" +
                "\n" +
                "Weight: ${editTextWeightKilograms.getText()} kilograms\n" +
                "\n" +
                "Your BMI is ${textViewResult.getText()}, indicating your weight is in the Obese " +
                "category for adults of your height.\n" +
                "\n" +
                "For your height, a normal weight range would be from ${normalLowWeight()} to ${normalHighWeight()} kilograms.\n" +
                "\n" +
                "People who are overweight or obese are at higher risk for chronic conditions " +
                "such as high blood pressure, diabetes, and high cholesterol\n" +
                "\n" +
                "If you are overweight, try to avoid gaining additional weight. If you are overweight " +
                "with other risk factors for chronic diseases, try to lose weight. Other risk factors " +
                "include high LDL cholesterol, low HDL cholesterol, and high blood pressure.\n" +
                "Even a small weight loss, such as losing 10% of your current weight, may help lower " +
                "the risk of disease. Talk with your healthcare provider to determine appropriate ways " +
                "to lose weight.\n" +
                "\n" +
                "For information about the importance of a healthy diet and physical activity in " +
                "reaching a healthy weight, visit Healthy Weight."

        var weightStatusResult = when {
                calculatorBodyMassIndex() < 18.5 -> underWeight
                calculatorBodyMassIndex() in 18.5..25.0 -> normal
                calculatorBodyMassIndex() in 25.0..30.0 -> overWeight
                calculatorBodyMassIndex() > 30 -> obese
                else -> "Error"
        }
        return weightStatusResult
    }

    private fun calculatorBodyMassIndex(): Float {

        val editWeight: Float = editTextWeightKilograms.text.toString().toFloat()
        val editHeight: Float = editTextHeightCentimeters.text.toString().toFloat()

        return (editWeight / (editHeight*editHeight))
    }

    private fun normalLowWeight(): Float {
        val editHeight: Float = editTextHeightCentimeters.text.toString().toFloat()
        val normalLowWeight: Float = 18.5f

        val resultNormalLowWeight: Float = normalLowWeight*editHeight.pow(2)
        return (resultNormalLowWeight)
    }

    private fun normalHighWeight(): Float {
        val editHeight: Float = editTextHeightCentimeters.text.toString().toFloat()
        val normalHighWeight: Float = 25.0f

        val resultNormalHighWeight: Float = normalHighWeight*editHeight.pow(2)
        return (resultNormalHighWeight)
    }
}