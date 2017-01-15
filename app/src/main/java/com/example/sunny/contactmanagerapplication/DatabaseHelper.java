package com.example.sunny.contactmanagerapplication;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "contacts.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "contacts";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

        // database create
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = "CREATE TABLE " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,MOBILE_NUMBER INTEGER,EMAIL TEXT)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS" + TABLE_NAME;
        onCreate(db);
    }


    public boolean insertData(String name, int mobile_number, String email) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("NAME", name);
        contentValues.put("MOBILE_NUMBER", mobile_number);
        contentValues.put("EMAIL", email);


        long result = db.insert(TABLE_NAME, null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    // search
    public Cursor getData(String mobile_number) {

        int number = Integer.parseInt(mobile_number);

        SQLiteDatabase db = this.getWritableDatabase();

        String sql = "select * from " + TABLE_NAME + "where MOBILE_NUMBER = '" + number + "'";
        Cursor cursor = db.rawQuery(sql, null);
        return cursor;

    }

    // delete
    public void deleteData(String mobile_number) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, "MOBILE_NUMBER = '" + mobile_number + "'", null);
        db.close();
    }


    // update
    public void updateData(String number, String name, String email) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues content = new ContentValues();
        content.put("NAME", name);
        content.put("MOBILE_NUMBER", number);
        content.put("EMAIL", email);

        db.update(TABLE_NAME, content, "MOBILE NUMBER = '" + number + "'", null);
        db.close();
    }


}