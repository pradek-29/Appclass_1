package com.example.appclass_1

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appclass_1.network.MarsAdapter
import com.example.appclass_1.network.MarsApi
import com.example.appclass_1.network.MarsPhoto
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class HomeActivity : AppCompatActivity() {
    //lateinit var brake:Int?
    lateinit var recyclerview: RecyclerView
    lateinit var listMarsPhotos: List<MarsPhoto>
    lateinit var marsAdapter: MarsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        recyclerview = findViewById(R.id.recyclerView)
        recyclerview.layoutManager = LinearLayoutManager(this)
        listMarsPhotos = ArrayList<MarsPhoto>()
        marsAdapter = MarsAdapter(listMarsPhotos)
        recyclerview.adapter = marsAdapter
        // brake
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //  if(intent.extras != null) {
        var data = intent.extras?.getString("nkey")
        Log.i("HomeActivity", "data is = " + data)
        val homeTextView: TextView = findViewById(R.id.tvHome)
        homeTextView.setText(data)

    }

    fun getJson(view: View) {
        getMarsPhotos()
    }

    private fun getMarsPhotos() {
        GlobalScope.async {
            val listMarsPhoto = MarsApi.retrofitService.getPhotos()
            listMarsPhotos = listMarsPhoto
            marsAdapter.notifyItemRangeChanged(0, listMarsPhotos.size)
            Log.i("HomeActivity-1st imgsrc", listMarsPhoto.get(0).imgSrc)

        }
    }
}

