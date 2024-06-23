package com.example.appclass_1

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.appclass_1.network.MarsApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class HomeActivity : AppCompatActivity() {
    //lateinit var brake:Int?
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        // brake
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //  if(intent.extras != null) {
        var data = intent.extras?.getString("nkey")
        Log.i("HomeActivity","data is = "+data)
        val homeTextView:TextView = findViewById(R.id.tvHome)
        homeTextView.setText(data)
    }
    override fun onStart() {
        super.onStart()
    }

    fun getJson(view: View) {
        getMarsPhotos()
    }

    private fun getMarsPhotos() {
        GlobalScope.launch {
            val listResult=MarsApi.retrofitService.getPhotos()
            Log.i("HomeActivity",listResult)
        }
    }
}