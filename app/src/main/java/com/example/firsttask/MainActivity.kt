package com.example.firsttask

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    companion object {
        var TOTAL_COUNT: Int = 0
    }

    lateinit var lifecycleObserver: MyObserver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lifecycleObserver = MyObserver()
        lifecycle.addObserver(lifecycleObserver)

        counter.text = TOTAL_COUNT.toString()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        counter.text = (++TOTAL_COUNT).toString()
    }

    fun goToSquare(view: View) {
        val intent = Intent(this, SquareActivity::class.java)
            .apply { putExtra("total_count", TOTAL_COUNT) }
        startActivity(intent)
    }
}