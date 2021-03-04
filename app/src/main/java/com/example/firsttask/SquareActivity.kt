package com.example.firsttask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_square.*

class SquareActivity : AppCompatActivity() {
    companion object{
        const val TOTAL_COUNT = "123"
    }

    private var totalCount: Int = 0

    lateinit var lifecycleObserver: MyObserver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_square)

        lifecycleObserver = MyObserver()
        lifecycle.addObserver(lifecycleObserver)

        totalCount = intent.getIntExtra(TOTAL_COUNT, 0)
        counter.text = (totalCount * totalCount).toString()
    }

    fun goToMain(view: View) {
        finish()
    }
}