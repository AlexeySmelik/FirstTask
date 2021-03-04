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
    companion object{
        const val TOTAL_COUNT = "123"
    }

    private var total_count: Int = 0

    lateinit var lifecycleObserver: MyObserver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_square)

        lifecycleObserver = MyObserver()
        lifecycle.addObserver(lifecycleObserver)

        total_count = intent.getIntExtra(TOTAL_COUNT, 0)
        counter.text = (total_count * total_count).toString()
    }

    fun goToMain(view: View) {
        finish()
    }
}