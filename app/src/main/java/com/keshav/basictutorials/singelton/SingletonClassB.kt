package com.keshav.basictutorials.singelton

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.keshav.basictutorials.R
import kotlinx.android.synthetic.main.activity_second.*

class SingletonClassB : AppCompatActivity() {
    private val TAG = "SingletonExample"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        tv_second.text = FavoriteFood.dishName
    }
}