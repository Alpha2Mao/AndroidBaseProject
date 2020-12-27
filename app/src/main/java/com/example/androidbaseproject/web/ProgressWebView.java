package com.example.androidbaseproject.web;

import android.content.Context;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ProgressBar;

public class ProgressWebView extends WebView {
    private ProgressBar mProgressBar;
    private Context mContext;
    public ProgressWebView(Context context) {
        super(context);
        mProgressBar = new ProgressBar(context, null, android.R.attr.progressBarStyleHorizontal);
        mProgressBar.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 3));
        addView(mProgressBar);
        setWebChromeClient(new MyWebChromeClient(context, mProgressBar));
        setWebViewClient(new MyWebViewClient());
    }
}
