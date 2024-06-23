package com.example.appclass_1
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.widget.TextView

class DataAdaper(var data: Array<String>) : RecyclerView.Adapter<DataAdaper.DataViewHolder>() {

    var TAG = DataAdaper::class.java.simpleName
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        Log.i(TAG,"avinash bought a row plank-- gave it to prateek")
        var rowPlank = LayoutInflater.from(parent.context).inflate(R.layout.row_plank,parent,false)
        return DataViewHolder(rowPlank)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(prateekholder: DataViewHolder, position: Int) {
        Log.i("DataAdapter","tv farhan writing  --"+data[position])
        prateekholder.tvRowItem.setText(data[position])

    }

    class DataViewHolder(rowPlank:View):RecyclerView.ViewHolder(rowPlank) {
        init {
            Log.i("DataAdapter","prateek is trying to find the textview on the row - farhan")
        }
        var tvRowItem = itemView.findViewById<TextView>(R.id.tvRow)

    }
}