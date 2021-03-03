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

    lateinit var lifecycleObserver: MyObserver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lifecycleObserver = MyObserver()
        lifecycle.addObserver(lifecycleObserver)

        counter.text = TOTAL_COUNT.toString()
    }

    private fun makeIncrement(){
        counter.text = (++TOTAL_COUNT).toString()
    }

    override fun onPause() {
        super.onPause()
        makeIncrement()
    }

    fun goToSquare(view: View) {
        val intent = Intent(this, SquareActivity::class.java)
        intent.putExtra("total_count", TOTAL_COUNT)
        startActivity(intent)
    }
}