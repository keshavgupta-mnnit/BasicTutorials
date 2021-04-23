package com.keshav.basictutorials.multithreading.async

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

    /* Async task provide multiple functionality like to showprogress and it also works efficiently with ui related task
     But the main problem it is not able to handle the configuration changes if it defined in this class
     because it will hold the reference of old activity that is destroyed while rotating the screen.
     So here we are using a hack to declare it in a fragment and as we know fragment does able to survive config changes,
     so it will works efficiently */

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

    //    This will ensure that onscreen rotation it will hold the currentActivity context to perform this task
    override fun handleTask(msg: String) {
        appendMessage(msg)
    }


}