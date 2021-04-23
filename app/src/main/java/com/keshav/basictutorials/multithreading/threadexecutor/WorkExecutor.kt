package com.keshav.basictutorials.multithreading.threadexecutor

import android.util.Log

class WorkExecutor(var taskNo: Int) : Runnable{
    val TAG = "ThreadExecutorExample"
    override fun run() {
        Log.i(TAG,"[Started] - ${Thread.currentThread().name} for task $taskNo")
        Thread.sleep(4000)
        Log.i(TAG,"[Completed] - ${Thread.currentThread().name} for task $taskNo")
    }
}