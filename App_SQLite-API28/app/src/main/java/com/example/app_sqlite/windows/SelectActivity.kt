package com.example.app_sqlite.windows

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.app_sqlite.R


class SelectActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select)

        /** val btnNavigate: Button = findViewById(R.id.insert)

        btnNavigate.setOnClickListener(View.OnClickListener {
            // Create an Intent to start SecondActivity
            val intent = Intent(this@SelectActivity, InsertActivity::class.java)
            startActivity(intent)
        })*/
    }
}