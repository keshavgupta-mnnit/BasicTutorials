package com.keshav.basictutorials.multithreading.threads

import android.util.Log

class DownloadThread(val songName: String) : Thread() {
    val TAG = "ThreadExample"
    override fun run() {
        downloadSong()
    }

    private fun downloadSong() {
        Log.d(TAG, "Download Started")
        sleep(4000)
        Log.d(TAG, "$songName Downloaded")
    }
}