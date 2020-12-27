package com.example.androidbaseproject.web;

import android.content.Context;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ProgressBar;

public class MyWebChromeClient extends WebChromeClient {
    private Context mContext;
    private ProgressBar mProgressBar;

    public MyWebChromeClient(Context context, ProgressBar progressBar){
        this.mContext = context;
        this.mProgressBar = progressBar;
    }

    @Override
    public void onProgressChanged(WebView view, int newProgress) {
        if (newProgress == 100){
            mProgressBar.setVisibility(View.GONE);
        } else{
            if (mProgressBar.getVisibility() == View.GONE){
                mProgressBar.setVisibility(View.VISIBLE);
                mProgressBar.setProgress(newProgress);
            }
        }
        super.onProgressChanged(view, newProgress);
    }
}
