
في Android
تُستخدم الإشعارات (Notifications) لعرض رسائل للمستخدم خارج واجهة التطبيق. يتم ذلك باستخدام الـNotificationManager والـNotificationCompat.Builder الذي ينشئ الاشعار والـNotificationManager يقوم بعرضه

fun showNotification(context: Context) {
val channelId = "my_channel_id"
val notificationId = 1

    // إنشاء القناة (مطلوب للأندرويد 8.0+)
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        val name = "My Channel"
        val descriptionText = "This is my notification channel"
        val importance = NotificationManager.IMPORTANCE_DEFAULT
        val channel = NotificationChannel(channelId, name, importance).apply {
            description = descriptionText
        }
        // تسجيل القناة في النظام
        val notificationManager: NotificationManager =
            context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(channel)
    }

    // بناء الإشعار
    val builder = NotificationCompat.Builder(context, channelId)
        .setSmallIcon(android.R.drawable.ic_dialog_info) // أيقونة صغيرة
        .setContentTitle("عنوان الإشعار")
        .setContentText("هذا هو نص الإشعار.") // نص الإشعار
        .setPriority(NotificationCompat.PRIORITY_DEFAULT)

    // عرض الإشعار
    with(NotificationManagerCompat.from(context)) {
        notify(notificationId, builder.build())
    }
}
شرح الكود:
إنشاء قناة إشعارات (مطلوب فقط في Android 8.0+).

بناء الإشعار باستخدام NotificationCompat.Builder.

إرسال الإشعار باستخدام NotificationManagerCompat.notify.

2. تشغيل الإشعار عند الضغط على زر في Jetpack Compose
   إضافة زر لتشغيل الإشعار
   import android.content.Context
   import android.os.Bundle
   import androidx.activity.ComponentActivity
   import androidx.activity.compose.setContent
   import androidx.compose.foundation.layout.*
   import androidx.compose.material3.*
   import androidx.compose.runtime.*
   import androidx.compose.ui.Modifier
   import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
override fun onCreate(savedInstanceState: Bundle?) {
super.onCreate(savedInstanceState)
setContent {
NotificationScreen(this)
}
}
}

@Composable
fun NotificationScreen(context: Context) {
Column(
modifier = Modifier
.fillMaxSize()
.padding(16.dp),
verticalArrangement = Arrangement.Center
) {
Button(onClick = { showNotification(context) }) {
Text("إظهار الإشعار")
}
}
}
المخرجات:
عند تشغيل التطبيق والضغط على الزر "إظهار الإشعار"، سيظهر إشعار في شريط الإشعارات.

إضافة زر لفتح التطبيق عند الضغط على الإشعار
إذا كنت تريد تشغيل Activity عند النقر على الإشعار، استخدم PendingIntent كما يلي:

import android.app.PendingIntent
import android.content.Intent

fun showNotificationWithIntent(context: Context) {
val channelId = "my_channel_id"
val notificationId = 1

    val intent = Intent(context, MainActivity::class.java).apply {
        flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
    }
    val pendingIntent: PendingIntent = PendingIntent.getActivity(
        context, 0, intent, PendingIntent.FLAG_IMMUTABLE
    )

    val builder = NotificationCompat.Builder(context, channelId)
        .setSmallIcon(android.R.drawable.ic_dialog_info)
        .setContentTitle("عنوان الإشعار")
        .setContentText("اضغط لفتح التطبيق")
        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
        .setContentIntent(pendingIntent) // ربط الإشعار بالنقر
        .setAutoCancel(true) // إزالة الإشعار عند النقر

    with(NotificationManagerCompat.from(context)) {
        notify(notificationId, builder.build())
    }
}
ملاحظات:
تأكد من إضافة Permission لإظهار الإشعارات في AndroidManifest.xml (مطلوبة في Android 13+):

<uses-permission android:name="android.permission.POST_NOTIFICATIONS"/>
في Android 13+، تحتاج إلى طلب إذن POST_NOTIFICATIONS من المستخدم.

بهذا، يكون لديك إشعار متكامل يمكنه إظهار الرسائل للمستخدم، وحتى تشغيل التطبيق عند النقر عليه. 🚀

هل هذه المحادثة مفيدة حتى الآن؟








بحث

استخدم التفكير المنطقي المتعمق


يمكن أن تصدر عن ChatGPT بعض الأخطاء. لذلك يجب التحقق من المعلومات المهمة.
?
