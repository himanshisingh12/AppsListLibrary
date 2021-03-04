package com.example.appslist

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fetchapps.AppLists
import com.example.fetchapps.AppSummaryList

class MainActivity : AppCompatActivity() {
    lateinit var installedAppAdapter: AppListAdapter
    lateinit var searchView: SearchView
    lateinit var recyclerView: RecyclerView
    lateinit var list: List<AppSummaryList>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recycler_view)
        searchView = findViewById(R.id.search_view)


        list = AppLists().getInstalledApps(context = this)!!


        if (list!!.isNotEmpty()) {
            installedAppAdapter = AppListAdapter(list)
            val layoutManager = LinearLayoutManager(applicationContext)
            recyclerView.layoutManager = layoutManager
            recyclerView.adapter = installedAppAdapter
            installedAppAdapter.notifyDataSetChanged()

        }

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                filter(newText);
                return false
            }
        })


    }

    private fun filter(text: String) {
        val filteredlist: ArrayList<AppSummaryList> = ArrayList()

        for (item in list) {
            if (item.name.toLowerCase().contains(text.toLowerCase())) {
                filteredlist.add(item)
            }
        }
        if (filteredlist.isEmpty()) {
            Toast.makeText(this, "No Data Found..", Toast.LENGTH_SHORT).show()
        } else {
            installedAppAdapter.filterList(filteredlist)
        }
    }

}