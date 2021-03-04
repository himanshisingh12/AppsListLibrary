package com.example.fetchapps

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import java.util.*
import kotlin.collections.ArrayList


class AppLists {

        fun getInstalledApps(context: Context?): List<AppSummaryList>?{

            val pm = context?.packageManager
            val intent = Intent(Intent.ACTION_MAIN, null)
            intent.addCategory(Intent.CATEGORY_LAUNCHER)


            val apps: MutableList<AppSummaryList> = ArrayList<AppSummaryList>()
            val packs = context?.packageManager?.getInstalledPackages(
                PackageManager.GET_ACTIVITIES or
                        PackageManager.GET_SERVICES or
                        PackageManager.GET_RECEIVERS or
                        PackageManager.GET_PROVIDERS or
                        PackageManager.GET_PERMISSIONS
            )
            for (i in packs?.indices!!) {
                val p = packs[i]

                try {
                    if (pm?.getLaunchIntentForPackage(p.applicationInfo.packageName) != null) {

                        val appName = p.applicationInfo.loadLabel(pm).toString()
                        val icon = p.applicationInfo.loadIcon(pm)
                        val packages = p.applicationInfo.packageName

                        val launchIntent: Intent =
                                context.packageManager.getLaunchIntentForPackage(p.applicationInfo.packageName)!!
                        val mainActivity = launchIntent.component?.className

                        val versionCode = p.versionCode
                        val versionName = p.versionName
                        apps.add(
                            AppSummaryList(
                                appName, icon, packages, mainActivity.toString(),
                                versionCode.toString(), versionName, launchIntent
                            )
                        )
                    }
                } catch (ex: Exception) {
                    ex.printStackTrace();
                }


            }

            Collections.sort(apps, CustomComparator())

            return apps
        }





    class CustomComparator : Comparator<AppSummaryList?> {
        override fun compare(o1: AppSummaryList?, o2: AppSummaryList?): Int {
            return o1?.name?.compareTo(o2?.name!!)!!
        }
    }



}


