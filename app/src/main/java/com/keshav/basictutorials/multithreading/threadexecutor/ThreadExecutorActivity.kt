package com.keshav.basictutorials.multithreading.threadexecutor

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.keshav.basictutorials.R
import kotlinx.android.synthetic.main.activity_thread.*
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class ThreadExecutorActivity : AppCompatActivity() {
    val TAG = "ThreadExecutorExample"
    lateinit var executorService: ExecutorService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thread)
        init()
        executorService = Executors.newFixedThreadPool(5) // creating thread pool of 5 threads
    }

    private fun init() {
        btn.setOnClickListener {
//            creating 15 task and assigned them to executor so probably every thread execute 3 tasks in parallel with each other
            for (i in 1..15) {
                executorService.execute(WorkExecutor(i))
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        executorService.shutdown()
    }
}