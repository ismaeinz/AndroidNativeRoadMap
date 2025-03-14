package com.example.flow

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.zip
import kotlinx.coroutines.runBlocking

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {


            runBlocking {
                var f1 = flow<Int> {
                    for (i in 1..4) {
                        emit(i)
                        delay(1000)
                    }
                }
                var f2 = flow<String> {
                    val list = listOf<String>("a", "b", "c")
                    for (i in list) {
                        emit(i)
                        delay(1000)
                    }
                }

//                    .filter { i -> i < 5 }
//                    .buffer()
//                    .collect {
//                        Log.d("i is  :", it.toString())
//                    }
                f1.zip(f2) { a: Int, b: String -> "$a:$b" }
                    .collect {
                        Log.d("here", it)
                    }
            }
        }
    }
}

