package com.keshav.basictutorials

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.keshav.basictutorials.lifecycle.FirstActivity
import com.keshav.basictutorials.lifecycle.Message
import com.keshav.basictutorials.lifecycle.SecondActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        launchLifeCycleExample()
    }

    private fun launchLifeCycleExample() {
        val intent = Intent(this, FirstActivity::class.java)
        startActivity(intent)
    }
}