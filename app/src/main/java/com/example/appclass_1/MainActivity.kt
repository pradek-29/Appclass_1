package com.example.appclass_1

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.AlarmClock
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    var TAG = "MainActivity"

    //chick is getting created in the egg  --- memory is being allocated for the activity
    override fun onCreate(savedInstanceState: Bundle?) {  //method header or signature
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i(TAG,"activity created")
    }

    //chick has hatched  --- activity is visible for clicks
    override fun onStart() {
        super.onStart()
        Log.i(TAG,"activity started")

    }

    //chick has woken up -- come back to the foreground
    override fun onResume() {
        super.onResume()
        Log.i(TAG,"activity resumed")

    }

    //chick has slept  --is partially visible -- background
    override fun onPause() {
        super.onPause()
        Log.i(TAG,"activity paused")

    }

    //activity hibernated
    override fun onStop() {
        super.onStop()
        Log.i(TAG,"activity stopped")

    }

    //all the resources are purged
    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG,"activity destroyed")

    }
    fun myClickHandler(view: View) {
        Log.i("MainActivity","button clicked")
        var hIntent = Intent(this,HomeActivity::class.java)
        hIntent.putExtra("nkey","pradek-android")
        startActivity(hIntent)
    }



}