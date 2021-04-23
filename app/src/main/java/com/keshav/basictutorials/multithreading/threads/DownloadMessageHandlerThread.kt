package com.keshav.basictutorials.multithreading.threads

import android.os.Looper

class DownloadMessageHandlerThread() : Thread() {
    val TAG = "ThreadExample"
    lateinit var mactivity: ThreadActivity
    lateinit var mhandler: DownloadHandler
    
    override fun run() {
        Looper.prepare()
        mhandler = DownloadHandler()
        if (::mactivity.isInitialized){
            mhandler.mactivity = mactivity
        }
        Looper.loop()
    }

}