package com.example.app

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i("first", "this is start first")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }
}