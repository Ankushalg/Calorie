package com.allstudio.calorie

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer

class LaunchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch)
        supportActionBar?.hide()
        object: CountDownTimer(2000, 2000){
            override fun onTick(milli: Long){}
            override fun onFinish(){
                val i = Intent(this@LaunchActivity, MainActivity::class.java)
                startActivity(i)
            }
        }.start()
    }
}
