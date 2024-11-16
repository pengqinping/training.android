package com.twp.fullscreen

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_decoview.*

/**
 * Created by pengqinping on 2019/5/15.
 * @email pengqinping@hotmail.com
 * @description
 */
class DecorViewSystemUiVisibilityActivity : AppCompatActivity() {

    var enable: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_decoview)
//        val flags = View.SYSTEM_UI_FLAG_LAYOUT_STABLE//保持系统的稳定性
//                .or(View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION)//隐藏导航栏的布局，但是SYSTEM_UI_FLAG_HIDE_NAVIGATION不设置不会生效
//                .or(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION)//隐藏号航栏
//                .or(View.SYSTEM_UI_FLAG_IMMERSIVE)//沉浸式，会全屏
//                .or(View.SYSTEM_UI_FLAG_FULLSCREEN) //全屏
//                .or(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN)
//                .or(View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)//粘性沉浸式，下滑和上滑才能显示状态栏和导航栏
//                .or(0x00200000 ) //隐藏导航栏的back键
//                .or(0x00400000 )//隐藏导航栏的home键
//                .or(0x01000000)//隐藏导航栏的recent键
//        window.decorView.systemUiVisibility = flags
//设置布局能够延伸到状态栏(StatusBar)和导航栏(NavigationBar)里面

        addListener()
    }

    private fun addListener(){
        cbFlagLayoutStable.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked) {
                window.decorView.systemUiVisibility = window.decorView.systemUiVisibility.or(View.SYSTEM_UI_FLAG_LAYOUT_STABLE)
            } else {
                window.decorView.systemUiVisibility = window.decorView.systemUiVisibility.and(View.SYSTEM_UI_FLAG_LAYOUT_STABLE.inv())
            }
        }

        cbFlagLayoutHideNavigation.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked) {
                window.decorView.systemUiVisibility = window.decorView.systemUiVisibility.or(View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION)
            } else {
                window.decorView.systemUiVisibility = window.decorView.systemUiVisibility.and(View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION.inv())
            }
        }

        cbFlagHideNavigation.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked) {
                window.decorView.systemUiVisibility = window.decorView.systemUiVisibility.or(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION)
            } else {
                window.decorView.systemUiVisibility = window.decorView.systemUiVisibility.and(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION.inv())
            }
        }

        cbFlagHideNavigation.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked) {
                window.decorView.systemUiVisibility = window.decorView.systemUiVisibility.or(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION)
            } else {
                window.decorView.systemUiVisibility = window.decorView.systemUiVisibility.and(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION.inv())
            }
        }

        cbFlagFullScreen.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked) {
                window.decorView.systemUiVisibility = window.decorView.systemUiVisibility.or(View.SYSTEM_UI_FLAG_FULLSCREEN)
            } else {
                window.decorView.systemUiVisibility = window.decorView.systemUiVisibility.and(View.SYSTEM_UI_FLAG_FULLSCREEN.inv())
            }
        }

        cbFlagLayoutFullScreen.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked) {
                window.decorView.systemUiVisibility = window.decorView.systemUiVisibility.or(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN)
            } else {
                window.decorView.systemUiVisibility = window.decorView.systemUiVisibility.and(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN.inv())
            }
        }

        cbFlagImmersive.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked) {
                window.decorView.systemUiVisibility = window.decorView.systemUiVisibility.or(View.SYSTEM_UI_FLAG_IMMERSIVE)
            } else {
                window.decorView.systemUiVisibility = window.decorView.systemUiVisibility.and(View.SYSTEM_UI_FLAG_IMMERSIVE.inv())
            }
        }
        cbFlagImmersiveSticky.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked) {
                window.decorView.systemUiVisibility = window.decorView.systemUiVisibility.or(View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)
            } else {
                window.decorView.systemUiVisibility = window.decorView.systemUiVisibility.and(View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY.inv())
            }
        }
        cbFlagHideNavBack.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked) {
                window.decorView.systemUiVisibility = window.decorView.systemUiVisibility.or(0x00200000)
            } else {
                window.decorView.systemUiVisibility = window.decorView.systemUiVisibility.and(0x00200000.inv())
            }
        }
        cbFlagHideNavHome.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked) {
                window.decorView.systemUiVisibility = window.decorView.systemUiVisibility.or(0x00400000)
            } else {
                window.decorView.systemUiVisibility = window.decorView.systemUiVisibility.and(0x00400000.inv())
            }
        }
        cbFlagHideNavRecent.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked) {
                window.decorView.systemUiVisibility = window.decorView.systemUiVisibility.or(0x01000000)
            } else {
                window.decorView.systemUiVisibility = window.decorView.systemUiVisibility.and(0x01000000.inv())
            }
        }

    }

}