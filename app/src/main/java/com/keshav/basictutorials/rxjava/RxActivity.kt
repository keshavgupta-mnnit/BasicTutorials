package com.keshav.basictutorials.rxjava

import android.content.ActivityNotFoundException
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.keshav.basictutorials.R

class RxActivity : AppCompatActivity() {
    val TAG = "RxExample"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        runCode()
    }

    private fun runCode() {
//        runSubject()
//        temp()
    }

//    fun temp() {
//        val redirectIntent = Intent(Intent.ACTION_VIEW)
//        redirectIntent.data?.let {
//            try {
//                startActivity(redirectIntent)
//            } catch (e: ActivityNotFoundException) {
//                Toast.makeText(this, "No Activity found", Toast.LENGTH_LONG).show()
//            }
//        } ?: Toast.makeText(this, "Intent data missing", Toast.LENGTH_LONG).show()
//
//    }
}