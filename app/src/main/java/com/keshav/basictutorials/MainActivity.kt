package com.keshav.basictutorials

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.keshav.basictutorials.threads.ThreadActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        launchLifeCycleExample()
    }

    private fun launchLifeCycleExample() {
        val intent = Intent(this, ThreadActivity::class.java)
        startActivity(intent)
    }
}