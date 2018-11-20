package com.aditya.f22easy.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class FoodDBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 8;
    public static final String DATABASE_NAME = "F22FoodDB.db";

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + FoodDB.FoodIteEntry.TABLE_NAME + " (" +
                    FoodDB.FoodIteEntry._ID + " INTEGER PRIMARY KEY," +
                    FoodDB.FoodIteEntry.COLUMN_NAME_FOOD_CATEGORY + " TEXT," +
                    FoodDB.FoodIteEntry.COLUMN_NAME_FOOD_TITLE + " TEXT," +
                    FoodDB.FoodIteEntry.COLUMN_NAME_PRICE + " DOUBLE)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + FoodDB.FoodIteEntry.TABLE_NAME;

    public FoodDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
// This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);

    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

    public void delete(SQLiteDatabase db){
        db.delete(FoodDB.FoodIteEntry.TABLE_NAME,null,null);
    }

}
