package com.example.appclass_1

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    //lateinit var brake:Int?
    var TAG = HomeActivity::class.java.simpleName   //"HomeActivity"
    var data = arrayOf("india", "english", "android", "computers")
    lateinit var mySpinner: Spinner
    lateinit var recyclerview: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        mySpinner = findViewById(R.id.spinner)
        mySpinner.onItemSelectedListener = this
        recyclerview = findViewById(R.id.recyclerview)
        recyclerview.layoutManager = LinearLayoutManager(this)
        var dataAdapter = DataAdaper(data)
        recyclerview.adapter = dataAdapter
        // brake
        /*  ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
              val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
              v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
              insets
          }
        //  if(intent.extras != null) {
              var data = intent.extras?.getString("nkey")
          Log.i("HomeActivity","data is = "+data)
           val homeTextView:TextView = findViewById(R.id.tvHome)
           homeTextView.setText(data)
  */
    }

    override fun onItemSelected(adapter: AdapterView<*>?, view: View?, position: Int, id: Long) {
        var item = adapter?.selectedItem.toString()
        Log.i(TAG, item)
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")
    }
}