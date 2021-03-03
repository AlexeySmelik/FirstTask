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

    lateinit var lifecycleObserver: MyObserver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_square)

        lifecycleObserver = MyObserver()
        lifecycle.addObserver(lifecycleObserver)

        TOTAL_COUNT = intent.getIntExtra("total_count", 0)
        counter.text = (TOTAL_COUNT * TOTAL_COUNT).toString()
    }

    fun goToMain(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}