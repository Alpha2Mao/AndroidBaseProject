package com.example.androidbaseproject;

import android.app.Application;
import android.content.Context;
import android.os.Environment;

import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.tencent.bugly.crashreport.CrashReport;
import com.tencent.mars.xlog.Log;
import com.tencent.mars.xlog.Xlog;

import shark.HprofIndex;
import xcrash.XCrash;


public class AndroidApplication extends Application {
    private static final String TAG = AndroidApplication.class.getSimpleName();

    private static final String mLogPath = Environment.getExternalStorageDirectory().getPath();


    @Override
    public void onCreate() {
        super.onCreate();
        CrashReport.initCrashReport(getApplicationContext(), "02c1bf8860", false);
        initXlogSdk();
        initBaiduMapSdk();
    }


    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        initXCrash();
    }

    /**
     * 初始化Xlog SDK
     */
    private void initXlogSdk(){
        String SDCARD = Environment.getExternalStorageDirectory().getPath();
        String logPath = SDCARD + "/" + getPackageName() + "/log";

        // this is necessary, or may crash for SIGBUS
        String cachePath = this.getFilesDir() + "/xlog";
        String logFileName = "app_log";

        //init xlog
        Xlog xlog = new Xlog();
        Log.setLogImp(xlog);

        if (BuildConfig.DEBUG) {
            Log.setConsoleLogOpen(true);
            Log.appenderOpen(Xlog.LEVEL_DEBUG, Xlog.AppednerModeAsync, cachePath, logPath, logFileName, 0);
        } else {
            Log.setConsoleLogOpen(false);
            Log.appenderOpen(Xlog.LEVEL_INFO, Xlog.AppednerModeAsync, cachePath, logPath, logFileName, 0);
        }
    }

    /**
     * 初始化xcrash组件
     */
    private void initXCrash(){
        String xcrashLogPath = mLogPath + "/" + getPackageName() + "/log/xcrash";
        xcrash.XCrash.init(this, new XCrash.InitParameters()
                .setLogDir(xcrashLogPath)
        );
    }

    /**
     * 初始化百度sdk
     */
    private void initBaiduMapSdk(){
        SDKInitializer.initialize(this);
        SDKInitializer.setCoordType(CoordType.BD09LL);
    }

    static {
        System.loadLibrary("c++_shared");
        System.loadLibrary("marsxlog");
    }
}
