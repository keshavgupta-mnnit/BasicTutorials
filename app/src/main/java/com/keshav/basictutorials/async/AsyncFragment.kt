package com.keshav.basictutorials.async

import android.content.Context
import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment

class AsyncFragment : Fragment() {
    val TAG = "AsyncExample"
    lateinit var mtaskHandler: TaskHandler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    interface TaskHandler{
        fun handleTask(msg : String)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(TAG, "onAttach: Fragment Attached")
        if(context is TaskHandler){
            mtaskHandler = context
        }
    }

    fun performDownload(vararg params: String?){
        val myTask = MyTask()
        myTask.execute(*params)
    }

    inner class MyTask : AsyncTask<String, String, String>() {
        override fun doInBackground(vararg params: String?): String {
            for (value in params) {
                if(isCancelled){
                    publishProgress("Cancelled")
                    break
                }
                Log.i(TAG, "doInBackground - $value")
                publishProgress(value)
                Thread.sleep(3000)
            }
            return "Download Finished"
        }

        override fun onProgressUpdate(vararg values: String?) {
            values[0]?.let { mtaskHandler.handleTask(it) }
        }

        override fun onPostExecute(result: String?) {
            if (result != null) {
                mtaskHandler.handleTask(result)
            }
        }

        override fun onCancelled() {
            mtaskHandler.handleTask("Download Cancelled")
        }

    }
}