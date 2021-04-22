package com.keshav.basictutorials.threads

import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.keshav.basictutorials.R
import kotlinx.android.synthetic.main.activity_thread.*

class ThreadActivity : AppCompatActivity() {
    val TAG = "ThreadExample"
    private val message = "Running Thread"
    lateinit var downloadMessageHandlerThread: DownloadMessageHandlerThread
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thread)
        init()

        downloadMessageHandlerThread = DownloadMessageHandlerThread()
        downloadMessageHandlerThread.name = "DownloadMessageHandlerThread"
        downloadMessageHandlerThread.mactivity = this
        downloadMessageHandlerThread.start()

    }

    private fun init() {
        btn.setOnClickListener {
//            handlerRunnableExample()
//            createNewThreadExample()
//            threadClassParallelExample()
            handlerThreadMessageExample()
//            runOnUIThreadExample()
        }
    }

    fun showProgressBar(show: Boolean) {
        progress.visibility = if (show) {
            View.VISIBLE
        } else {
            View.GONE
        }
    }

    fun appendMessage(message: String) {
        tv.append("\n$message")
        Log.i(TAG, message)
    }

    private fun handlerRunnableExample() {
        showProgressBar(true)
        appendMessage(message)
        val runnable = Runnable {
            Log.i(TAG, "Running")
            showProgressBar(false)
        }
        val handler = Handler()
        handler.postDelayed(runnable, 4000)

    }

    private fun createNewThreadExample() {
        showProgressBar(true)
        Log.i(TAG, Thread.currentThread().name)
        appendMessage(message)
        val runnable = Runnable {
            Log.i(TAG, "Started")
            Thread.sleep(4000)
            Log.i(TAG, Thread.currentThread().name)
            Log.i(TAG, "Completed")
        }
        val thread = Thread(runnable)
        thread.name = "Download Thread"
        thread.start()
    }

    private fun getSongsList(): List<String> {
        return listOf("Dard-e-Disco", "Chikni Chameli", "Sheela ki jawani")
    }

    //   Will create multiple thread at a same time to download all the songs parallelly
    private fun threadClassParallelExample() {
        appendMessage(message)
        val songsList = getSongsList()
        for (song in songsList) {
            val downloadThread = DownloadThread(song)
            downloadThread.start()
        }
    }

    private fun handlerThreadMessageExample() {
        val songsList = getSongsList()
        appendMessage("Download Started")
        for (song in songsList) {
            val msg = Message.obtain()
            msg.obj = song
            downloadMessageHandlerThread.mhandler.sendMessage(msg)
        }
    }

    //    Can be achieved same thing in downloadMessageHandlerThread by passing the reference
    //    of given activity as a constructor parameter and use the func in the handler class uncomment
    //    line 23 for handlerThreadMessageExample
    private fun runOnUIThreadExample() {
        showProgressBar(true)
        appendMessage(message)
        val thread = Thread(Runnable {
            Log.i(TAG, "Started")
            Thread.sleep(4000)
            runOnUiThread {
                appendMessage("Completed")
                showProgressBar(false)
            }
        })
        thread.name = "Download Thread"
        thread.start()
    }


}