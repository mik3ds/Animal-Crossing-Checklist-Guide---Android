package com.mikec.achnchecklistguide

import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.content.Intent
import android.net.Uri
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

        val twitterButton: ImageButton = findViewById(R.id.ib_twitter)
        twitterButton.setOnClickListener{
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://www.twitter.com/MikeCDev1")
            startActivity(openURL)
        }

        val patreonButton: ImageButton = findViewById(R.id.ib_patreon)
        patreonButton.setOnClickListener{
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://www.patreon.com/MikeCDev")
            startActivity(openURL)
        }



    }
}