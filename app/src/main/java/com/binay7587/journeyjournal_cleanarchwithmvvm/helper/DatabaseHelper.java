package com.binay7587.journeyjournal_cleanarchwithmvvm.helper;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    // Database version
    private static final int version = 1;
    // Database name
    private static final String name = "journey";

    String CreateTableSql = "CREATE TABLE IF NOT EXISTS \"user\" (\n" +
            "\t\"id\"\tINTEGER PRIMARY KEY AUTOINCREMENT,\n" +
            "\t\"email\"\tTEXT,\n" +
            "\t\"password\"\tTEXT\n" +
            ")";

    public DatabaseHelper(@Nullable Context context) {
        super(context, name, null, version);
        getWritableDatabase().execSQL(CreateTableSql);
    }

    public void insertUser(ContentValues contentValues) {
        getWritableDatabase().insert("user", "", contentValues);
    }

    public void updateUser(String id, ContentValues contentValues) {
//        getWritableDatabase().update("user", contentValues, "id="+id, null);
        getWritableDatabase().update("user", contentValues, "id=?", new String[]{id});
    }

    public void deleteUser(String id) {
//        getWritableDatabase().delete("user", "id="+id, null);
        getWritableDatabase().delete("user", "id=?", new String[]{id});
    }

    public boolean isLoginSuccessful(String email, String password) {
        String sql = "SELECT COUNT (*) FROM user WHERE (email='" + email + "') AND password='" + password + "'";
        @SuppressLint("Recycle") Cursor cursor = getReadableDatabase().rawQuery(sql, null);
        SQLiteStatement statement = getReadableDatabase().compileStatement(sql);
        long l = statement.simpleQueryForLong();
        if (l == 1) {
            return true;
        } else
            return false;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CreateTableSql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
