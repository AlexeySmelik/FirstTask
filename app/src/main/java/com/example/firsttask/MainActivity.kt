package com.example.firsttask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    companion object {
        var TOTAL_COUNT: Int = 0
        const val TAG: String = "MAIN_ACTIVITY"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Toast.makeText(this, "${lifecycle.currentState}", Toast.LENGTH_LONG).show()
        Log.i(TAG, "first activity has been Created")
        setContentView(R.layout.activity_main)

        counter.text = TOTAL_COUNT.toString()
        makeIncrement()
    }

    private fun makeIncrement(){
        counter.text = (++TOTAL_COUNT).toString()
    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG, "first activity has been Started")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "first activity has been Destroyed")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i(TAG, "first activity has been Restarted")
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG, "first activity has been Resumed")
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG, "first activity has been Paused")
    }
}