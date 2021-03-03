package com.example.firsttask

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_square.*
import kotlin.math.max

class SquareActivity : AppCompatActivity() {
    companion object {
        var TOTAL_COUNT: Int = 0
    }

    lateinit var lifecycleObserver: MyObserver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_square)

        lifecycleObserver = MyObserver()
        lifecycle.addObserver(lifecycleObserver)
    }

    override fun onStart() {
        super.onStart()
        TOTAL_COUNT = max(intent.getIntExtra("total_count", 0), TOTAL_COUNT)
        counter.text = (TOTAL_COUNT * TOTAL_COUNT).toString()
    }

    fun goToMain(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}