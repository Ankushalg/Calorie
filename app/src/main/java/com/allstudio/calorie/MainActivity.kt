package com.allstudio.calorie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        tabs.setupWithViewPager(viewpager)
        val adapter = CategoryAdapter(supportFragmentManager, FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT)
        viewpager.adapter = adapter
        viewpager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {}
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}
            override fun onPageSelected(position: Int) {
                if(position == 0){
                    t2.visibility = View.VISIBLE
                    t1.visibility = View.GONE
                    t3.visibility = View.GONE
                    t4.visibility = View.VISIBLE
                } else {
                    t2.visibility = View.GONE
                    t1.visibility = View.VISIBLE
                    t3.visibility = View.VISIBLE
                    t4.visibility = View.GONE
                }
            }
        })
        t2.setOnClickListener{
            viewpager.setCurrentItem(0, true)
        }
        t4.setOnClickListener{
            viewpager.setCurrentItem(1, true)
        }
    }
}

