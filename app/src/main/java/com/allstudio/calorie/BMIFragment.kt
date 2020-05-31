package com.allstudio.calorie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_bmi.*
import kotlin.math.pow
import kotlin.math.roundToLong

class BMIFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_bmi, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bCalculate.setOnClickListener{
            val height = eHeight.text.toString()
            val weight = eWeight.text.toString()
            if(height.isNotEmpty()){
                if(weight.isNotEmpty()){
                    showBMIResults(height.toDouble(), weight.toDouble())
                } else {
                    Toast.makeText(activity, "Please Enter Weight to calculate BMI", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(activity, "Please Enter Height to calculate BMI", Toast.LENGTH_SHORT).show()
            }
        }
        bReturn.setOnClickListener{
            lCalculate.visibility = View.VISIBLE
            lResults.visibility = View.GONE
        }
    }

    private fun showBMIResults(height: Double, weight: Double) {
        lCalculate.visibility = View.GONE
        lResults.visibility = View.VISIBLE
        val bmi: Double = calculateBMI(height, weight)
        tBmiIndex.text = String.format("%.2f",bmi)
        tBmiCategory.text = getBmiCategory(bmi)
        tBmiInfo.text = getBmiInfo(bmi)
    }

    private fun calculateBMI(height: Double, weight: Double): Double {
        return (weight / (height / 100).pow(2.0) * 10.0).roundToLong() / 10.0
    }

    private fun getBmiCategory(bmi: Double): String {
        if (bmi < 15)  return "Very severely underweight"
        if (bmi < 16) return "Severely underweight"
        if (bmi < 18.5) return "Underweight"
        if (bmi < 25) return "Normal (healthy weight)"
        if (bmi < 30) return "Overweight"
        if (bmi < 35) return "Obese Class I (Moderately obese)"
        if (bmi < 40) return "Obese Class II (Severely obese)"
        if (bmi < 45) return "Obese Class III (Very severely obese)"
        if (bmi < 50) return "Obese Class IV (Morbidly Obese)"
        if (bmi < 60) return "Obese Class V (Super Obese)"
        return "Obese Class VI (Hyper Obese)"
    }

    private fun getBmiInfo(bmi : Double): String {
        if (bmi < 18.5) return "A BMI of less than 18.5 indicates that you are underweight, so you may need to put on some weight. You are recommended to ask your doctor or a dietitian for advice."
        if (bmi < 25) return "Your BMI indicates that you are at a healthy weight for your height. By maintaining a healthy weight, you lower your risk of developing serious health problems"
        if (bmi < 30) return "A BMI of 25-29.9 indicates that you are slightly overweight. You may advised to loose some weight for health reasons. You are recommended to talk to your doctor or a dietitian for advice."
        return "A BMI of over 30 indicates that you are heavily overweight. Your health may be at risk if you do not loose weight. You are recommended to talk to your doctor or a dietitian for advice."
    }
}
