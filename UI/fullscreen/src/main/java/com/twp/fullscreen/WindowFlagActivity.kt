package com.twp.fullscreen

import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_window_flag.*

/**
 * Created by pengqinping on 2019/5/15.
 * @email pengqinping@hotmail.com
 * @description
 */
class WindowFlagActivity : AppCompatActivity() {

    var inFullScreen = false
    /**
     * 去掉 系统样式的 Title
     * 1.设置Activity 的 Theme 为： Theme.AppCompat.Light.NoActionBar"
     * 2.在Activity中设置requestWindowFeature(Window.FEATURE_NO_TITLE) 需要在 setContentView之前
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_window_flag)
        buttonSetFullScreenWithFlag.setOnClickListener {
            setFullScreenWithFlag(!inFullScreen)
            setFlagTitle()
        }
        buttonSetFullScreenWithAttribute.setOnClickListener {
            setFullScreenWithAttribute(!inFullScreen)
            setFlagTitle()
        }
        cbWindowFlag.setOnCheckedChangeListener { buttonView, isChecked ->
             enableLayoutNoLimits()
        }
        cbWindowFlagLayoutInScreen.setOnCheckedChangeListener{ buttonView, isChecked ->
            enableLayoutInScreen()
        }
        setFlagTitle()
    }

    private fun setFlagTitle(){
        tvFlagTitle.text ="window attribute is : $inFullScreen"
    }
    private fun enableLayoutNoLimits(){
        if(cbWindowFlag.isChecked) {
            window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        }else{
            window.clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        }
    }

    private fun enableLayoutInScreen(){
        if(cbWindowFlagLayoutInScreen.isChecked){
            window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN)
        } else {
            window.clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN)
        }
    }

    /**
     * 等价调用：1 == 2 == 3
     * 1. window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
     * 2. window.attributes.flags = window.attributes.flags or WindowManager.LayoutParams.FLAG_FULLSCREEN
     * 3. window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
     */
    private fun setFullScreenWithFlag(toFullScreen: Boolean){

        if(toFullScreen){
            inFullScreen = true
            window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        }else{
            inFullScreen = false
            window.clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        }
    }

    /**
     * 等价调用：1 == 2 == 3
     * 1. window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
     * 2. window.attributes.flags = window.attributes.flags or WindowManager.LayoutParams.FLAG_FULLSCREEN
     * 3. window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
     */
    private fun setFullScreenWithAttribute(toFullScreen: Boolean) {
        if (toFullScreen) {
            inFullScreen = true
            val lp = window.attributes
            lp.flags = lp.flags or WindowManager.LayoutParams.FLAG_FULLSCREEN
            window.attributes = lp
        } else {
            inFullScreen = false
            val attr = window.attributes
            attr.flags = attr.flags and WindowManager.LayoutParams.FLAG_FULLSCREEN.inv()
            window.attributes = attr
        }
    }


}