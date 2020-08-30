package com.ashehata.remote_config

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        checkIsAppEnabled()
    }

    private fun checkIsAppEnabled() {
        isAppEnabled {
            if (it) {
                Toast.makeText(this, "Ready to use the app", Toast.LENGTH_SHORT).show()
            } else {
                showDialog()
            }
        }
    }

    private fun showDialog() {
        AlertDialog.Builder(this)
            .setTitle("Warning")
            .setCancelable(false)
            .setPositiveButton("Close") { _, _ ->
                finish()
            }.show()
    }

}