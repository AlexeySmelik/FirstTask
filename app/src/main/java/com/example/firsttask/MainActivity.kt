package com.example.firsttask

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    companion object {
        var TOTAL_COUNT: Int = 0
        const val TAG: String = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i(TAG, "First activity has been Created")
        setContentView(R.layout.activity_main)

        counter.text = TOTAL_COUNT.toString()
        makeIncrement()
    }

    private fun makeIncrement(){
        counter.text = (++TOTAL_COUNT).toString()
    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG, "First activity has been Started")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "First activity has been Destroyed")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i(TAG, "First activity has been Restarted")
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG, "First activity has been Resumed")
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG, "First activity has been Paused")
    }

    fun goToSquare(view: View) {
        val intent = Intent(this, SquareActivity::class.java)
        intent.putExtra("total_count", TOTAL_COUNT)
        startActivity(intent)
    }

}