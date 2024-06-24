package com.example.appclass_1

import androidx.lifecycle.ViewModel

class HomeViewModel:ViewModel() {
    var count = 0

    fun incrementCount(){
        count++
    }
}