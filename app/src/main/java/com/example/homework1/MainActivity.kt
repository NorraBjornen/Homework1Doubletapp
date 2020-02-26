package com.example.homework1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    companion object {
        private val COUNTER_ID = "counter_id"
    }

    private var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.txt)

        counter = savedInstanceState?.getInt(COUNTER_ID, 0) ?: 0
        textView.text = counter.toString()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        counter = savedInstanceState.getInt(COUNTER_ID)
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        outState.putInt(COUNTER_ID, counter)
        super.onSaveInstanceState(outState, outPersistentState)
    }
}
