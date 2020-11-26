package com.example.androidbaseproject;

import android.app.Application;

import com.tencent.bugly.crashreport.CrashReport;

public class AndroidApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        CrashReport.initCrashReport(getApplicationContext(), "02c1bf8860", false);
    }
}
