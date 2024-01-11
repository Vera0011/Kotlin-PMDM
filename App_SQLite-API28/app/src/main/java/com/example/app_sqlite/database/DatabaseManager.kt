package com.example.app_sqlite.database

import android.annotation.SuppressLint
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseManager(context: Context) : SQLiteOpenHelper(context, "user_database.db", null, 1)
{
    @SuppressLint("Range")
    override fun onCreate(db: SQLiteDatabase) {
        val db = readableDatabase;
        db.execSQL("CREATE TABLE Test(id INTEGER NOT NULL);");
        db.execSQL("INSERT INTO Test VALUES(2)");
        val cursor: Cursor = db.rawQuery("SELECT * FROM Test", null)

        while (cursor.moveToNext()) {
            println(cursor.getString(cursor.getColumnIndex("id")));
        }

        cursor.close();
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {

    }
}