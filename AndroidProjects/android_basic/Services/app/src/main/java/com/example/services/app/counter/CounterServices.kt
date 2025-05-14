package com.example.services.app.counter

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import androidx.core.app.NotificationCompat
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CounterServices : Service() {
    private val counter = Counter()
    override fun onBind(intent: Intent?): IBinder? = null
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        when (intent?.action) {
            CounterAction.START.name -> start()
            CounterAction.STOP.name -> stop()
        }
        return super.onStartCommand(intent, flags, startId)
    }

    private fun start() {
        CoroutineScope(Dispatchers.Default).launch {
            counter.start().collect { itStart ->
                Log.d("counterx", itStart.toString())
            }
        }
    }

    //    create Notification
    private fun notification() {
        val counterNotification = NotificationCompat.Builder(this, "")
    }


//

    private fun stop() {
        CoroutineScope(Dispatchers.Default).launch {
            counter.stop()
            stopSelf()
        }
    }

    enum class CounterAction {
        START, RESUME, RESTART, PAUSE, STOP
    }

}