package com.example.app_sqlite.database

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.SQLException
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class DatabaseManager(context: Context) : SQLiteOpenHelper(context, "app_sqlite.db", null, 1)
{
    override fun onCreate(db: SQLiteDatabase)
    {
        try
        {
            db.execSQL("CREATE TABLE IF NOT EXISTS Users(" +
                    "dni TEXT PRIMARY KEY," +
                    "name TEXT," +
                    "age INTEGER," +
                    "profession TEXT," +
                    "salary INTEGER);");
        }
        catch (err: SQLException)
        {
            Log.e("DatabaseManager", "Error creating table: " + err.message);
        }
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int)
    {
        try
        {
            db.execSQL("DROP TABLE IF EXISTS Users;");
            onCreate(db);
        }
        catch (err : SQLException)
        {
            Log.e("DatabaseManager", "Error creating table: " + err.message);
        }
    }

    fun insert(params : ContentValues)
    {
        this.writableDatabase.insert("Users", null, params);
        this.close();
    }

    fun select(sql : String, params : Array<String>) : Cursor
    {
        return this.readableDatabase.rawQuery(sql, params);
    }

    fun delete()
    {

    }

    fun update()
    {

    }
}