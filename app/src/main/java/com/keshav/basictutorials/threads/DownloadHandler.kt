package com.keshav.basictutorials.threads

import android.os.Handler
import android.os.Message
import android.util.Log

class DownloadHandler : Handler() {
    val TAG = "ThreadExample"
    lateinit var mactivity: ThreadActivity
    override fun handleMessage(msg: Message) {
        val song = msg.obj.toString()
        if (::mactivity.isInitialized) {
            mactivity.runOnUiThread { mactivity.showProgressBar(true) }
            downloadSongAndUpdateUI(song)
        } else {
            downloadSong(song)
        }
    }

    private fun downloadSong(songName: String) {
        Log.d(TAG, "Download Started")
        Thread.sleep(4000)
        Log.d(TAG, "$songName Downloaded")
    }

    private fun downloadSongAndUpdateUI(songName: String) {
        Log.d(TAG, "Download Started")
        Thread.sleep(4000)

        mactivity.runOnUiThread {
            mactivity.appendMessage("$songName Downloaded")
            mactivity.showProgressBar(false)
        }
    }
}