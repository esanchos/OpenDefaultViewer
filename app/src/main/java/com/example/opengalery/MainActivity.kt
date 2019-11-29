package com.example.opengalery

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.FileProvider
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        helloTextView.setOnClickListener { setup() }
    }

    private fun setup() {
        val file = File("/storage/emulated/0/WhatsApp/Media/WhatsApp Images/Sent/IMG-20191126-WA0014.jpg")
        val intent = Intent(Intent.ACTION_VIEW).setDataAndType(
            file.getUriFromFile(this),
            "image/*"
        ).addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
        startActivity(intent)
    }

    fun File.getUriFromFile(context: Context): Uri {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
            FileProvider.getUriForFile(context, packageName + ".provider", this)
        else
            Uri.fromFile(this)
    }

}
