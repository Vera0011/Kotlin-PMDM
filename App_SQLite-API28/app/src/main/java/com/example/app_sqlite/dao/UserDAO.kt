package com.example.app_sqlite.dao

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import com.example.app_sqlite.database.DatabaseManager
import com.example.app_sqlite.dto.UserDTO

class UserDAO
{
    private lateinit var databaseManager : DatabaseManager;

    constructor(context : Context)
    {
        databaseManager = DatabaseManager(context);
    }

    fun insertUser(user : UserDTO)
    {
        val values = ContentValues();

        values.put("dni", user.dni);
        values.put("name", user.name);
        values.put("age", user.age);
        values.put("profession", user.profession);
        values.put("salary", user.salary);

        databaseManager.insert(values);
    }

    fun selectUser(value : String) : ArrayList<UserDTO>
    {
        val cursor_name : Cursor = databaseManager.select("SELECT * FROM Users WHERE name = ?", arrayOf(value));
        val cursor_profession : Cursor = databaseManager.select("SELECT * FROM Users WHERE profession = ?", arrayOf(value));
        val list_names : ArrayList<UserDTO> = ArrayList();
        val list_professions : ArrayList<UserDTO> = ArrayList();

        if(cursor_name.moveToFirst())
        {
            if(cursor_profession.moveToFirst())
            {
                do
                {
                    list_names.add(createUser(cursor_name));
                } while(cursor_name.moveToNext())

                do
                {
                    list_professions.add(createUser(cursor_profession));
                } while(cursor_profession.moveToNext())

                cursor_name.close();
                cursor_profession.close();
            }
        }

        /* Remove duplicates from both lists*/
        val result : ArrayList<UserDTO> = ArrayList();

        result.addAll(list_names);
        result.addAll(list_professions);

        return ArrayList(LinkedHashSet(ArrayList(result)));
    }

    fun update(oldUser : UserDTO, newUser : UserDTO)
    {

    }

    fun delete(oldUser: UserDTO)
    {
        
    }

    private fun createUser(cursor : Cursor) : UserDTO
    {
        return UserDTO(
            cursor.getString(cursor.getColumnIndexOrThrow("dni")),
            cursor.getString(cursor.getColumnIndexOrThrow("name")),
            cursor.getInt(cursor.getColumnIndexOrThrow("age")),
            cursor.getString(cursor.getColumnIndexOrThrow("profession")),
            cursor.getInt(cursor.getColumnIndexOrThrow("salary"))
        );
    }
}