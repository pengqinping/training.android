package com.twp.fullscreen

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.twp.base.systemui.statusbar.StatusBarCompat

class GuideActivity : AppCompatActivity() {

   /* //set color for status bar
    StatusBarCompat.setStatusBarColor(Activity activity, int color)
    //add alpha to color
    StatusBarCompat.setStatusBarColor(Activity activity, int statusColor, int alpha)

    //translucent status bar
    StatusBarCompat.translucentStatusBar(activity);
    //should hide status bar background (default black background) when SDK >= 21
    StatusBarCompat.translucentStatusBar(Activity activity, boolean hideStatusBarBackground);

    //set color for CollapsingToolbarLayout
    setStatusBarColorForCollapsingToolbar(Activity activity, AppBarLayout appBarLayout, CollapsingToolbarLayout collapsingToolbarLayout,
    Toolbar toolbar, int statusColor)

    //Change to Light status bar (convert icon and text color to dark, SDK >= 23)
    changeToLightStatusBar(Activity activity)

    //Cancel Light status bar (convert icon and text color to light)
    cancelLightStatusBar(Activity activity)*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guide)
        // set StatusBar background transparent
        StatusBarCompat.setStatusBarColor(this, Color.TRANSPARENT)
        // 设置状态栏字体颜色为黑色
        StatusBarCompat.setLightStatusBar(window,true)
        // set FullScreen in Layout
        setFullScreenWithStatusBar()
        setFullScreenHideNavigation()
    }

    // 系统状态栏隐藏
    private fun setFullScreenWithStatusBar(){
        var uiVisibility = window.decorView.systemUiVisibility
        uiVisibility = uiVisibility.or(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN)
        window.decorView.systemUiVisibility = uiVisibility
    }

    // 系统导航栏隐藏
    private fun setFullScreenHideNavigation(){
        var uiVisibility = window.decorView.systemUiVisibility
        uiVisibility = uiVisibility.or(View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION).or(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION)
        if(Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
            uiVisibility = uiVisibility.or(View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)
        }
        window.decorView.systemUiVisibility = uiVisibility
    }
}
