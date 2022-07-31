package com.android.example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val memberSignatureOutput = findViewById<TextView>(R.id.tvMemberSignature)
        val coroutineResultOutput = findViewById<TextView>(R.id.tvCoroutineResult)

        val coroutineIssue = CoroutineIssue()
        @Suppress("OPT_IN_USAGE")
        GlobalScope.launch(Dispatchers.Main) {
            val result = coroutineIssue.doSomeHeavyWork("Some parameter")
            coroutineResultOutput.text = result
        }

        memberSignatureOutput.text = CoroutineIssue()::class.members.joinToString("\n")
    }
}