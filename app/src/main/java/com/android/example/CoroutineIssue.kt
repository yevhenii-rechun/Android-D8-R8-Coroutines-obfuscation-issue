package com.android.example

import kotlinx.coroutines.delay

class CoroutineIssue : Parent {

    suspend fun doSomeHeavyWork(param: String): String {
        delay(5_000)
        return "We are done. Your parameter: $param"
    }
}