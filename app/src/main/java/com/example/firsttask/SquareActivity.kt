package com.example.firsttask

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_square.*

class SquareActivity : AppCompatActivity() {
    companion object {
        var TOTAL_COUNT: Int = 0
        const val TAG: String = "SquareActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i(TAG, "Second activity has been Created")
        setContentView(R.layout.activity_square)

        TOTAL_COUNT = intent.getIntExtra("total_count", 0)
        counter.text = (TOTAL_COUNT * TOTAL_COUNT).toString()
    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG, "Second activity has been Started")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "Second activity has been Destroyed")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i(TAG, "Second activity has been Restarted")
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG, "Second activity has been Resumed")
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG, "Second activity has been Paused")
    }

    fun goToMain(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}