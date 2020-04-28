package com.mikec.achnchecklistguide

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class AboutActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
        val backButton: ImageView = findViewById(R.id.iv_about_back)

        backButton.setOnClickListener{
            onBackPressed()
        }

    }
}