package com.twp.fullscreen

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvWindowFlag.setOnClickListener {
            startActivity(Intent(this, WindowFlagActivity::class.java))
        }

        btnDecoerView.setOnClickListener {

            startActivity(Intent(this, DecorViewSystemUiVisibilityActivity::class.java))

        }
        btnThemeFullScree.setOnClickListener {
            startActivity(Intent(this, FullScreenInThemeActivity::class.java))
        }
        btnOpenGuide.setOnClickListener {
            startActivity(Intent(this, GuideActivity::class.java))
        }
        btnFullPreview.setOnClickListener {
            startActivity(Intent(this, FullPreviewImage::class.java))
        }
        btnNotchCompat.setOnClickListener {
            startActivity(Intent(this@MainActivity, NotchCampactActivity::class.java))
        }
    }
}
