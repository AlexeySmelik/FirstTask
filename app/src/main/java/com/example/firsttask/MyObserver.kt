package com.example.firsttask

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent

class MyObserver : LifecycleObserver {
    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    fun makeLog(source: LifecycleOwner, event: Lifecycle.Event){
        Log.i(source.toString().takeLast(source.toString().length - 12), event.toString())
    }
}