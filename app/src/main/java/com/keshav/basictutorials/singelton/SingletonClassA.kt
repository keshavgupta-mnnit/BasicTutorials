package com.keshav.basictutorials.singelton

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.keshav.basictutorials.R
import kotlinx.android.synthetic.main.activity_first.*

class SingletonClassA : AppCompatActivity() {
    private val TAG = "LifeCycleExample"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
        tv.text = FavoriteFood.dishName
        btn.setOnClickListener {
            FavoriteFood.dishName = "ROLL"
            val intent = Intent(this, SingletonClassB::class.java)
            startActivity(intent)
        }
    }
}