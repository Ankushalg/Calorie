package com.allstudio.calorie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_calorie.*

class CalorieFragment  : Fragment() {
    private val items = listOf("Bicycling", "Dancing", "Yoga", "Jumping Rope", "Body Stretching", "Swimming", "Walking")
    private var currentItem = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_calorie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.let{
            spinner.adapter = ArrayAdapter(it, android.R.layout.simple_spinner_dropdown_item, items)
            spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                    currentItem = position
                }
                override fun onNothingSelected(parent: AdapterView<*>?) {}
            }
        }
        bReturn.setOnClickListener{
            lCal.visibility = View.VISIBLE
            lResults.visibility = View.GONE
        }
        bCalculate.setOnClickListener{
            val time = eTime.text.toString()
            if(time.isNotEmpty()){
                calculateCalories(time.toDouble())
            } else {
                Toast.makeText(activity, "Please Enter Time to calculate Calories Burn", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun calculateCalories(time: Double) {
        lCal.visibility = View.GONE
        lResults.visibility = View.VISIBLE
        val t = "$time Minutes"
        tTime.text = t
        tWork.text = items[currentItem]
        tBurn.text = getCalorieBurn(time)
    }

    private fun getCalorieBurn(time: Double): String {
        return when (currentItem) {
            0 -> String.format("%.2f CAL", 3.8 * time)
            1 -> String.format("%.2f CAL", 6.6 * time)
            2 -> String.format("%.2f CAL", 4.6 * time)
            3 -> String.format("%.2f CAL", 13 * time)
            4 -> String.format("%.2f CAL", 2.8 * time)
            5 -> String.format("%.2f CAL", 12.1 * time)
            6 -> String.format("%.2f CAL", 5 * time)
            else -> String.format("%.2f CAL", 4 * time)
        }
    }
}
