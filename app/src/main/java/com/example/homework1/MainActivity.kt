package com.example.homework1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.txt)

        counter = savedInstanceState?.getInt(COUNTER_ID, 0) ?: 0
        textView.text = counter.toString()

        val button = findViewById<Button>(R.id.btn)

        button.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra(COUNTER_ID, counter)
            startActivity(intent)
        }

        Log.d(LIFECYCLE_TAG, "onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.d(LIFECYCLE_TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(LIFECYCLE_TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(LIFECYCLE_TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(LIFECYCLE_TAG, "onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(LIFECYCLE_TAG, "onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(LIFECYCLE_TAG, "onDestroy")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        counter = savedInstanceState.getInt(COUNTER_ID)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(COUNTER_ID, counter + 1)
        super.onSaveInstanceState(outState)
    }

    companion object {
        const val COUNTER_ID = "counter_id"
        const val LIFECYCLE_TAG = "MainActivity"
    }
}
