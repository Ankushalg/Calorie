package com.allstudio.calorie

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class CategoryAdapter(fm: FragmentManager, behavior: Int) : FragmentPagerAdapter(fm, behavior) {
    override fun getItem(position: Int): Fragment {
        return if(position == 0){
            BMIFragment()
        } else {
            CalorieFragment()
        }
    }

    override fun getCount(): Int {
        return 2
    }

}