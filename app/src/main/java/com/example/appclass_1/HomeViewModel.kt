package com.example.appclass_1

import android.os.CountDownTimer
import android.util.Log
import androidx.lifecycle.ViewModel

class HomeViewModel:ViewModel() {
    var TAG = HomeViewModel::class.java.simpleName
    lateinit var timer: CountDownTimer
    var _seconds:Int =  0

    var count = 0

    fun incrementCount(){
        count++
    }
    fun startTimer() {
        timer = object :CountDownTimer(10_000,1_000){
            override fun onTick(millisUntilFinished: Long) {
                _seconds = millisUntilFinished.toInt()
                Log.i(TAG, "time remaining ="+millisUntilFinished.toInt())
            }

            override fun onFinish() {
                Log.i(TAG,"countdown has finished")
            }

        }.start()

    }
}