package com.example.andrei.customkeyboard;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Asad Mahmood on 01-06-2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="text.db";
    public static final String TABLE_1="text_table";
    public static final String TABLE_2="words_table";

    private final Context mCtx;
    private static DatabaseHelper mInstance = null;
    public int DATABASE_VERSION = 1;

    public static DatabaseHelper getInstance(Context ctx) {
        /**
         * use the application context as suggested by CommonsWare.
         * this will ensure that you dont accidentally leak an Activitys
         * context (see this article for more information:
         * http://android-developers.blogspot.nl/2009/01/avoiding-memory-leaks.html)
         */

        if (mInstance == null) {
            mInstance = new DatabaseHelper(ctx.getApplicationContext());
        }
        return mInstance;
    }

    private DatabaseHelper(Context ctx) {
        super(ctx, DATABASE_NAME, null, 1);
        this.mCtx = ctx;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL( " create table " + TABLE_1 + " ( id INTEGER PRIMARY KEY AUTOINCREMENT,text TEXT ) " );
        db.execSQL( " create table " + TABLE_2 + " ( id INTEGER PRIMARY KEY AUTOINCREMENT,words TEXT ) " );
   }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_1 );
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_2 );
        onCreate(db);
    }

    public boolean insertData_text(String quote) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("text",quote);
        long result = db.insert( TABLE_1 , null , contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    public Cursor getAllData_text()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery( " select * from " + TABLE_1 , null );
        return res;
    }

    public boolean insertData_words(String quote) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("words",quote);
        long result = db.insert( TABLE_2 , null , contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    public Cursor getAllData_words()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery( " select * from " + TABLE_2 , null );
        return res;
    }
}
