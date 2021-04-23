package com.keshav.basictutorials.async

import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.keshav.basictutorials.R
import kotlinx.android.synthetic.main.activity_thread.*

class AsyncActivity : AppCompatActivity(), AsyncFragment.TaskHandler {

    val TAG = "AsyncExample"
    val fragmentTag = "FRAGMENT_TAG"
    private var myTaskRunning: Boolean = false
    private var asyncFragment: AsyncFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thread)
        init()

        val manager = supportFragmentManager
        asyncFragment = manager.findFragmentByTag(fragmentTag) as AsyncFragment?
        if (asyncFragment == null) {
            asyncFragment = AsyncFragment()
            manager.beginTransaction().add(asyncFragment!!, fragmentTag).commit()
        }
    }

    private fun init() {
        btn.setOnClickListener {
            asyncFragment?.performDownload("Dard-e-Disco", "Chikni Chameli", "Sheela ki jawani")
        }
    }

    private fun appendMessage(message: String) {
        tv.append("\n$message")
        Log.i(TAG, message)
    }

    override fun handleTask(msg: String) {
        appendMessage(msg)
    }


}