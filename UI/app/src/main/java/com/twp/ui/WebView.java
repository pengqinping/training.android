package com.twp.ui;

import android.content.Context;
import android.util.AttributeSet;

/**
 * Created by Royal on 2021/7/18.
 */
class WebView extends android.webkit.WebView {
    public WebView(Context context) {
        super(context);
    }

    public WebView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public WebView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public WebView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
}
