package com.example.androidbaseproject;

import android.app.Application;
import android.util.Log;

import com.dianping.logan.Logan;
import com.dianping.logan.LoganConfig;
import com.tencent.bugly.crashreport.CrashReport;

import java.io.File;

public class AndroidApplication extends Application {
    private static final String TAG = AndroidApplication.class.getSimpleName();
    @Override
    public void onCreate() {
        super.onCreate();
        CrashReport.initCrashReport(getApplicationContext(), "02c1bf8860", false);
        initLoganSdk();
    }

    private void initLoganSdk(){
        LoganConfig config = new LoganConfig.Builder()
                .setCachePath(getApplicationContext().getFilesDir().getAbsolutePath())
                .setPath(getApplicationContext().getExternalFilesDir(null).getAbsolutePath()
                        + File.separator + "logan_v1")
                .setEncryptIV16("0123456789012345".getBytes())
                .setEncryptKey16("0123456789012345".getBytes())
                .build();
        Logan.init(config);
        Logan.setDebug(true);
        Logan.w("Logan is init", 2);
        Log.d(TAG, "The file path is " + getApplicationContext().getExternalFilesDir(null).getAbsolutePath()
                + File.separator + "logan_v1");
        Log.d(TAG, "The setEncryptIV16 is " + "0123456789012345".getBytes());
        Log.d(TAG, "The setEncryptKey16 is " + "0123456789012345".getBytes());
    }
}
