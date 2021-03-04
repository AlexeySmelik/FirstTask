package com.example.firsttask

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    companion object{
        const val TOTAL_COUNT = "123"
    }

    private var totalCount: Int = 0

    private lateinit var lifecycleObserver: MyObserver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lifecycleObserver = MyObserver()
        lifecycle.addObserver(lifecycleObserver)

        counter.text = totalCount.toString()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        counter.text = (++totalCount).toString()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(TOTAL_COUNT, totalCount)
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        totalCount = savedInstanceState.getInt(TOTAL_COUNT)
    }

    fun goToSquare(view: View) {
        val intent = Intent(this, SquareActivity::class.java)
            .apply { putExtra(TOTAL_COUNT, totalCount) }
        startActivity(intent)
    }
}