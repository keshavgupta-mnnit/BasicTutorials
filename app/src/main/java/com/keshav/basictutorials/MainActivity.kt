package com.keshav.basictutorials

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.keshav.basictutorials.multithreading.asyncloader.AsyncLoaderActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        launchLifeCycleExample()
    }

    private fun launchLifeCycleExample() {
        val intent = Intent(this, AsyncLoaderActivity::class.java)
        startActivity(intent)
    }
}