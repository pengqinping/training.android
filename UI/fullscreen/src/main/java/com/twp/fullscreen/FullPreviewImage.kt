package com.twp.fullscreen

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.twp.base.systemui.statusbar.StatusBarCompat
import kotlinx.android.synthetic.main.activity_full_preview_image.*

/**
 * 全屏预览图片效果
 * 状态栏动态显示
 */
class FullPreviewImage : AppCompatActivity() {

    private var toBeHideSystemStatusBar = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_full_preview_image)
        // set StatusBar background transparent
        StatusBarCompat.setStatusBarColor(this, Color.TRANSPARENT)
        // 设置状态栏字体颜色为黑色
        StatusBarCompat.setLightStatusBar(window,false)
        // set FullScreen in Layout
        setFullScreenWithStatusBar()
        setFullScreenHideNavigation()

        imgPreview.setOnClickListener {
            toBeHideSystemStatusBar = if(toBeHideSystemStatusBar){
                topView.visibility = View.GONE
                window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
                false
            } else {
                topView.visibility = View.VISIBLE
                window.clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
                true
            }
        }
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
