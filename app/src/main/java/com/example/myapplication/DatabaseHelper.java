package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQuery;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "MED_C.db";
    public static final String TABLE_USERS = "Table_User";
    public static final String TABLE_ORDERS = "Table_Orders";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String table_users = "CREATE TABLE " + TABLE_USERS + "(username primary key, fullname TEXT ,password TEXT)";
        String table_orders = "CREATE TABLE " + TABLE_ORDERS + "(order_id INTEGER primary key autoincrement, " +
                " buyersName TEXT, prodName TEXT, prodImage INTEGER ,prodTotalPrice DOUBLE, prodQuan INTEGER)";
        db.execSQL(table_users);
        db.execSQL(table_orders);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + TABLE_USERS);
        db.execSQL("drop table if exists " + TABLE_ORDERS);
    }

    public Boolean insertUser(String username, String fullname, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("fullname", fullname);
        contentValues.put("password", password);
        long result = db.insert(TABLE_USERS, null, contentValues);
        if (result == -1) return false;
        else
            return true;
    }

    public Boolean checkUsername(String username) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from " + TABLE_USERS + " where username=?", new String[]{username});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    public Cursor getFullNameAndEmail() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from " + TABLE_USERS , null);
        return cursor;
    }



    public Boolean checkUsernamePassword(String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from " + TABLE_USERS + " where username=? and password=?", new String[]{username, password});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    public boolean insertOrder(String buyersName, String prodName, int prodImage, double prodPrice, int prodQuan) {
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("buyersName", buyersName);
        contentValues.put("prodName", prodName);
        contentValues.put("prodImage", prodImage);
        contentValues.put("prodTotalPrice", prodPrice);
        contentValues.put("prodQuan", prodQuan);
        long id = db.insert(TABLE_ORDERS, null, contentValues);
        if (id <= 0) return false;
        else
            return true;
    }
    public Cursor whoOrder(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from " + TABLE_ORDERS , null);
        return cursor;
    }

}
