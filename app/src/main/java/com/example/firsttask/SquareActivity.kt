package com.example.firsttask

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
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

        TOTAL_COUNT = intent.getIntExtra("total_count", 0)
        counter.text = (TOTAL_COUNT * TOTAL_COUNT).toString()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt("total_count", TOTAL_COUNT)
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        TOTAL_COUNT = savedInstanceState.getInt("total_count")
        counter.text = (TOTAL_COUNT * TOTAL_COUNT).toString()
    }

    fun goToMain(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}