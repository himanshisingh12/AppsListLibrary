package com.example.appslist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fetchapps.AppSummaryList

class AppListAdapter(private var appList: List<AppSummaryList>) :
    RecyclerView.Adapter<AppListAdapter.MyViewHolder>() {

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var name: TextView = view.findViewById(R.id.list_app_name)
        var packageName: TextView = view.findViewById(R.id.app_package)
        var versionCode: TextView = view.findViewById(R.id.app_version_code)
        var versionName: TextView = view.findViewById(R.id.app_version_name)
        var mainActivity: TextView = view.findViewById(R.id.app_main_activity)
        var appIcon: ImageView = view.findViewById(R.id.app_icon)



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.installed_app_list, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val apps = appList[position]
        holder.name.text = apps.name
        holder.packageName.text = apps.packages
        holder.versionCode.text = apps.versionCode
        holder.versionName.text = apps.versionName
        holder.mainActivity.text = apps.mainActivity

        Glide
            .with(holder.itemView.context)
            .load(apps.icon)
            .centerCrop()
            .into(holder.appIcon);

    }

    override fun getItemCount(): Int {
        return appList.size
    }
}