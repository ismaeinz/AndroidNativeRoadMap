package com.example.intent.app.intent

import android.provider.Settings
import android.provider.Settings.Global.AIRPLANE_MODE_ON
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext

//class Test {
//    lateinit var name: String
//    lateinit var age: String
//}
//
////apply , also تستخدم لاعاده التعيين
//var nameApply: Test = Test().apply {
//    name = ""
//}
//
//
//var nameAlso: Test = Test().also {
//    it.name = ""
//}

@Composable
fun Intentx(modifier: Modifier = Modifier) {
    val context = LocalContext.current

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

//        Button(onClick = {
//
//            context.startActivity(
//                Intent(context, SecondActivity::class.java)
//            )
//
//
//        }) {
//            Text(text = "Start ")
//        }

//        Button(onClick = {
//            val intent = Intent(Intent.ACTION_MAIN)
//            intent.apply {
//                `package` = "com.google.android.youtube"
//            }
//
//            startActivity(context, intent, null)
//
//
//        }) {
//            Text(text = "Youtube ")
//        }

        var get: Int = Settings.Global.getInt(context.contentResolver, AIRPLANE_MODE_ON, 0)
        var text = if (get == 0) {
            Text(text = "0")

        } else {
            Text(text = "1")

        }
        Text(text = text.toString())


    }
}


