package com.example.megaphone.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class dbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NOMBRE = "agenda.db";
    public static final String TABLE_KEYS = "t_api_keys";

    public dbHelper(@Nullable Context context) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_KEYS + "(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "tipo TEXT NOT NULL," +
                "keys TEXT NOT NULL,");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_KEYS);
        onCreate(sqLiteDatabase);

    }
}
