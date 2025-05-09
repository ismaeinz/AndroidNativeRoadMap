package com.example.context_intent

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.context_intent.ui.theme.Context_IntentTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Context_IntentTheme {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Spacer(modifier = Modifier.size(20.dp))
                    OpenYoutubeApp()

                }
            }
        }
    }
}


@Composable
fun OpenYoutubeApp() {
    val context = LocalContext.current
    val packageManager = context.packageManager
    Button(
        onClick = {
            Intent(Intent.ACTION_MAIN).also {
                it.`package` = "com.google.android.youtube"
                context.startActivity(it)

            }
        }) {
        Text(" Open Youtube App")
    }
    Button(
        onClick = {
            val intent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_EMAIL, arrayListOf("youremailid@gmail.com"))
                putExtra(Intent.EXTRA_SUBJECT, "This is the subject of the mail")
                putExtra(Intent.EXTRA_TEXT, "This is the text part of the mail")
            }
            if (intent.resolveActivity(packageManager) != null) {
                context.startActivity(intent)
            }
        }) {
        Text("Send Email")
    }

}