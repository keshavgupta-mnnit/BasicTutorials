package com.keshav.basictutorials.multithreading.asyncloader

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.loader.app.LoaderManager
import androidx.loader.content.AsyncTaskLoader
import androidx.loader.content.Loader
import com.keshav.basictutorials.R
import kotlinx.android.synthetic.main.activity_thread.*

class AsyncLoaderActivity : AppCompatActivity(), LoaderManager.LoaderCallbacks<String> {
    val TAG = "AsyncLoaderExample"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thread)
        init()
    }

    private fun init() {
        btn.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("data_key", "url")
            //will cache the data for the given id
            supportLoaderManager.initLoader(100, bundle, this)
                .forceLoad() // will trigger the onCreateLoader

            // will create new one if doesn't exist for the given id or restart the same one
            // supportLoaderManager.restartLoader(100, bundle, this)
        }
    }

    private fun appendMessage(message: String) {
        tv.append("\n$message")
        Log.i(TAG, message)
    }

    override fun onCreateLoader(id: Int, args: Bundle?): Loader<String> {
        return TaskLoader(this, args)
    }

    override fun onLoadFinished(loader: Loader<String>, data: String?) {
        data?.let { appendMessage(it) }
    }

    override fun onLoaderReset(loader: Loader<String>) {
        appendMessage("Loader Reset")
    }

    class TaskLoader(context: Context, val args: Bundle?) : AsyncTaskLoader<String>(context) {
        val TAG = "AsyncLoaderExample"

        override fun loadInBackground(): String? {
            val data = args?.getString("data_key")
            Log.d(TAG, "[loadInBackground - Started] Thread Name - ${Thread.currentThread().name}")
            Log.d(TAG, "[loadInBackground] Data: $data")
            Thread.sleep(4000)
            Log.d(
                TAG,
                "[loadInBackground - Completed] Thread Name - ${Thread.currentThread().name}"
            )
            return "Finished"
        }

        // This will modify data before sending it to main thread using this func.
        override fun deliverResult(data: String?) {
            val mdata = "$data: Modified"
            super.deliverResult(mdata)
        }

    }

}