package com.example.app_sqlite.windows

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.app_sqlite.R
import com.example.app_sqlite.database.DatabaseManager

class SelectActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select)
    }
}