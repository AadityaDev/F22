package com.aditya.f22easy;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.BaseColumns;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.TextView;

import com.aditya.f22easy.constants.Currencies;
import com.aditya.f22easy.constants.FoodCategories;
import com.aditya.f22easy.database.FoodDB;
import com.aditya.f22easy.database.FoodDBHelper;
import com.aditya.f22easy.fragments.FoodFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    private Bundle bundle;

    private List<FoodItem> foodItemList;
    private FoodItemAdapter foodItemAdapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;

    private FoodDBHelper foodDBHelper = new FoodDBHelper(this);

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment = null;
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    readDB(FoodCategories.Indian);
                    foodItemAdapter = new FoodItemAdapter(foodItemList);
                    recyclerView.setAdapter(foodItemAdapter);
                    foodItemAdapter.notifyDataSetChanged();
                    fragment = FoodFragment.newInstance(bundle,FoodCategories.Indian);
                    return true;
                case R.id.navigation_dashboard:
                    readDB(FoodCategories.Chinese);
                    foodItemAdapter = new FoodItemAdapter(foodItemList);
                    recyclerView.setAdapter(foodItemAdapter);
                    foodItemAdapter.notifyDataSetChanged();
                    fragment = FoodFragment.newInstance(bundle,FoodCategories.Chinese);
                    return true;
                case R.id.navigation_notifications:
                    readDB(FoodCategories.Italian);
                    foodItemAdapter = new FoodItemAdapter(foodItemList);
                    recyclerView.setAdapter(foodItemAdapter);
                    foodItemAdapter.notifyDataSetChanged();
                    fragment = FoodFragment.newInstance(bundle,FoodCategories.Italian);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.food_items_list);
        linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        linearLayoutManager.setSmoothScrollbarEnabled(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
//        foodItemList = new ArrayList<>();
//        foodItemAdapter = new FoodItemAdapter(foodItemList);
        readDB(FoodCategories.Indian);
        foodItemAdapter = new FoodItemAdapter(foodItemList);
        recyclerView.setAdapter(foodItemAdapter);
        foodItemAdapter.notifyDataSetChanged();
        SQLiteDatabase db = foodDBHelper.getWritableDatabase();
        fillFoodItems(db);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    @Override
    protected void onStart() {
        super.onStart();
        foodDBHelper = new FoodDBHelper(getApplicationContext());
    }

    private void fillFoodItems(SQLiteDatabase database){
        fillChineseFoodItems(database);
        fillIndianFoodItems(database);
        fillItalianFoodItems(database);
    }

    private void fillChineseFoodItems(SQLiteDatabase database){
        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(FoodDB.FoodIteEntry.COLUMN_NAME_FOOD_CATEGORY,FoodCategories.Chinese.getFoodCategory());
        values.put(FoodDB.FoodIteEntry.COLUMN_NAME_FOOD_TITLE, "Spinach Noodles");
        values.put(FoodDB.FoodIteEntry.COLUMN_NAME_PRICE, 150.0);
        long newRowId = database.insert(FoodDB.FoodIteEntry.TABLE_NAME, null, values);
        values = new ContentValues();
        values.put(FoodDB.FoodIteEntry.COLUMN_NAME_FOOD_CATEGORY,FoodCategories.Chinese.getFoodCategory());
        values.put(FoodDB.FoodIteEntry.COLUMN_NAME_FOOD_TITLE, "Fried Mashi");
        values.put(FoodDB.FoodIteEntry.COLUMN_NAME_PRICE, 90.0);
        newRowId = database.insert(FoodDB.FoodIteEntry.TABLE_NAME, null, values);
        values = new ContentValues();
        values.put(FoodDB.FoodIteEntry.COLUMN_NAME_FOOD_CATEGORY,FoodCategories.Chinese.getFoodCategory());
        values.put(FoodDB.FoodIteEntry.COLUMN_NAME_FOOD_TITLE, "Dumplings");
        values.put(FoodDB.FoodIteEntry.COLUMN_NAME_PRICE, 60.0);
        newRowId = database.insert(FoodDB.FoodIteEntry.TABLE_NAME, null, values);
    }

    private void fillIndianFoodItems(SQLiteDatabase database){
        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(FoodDB.FoodIteEntry.COLUMN_NAME_FOOD_CATEGORY,FoodCategories.Indian.getFoodCategory());
        values.put(FoodDB.FoodIteEntry.COLUMN_NAME_FOOD_TITLE, "Biryani");
        values.put(FoodDB.FoodIteEntry.COLUMN_NAME_PRICE, 200.0);
        long newRowId = database.insert(FoodDB.FoodIteEntry.TABLE_NAME, null, values);
        values = new ContentValues();
        values.put(FoodDB.FoodIteEntry.COLUMN_NAME_FOOD_CATEGORY,FoodCategories.Indian.getFoodCategory());
        values.put(FoodDB.FoodIteEntry.COLUMN_NAME_FOOD_TITLE, "Dosa");
        values.put(FoodDB.FoodIteEntry.COLUMN_NAME_PRICE, 100.0);
        newRowId = database.insert(FoodDB.FoodIteEntry.TABLE_NAME, null, values);
        values = new ContentValues();
        values.put(FoodDB.FoodIteEntry.COLUMN_NAME_FOOD_CATEGORY,FoodCategories.Indian.getFoodCategory());
        values.put(FoodDB.FoodIteEntry.COLUMN_NAME_FOOD_TITLE, "Chapati");
        values.put(FoodDB.FoodIteEntry.COLUMN_NAME_PRICE, 100.0);
        newRowId = database.insert(FoodDB.FoodIteEntry.TABLE_NAME, null, values);
    }

    private void fillItalianFoodItems(SQLiteDatabase database){
        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(FoodDB.FoodIteEntry.COLUMN_NAME_FOOD_CATEGORY,FoodCategories.Italian.getFoodCategory());
        values.put(FoodDB.FoodIteEntry.COLUMN_NAME_FOOD_TITLE, "Panzenella");
        values.put(FoodDB.FoodIteEntry.COLUMN_NAME_PRICE, 200.0);
        long newRowId = database.insert(FoodDB.FoodIteEntry.TABLE_NAME, null, values);
        values = new ContentValues();
        values.put(FoodDB.FoodIteEntry.COLUMN_NAME_FOOD_CATEGORY,FoodCategories.Italian.getFoodCategory());
        values.put(FoodDB.FoodIteEntry.COLUMN_NAME_FOOD_TITLE, "Pasta");
        values.put(FoodDB.FoodIteEntry.COLUMN_NAME_PRICE, 100.0);
        newRowId = database.insert(FoodDB.FoodIteEntry.TABLE_NAME, null, values);
        values = new ContentValues();
        values.put(FoodDB.FoodIteEntry.COLUMN_NAME_FOOD_CATEGORY,FoodCategories.Italian.getFoodCategory());
        values.put(FoodDB.FoodIteEntry.COLUMN_NAME_FOOD_TITLE, "Margherita Pizza");
        values.put(FoodDB.FoodIteEntry.COLUMN_NAME_PRICE, 200.0);
        newRowId = database.insert(FoodDB.FoodIteEntry.TABLE_NAME, null, values);
    }

    private void readDB(FoodCategories foodCategories){

        foodItemList = new ArrayList<FoodItem>();
        FoodItem foodItem;

        SQLiteDatabase db = foodDBHelper.getReadableDatabase();
// Define a projection that specifies which columns from the database
// you will actually use after this query.
        String[] projection = {
                BaseColumns._ID,
                FoodDB.FoodIteEntry.COLUMN_NAME_FOOD_TITLE,
                FoodDB.FoodIteEntry.COLUMN_NAME_PRICE
        };

// Filter results WHERE "title" = 'My Title'
        String selection = FoodDB.FoodIteEntry.COLUMN_NAME_FOOD_CATEGORY + " = ?";
        String[] selectionArgsChinese = { FoodCategories.Chinese.getFoodCategory() };
        String[] selectionArgsIndian = { FoodCategories.Indian.getFoodCategory() };
        String[] selectionArgsItalian = { FoodCategories.Italian.getFoodCategory() };

// How you want the results sorted in the resulting Cursor
        String sortOrder = FoodDB.FoodIteEntry.COLUMN_NAME_PRICE + " DESC";

        switch (foodCategories){
            case Chinese:
                Cursor cursorChinese = db.query(
                        FoodDB.FoodIteEntry.TABLE_NAME,   // The table to query
                        projection,             // The array of columns to return (pass null to get all)
                        selection,              // The columns for the WHERE clause
                        selectionArgsChinese,          // The values for the WHERE clause
                        null,                   // don't group the rows
                        null,                   // don't filter by row groups
                        sortOrder               // The sort order
                );
                readFromCursoer(cursorChinese,FoodCategories.Chinese);
                break;
            case Indian:
                Cursor cursorIndian = db.query(
                        FoodDB.FoodIteEntry.TABLE_NAME,   // The table to query
                        projection,             // The array of columns to return (pass null to get all)
                        selection,              // The columns for the WHERE clause
                        selectionArgsIndian,          // The values for the WHERE clause
                        null,                   // don't group the rows
                        null,                   // don't filter by row groups
                        sortOrder               // The sort order
                );
                readFromCursoer(cursorIndian,FoodCategories.Indian);
                break;
            case Italian:
                Cursor cursorItalian = db.query(
                        FoodDB.FoodIteEntry.TABLE_NAME,   // The table to query
                        projection,             // The array of columns to return (pass null to get all)
                        selection,              // The columns for the WHERE clause
                        selectionArgsItalian,          // The values for the WHERE clause
                        null,                   // don't group the rows
                        null,                   // don't filter by row groups
                        sortOrder               // The sort order
                );
                readFromCursoer(cursorItalian,FoodCategories.Italian);
                break;
        }
    }

    private void readFromCursoer(Cursor cursor,FoodCategories foodCategories){
        FoodItem foodItem = new FoodItem();
            while (cursor.moveToNext()) {
                long itemId = cursor.getLong(
                        cursor.getColumnIndexOrThrow(FoodDB.FoodIteEntry._ID));
                foodItem = new FoodItem();
                foodItem.setId(itemId);
                foodItem.setName(cursor.getString(cursor.getColumnIndexOrThrow(FoodDB.FoodIteEntry.COLUMN_NAME_FOOD_TITLE)));
                foodItem.setPrice(cursor.getDouble(cursor.getColumnIndexOrThrow(FoodDB.FoodIteEntry.COLUMN_NAME_PRICE)));
                foodItem.setCategory(foodCategories);
                foodItem.setCurrency(Currencies.INR);
                foodItemList.add(foodItem);
            }
        cursor.close();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        return false;
    }

    @Override
    protected void onDestroy() {
        SQLiteDatabase db = foodDBHelper.getWritableDatabase();
        foodDBHelper.delete(db);
        foodDBHelper.close();
        super.onDestroy();
    }
}
