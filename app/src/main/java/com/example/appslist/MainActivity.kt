package com.example.appslist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fetchapps.AppLists
import com.example.fetchapps.AppSummaryList

class MainActivity : AppCompatActivity() {
    lateinit var installedAppAdapter: AppListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)



       val list: List<AppSummaryList> = AppLists().getInstalledApps(context = this)!!

        Log.d("TAG", list.toString())


        if (list!!.isNotEmpty()) {
            installedAppAdapter = AppListAdapter(appList = list!!)
            val layoutManager = LinearLayoutManager(applicationContext)
            recyclerView.layoutManager = layoutManager
            recyclerView.adapter = installedAppAdapter
        }


    }

}