package com.aditya.f22easy.constants;

public enum FoodCategories {

    Chinese( 0 , "Chinese", "Chinese Food"),Indian( 1 , "Indian", "Indian Food"),Italian( 2 , "Italian", "Italian Food");

    private int index;
    private String foodCategory;
    private String title;

    public int getIndex() {
        return index;
    }

    public String getFoodCategory() {
        return foodCategory;
    }

    public String getTitle() {
        return title;
    }

    FoodCategories(int index, String foodCategory, String title){
        this.index = index;
        this.foodCategory = foodCategory;
        this.title = title;
    }

}
