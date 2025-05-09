

//
//        setContent {
//            runBlocking {
////            producer
//                flow<Int> {
//                    for (i in 1..100) {
//                        emit(i)
//                    }
//                }
//                    //                intermediate
//                    .filter { i -> i > 99 }
//                    //
//                    //            collector
//                    .buffer()
//                    .collect {
//                        Log.d("collect", it.toString())
//                    }
//            }
//        }
//    }
//}


////Channels
//        setContent {
//            val kotlinChannel = Channel<String>()
//            val charList = arrayOf<String>("A", "B", "C", "D")
//
//            runBlocking {
//                launch {
//                    for (char in charList) {
//                        kotlinChannel.send(char)
//                    }
//                }
//
//                launch {
//                    for (char in kotlinChannel) {
//                        Log.d("charIs", char)
//                    }
//                }
//
//            }
//        }
//    }
//}


////        job
//        setContent {
//            val job = GlobalScope.launch {
//                launch { getUserFromDatabase() }
//                launch { getUserFromDatabase() }
//            }
//            job.cancel() //cancel childs if parent cancel
////            if one chiled has filled parent filled
//
//        }
//    }
//}

//private suspend fun getUserFromDatabase(): String {
//    delay(5000)
//    return "getUserFromDatabase"
//}
//
//private suspend fun getUserFromNetwork(): String {
//    delay(2000)
//    return "getUserFromNetwork"
//}


////AsyncAwait
//        setContent {
//            GlobalScope.launch {
//                val dataUser = async { getUserFromNetwork() }
//                val localUser = async { getUserFromDatabase() }
//
//                if (dataUser.await() == localUser.await()) {
//                    Log.d("Here", "Equals")
//                } else {
//                    Log.d("Here", "NotEquals")
//
//                }
//
//            }
//        }
//
//    }
//
//}
//
//private suspend fun getUserFromDatabase(): String {
//    delay(5000)
//    return "getUserFromDatabase"
//}
//
//private suspend fun getUserFromNetwork(): String {
//    delay(2000)
//    return "getUserFromNetwork"
//}
