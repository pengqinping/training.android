package com.twp.fullscreen

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.twp.base.systemui.notch.NotchCompat
import com.twp.base.systemui.statusbar.StatusBarCompat
import kotlinx.android.synthetic.main.activity_notch_campat.*

/**
 * Created by pengqinping on 2019-06-15.
 * @email pengqinping@hotmail.com
 * @description
 */
class NotchCampactActivity : AppCompatActivity() {

    var inFullScreen = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notch_campat)
        StatusBarCompat.setStatusBarColor(this, Color.TRANSPARENT)
        // 设置状态栏字体颜色为黑色
        StatusBarCompat.setLightStatusBar(window,true)
        btnWindowFlag.setOnClickListener {
            setFullScreenWithAttribute(!inFullScreen)
        }

        btnWindowVisibility.setOnClickListener {
            if(inFullScreen) {
                clearLayoutFullScreen()
            } else {
                setFullScreenWithStatusBar()
            }
        }

        btnWindowVisibilityHideStatusbar.setOnClickListener {
            if(inFullScreen){
                clearFullScreen()
            } else {
                setFullScreenWithStatusBarHideBar()
            }
        }


    }

    private fun setNotchFullScreen(){
        NotchCompat.setFullScreenIgnoreNotch(window)
    }

    private fun clearNotchFullScreen(){
        NotchCompat.setFullScreenIgnoreNotch(window)
    }

    private fun setFullScreenWithAttribute(toFullScreen: Boolean) {
        if (toFullScreen) {
            inFullScreen = true
            val lp = window.attributes
            lp.flags = lp.flags or WindowManager.LayoutParams.FLAG_FULLSCREEN
            window.attributes = lp
            setNotchFullScreen()
        } else {
            inFullScreen = false
            val attr = window.attributes
            attr.flags = attr.flags and WindowManager.LayoutParams.FLAG_FULLSCREEN.inv()
            window.attributes = attr
            clearNotchFullScreen()
        }
    }
    // 系统状态栏显示的全屏
    private fun setFullScreenWithStatusBar(){
        inFullScreen = true
        var uiVisibility = window.decorView.systemUiVisibility
        uiVisibility = uiVisibility.or(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN)
        window.decorView.systemUiVisibility = uiVisibility
        setNotchFullScreen()
    }

    private fun clearLayoutFullScreen(){
        inFullScreen = false
        var uiVisibility = window.decorView.systemUiVisibility
        uiVisibility = uiVisibility.and(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN.inv())
        window.decorView.systemUiVisibility = uiVisibility
        clearNotchFullScreen()
    }

    private fun setFullScreenWithStatusBarHideBar(){
        inFullScreen = true
        var uiVisibility = window.decorView.systemUiVisibility
        uiVisibility = uiVisibility.or(View.SYSTEM_UI_FLAG_FULLSCREEN)
        window.decorView.systemUiVisibility = uiVisibility
        setNotchFullScreen()
    }

    private fun clearFullScreen(){
        inFullScreen = false
        var uiVisibility = window.decorView.systemUiVisibility
        uiVisibility = uiVisibility.and(View.SYSTEM_UI_FLAG_FULLSCREEN.inv())
        window.decorView.systemUiVisibility = uiVisibility
        clearNotchFullScreen()
    }
}