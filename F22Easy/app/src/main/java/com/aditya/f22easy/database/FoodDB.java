package com.aditya.f22easy.database;

import android.provider.BaseColumns;

public class FoodDB {

    private FoodDB(){

    }

    public static class FoodIteEntry implements BaseColumns {
        public static final String TABLE_NAME = "food";
        public static final String COLUMN_NAME_FOOD_CATEGORY = "category";
        public static final String COLUMN_NAME_PRICE = "price";
        public static final String COLUMN_NAME_FOOD_TITLE = "title";
    }

}
