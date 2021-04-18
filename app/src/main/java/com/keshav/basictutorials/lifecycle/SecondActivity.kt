package com.keshav.basictutorials.lifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.keshav.basictutorials.R

class SecondActivity : AppCompatActivity() {
    private val TAG = "LifeCycleExample"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        Log.d(TAG, "SA - onCreate")

    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "SA - onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "SA - onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "SA - onPause")

    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "SA - onRestart")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "SA - onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "SA - onDestroy")
    }
}