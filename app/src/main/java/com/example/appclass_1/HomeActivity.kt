package com.example.appclass_1

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.appclass_1.network.MarsAdapter
import com.example.appclass_1.network.MarsApi
import com.example.appclass_1.network.MarsPhoto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import com.example.appclass_1.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    //lateinit var brake:Int?
    private lateinit var binding: ActivityHomeBinding
    lateinit var listMarsPhotos:List<MarsPhoto>
    lateinit var marsAdapter: MarsAdapter
    // lateinit var imageView: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        listMarsPhotos = ArrayList<MarsPhoto>()
        marsAdapter = MarsAdapter(listMarsPhotos)
        binding.recyclerView.adapter = marsAdapter
        // brake
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //  if(intent.extras != null) {
        var data = intent.extras?.getString("nkey")
        binding.tvHome.setText(data)
    }
    override fun onStart() {
        super.onStart()
        binding.btnGet.setOnClickListener{
            getMarsPhotos()
        }
    }
    private fun getMarsPhotos() {
        GlobalScope.launch (Dispatchers.Main){
            //doing time taking tasks on the main thread is not advisable

            val listMarsPhoto = MarsApi.retrofitService.getPhotos()
            marsAdapter.listMarsPhotos = listMarsPhoto
            binding.imageView.load(listMarsPhoto.get(0).imgSrc)
            marsAdapter.notifyItemRangeChanged(0,listMarsPhoto.size)
            //  listMarsPhotos  = listMarsPhoto
            //marsAdapter.notifyDataSetChanged()
            Log.i("HomeActivity-1st imgsrc",listMarsPhoto.get(0).imgSrc)
        }
    }
}