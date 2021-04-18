package com.keshav.basictutorials.lifecycle

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.keshav.basictutorials.R
import kotlinx.android.synthetic.main.activity_first.*

class FirstActivity : AppCompatActivity() {
    private val TAG = "LifeCycleExample"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
        btn.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("dt",Message("Keshav"))
            startActivity(intent)
        }
        Log.d(TAG,"FA - onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG,"FA - onStart")
    }
    override fun onResume() {
        super.onResume()
        Log.d(TAG,"FA - onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG,"FA - onPause")

    }
    override fun onRestart() {
        super.onRestart()
        Log.d(TAG,"FA - onRestart")
    }
    override fun onStop() {
        super.onStop()
        Log.d(TAG,"FA - onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"FA - onDestroy")
    }

}