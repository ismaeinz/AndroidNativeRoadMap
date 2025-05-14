package com.example.services.app.counter

//noinspection SuspiciousImport
import android.R
import android.app.Service
import android.content.Intent
import android.os.IBinder
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
            counter.start().collect { counterValue ->
                notification(counterValue)
            }
        }
    }

    //    create Notification
    private fun notification(counterValue: Int) {
        val counterNotification = NotificationCompat.Builder(this, "counter_channel")
            .setSmallIcon(R.drawable.stat_notify_more).setContentTitle("Counter")
            .setContentText(counterValue.toString()).build()
        startForeground(1, counterNotification)

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