package com.yyxnb.yyxarch.base

import android.arch.lifecycle.DefaultLifecycleObserver
import android.arch.lifecycle.LifecycleOwner
import android.util.Log

object Java8Observer : DefaultLifecycleObserver {

    override fun onCreate(owner: LifecycleOwner) {
        Log.i("---onCreate", owner.lifecycle.currentState.name)
    }

    override fun onStart(owner: LifecycleOwner) {
        Log.i("---onStart", owner.lifecycle.currentState.name)
    }

    override fun onResume(owner: LifecycleOwner) {
        Log.i("---onResume", owner.lifecycle.currentState.name)
    }

    override fun onPause(owner: LifecycleOwner) {
        Log.i("---onPause", owner.lifecycle.currentState.name)
    }

    override fun onStop(owner: LifecycleOwner) {
        Log.i("---onStop", owner.lifecycle.currentState.name)
    }

    override fun onDestroy(owner: LifecycleOwner) {
        Log.i("---onDestroy", owner.lifecycle.currentState.name)
    }

}