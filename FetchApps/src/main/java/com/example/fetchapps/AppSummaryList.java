package com.example.fetchapps;

import android.graphics.drawable.Drawable;

public class AppSummaryList {
    private String name;
    private String packages;
    private String mainActivity;
    private String versionCode;
    private String versionName;
    Drawable icon;


    public AppSummaryList(String name, Drawable icon, String packages, String mainActivity,
    String versionCode, String versionName) {
        this.name = name;
        this.packages = packages;
        this.mainActivity = mainActivity;
        this.versionCode = versionCode;
        this.versionName = versionName;
        this.icon = icon;

    }

    public String getName() {
        return name;
    }
    public Drawable getIcon() {
        return icon;
    }
    public String getPackages() {
        return packages;
    }
    public String getMainActivity() {
        return mainActivity;
    }
    public String getVersionCode() {
        return versionCode;
    }
    public String getVersionName() {
        return versionName;
    }

}


