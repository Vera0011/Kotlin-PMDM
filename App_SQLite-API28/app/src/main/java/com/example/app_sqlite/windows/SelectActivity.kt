package com.example.app_sqlite.windows

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.app_sqlite.R
import com.example.app_sqlite.database.DatabaseManager


class SelectActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select)
    }

    override fun onStart()
    {
        super.onStart()
        val btnNavigate: Button = findViewById(R.id.insert)

        btnNavigate.setOnClickListener(View.OnClickListener {
            // Create an Intent to start SecondActivity
            val intent = Intent(this@SelectActivity, InsertActivity::class.java)
            this.finish();
            startActivity(intent);
        })
    }
}