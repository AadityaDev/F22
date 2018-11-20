package com.aditya.f22easy;

import com.aditya.f22easy.constants.Currencies;
import com.aditya.f22easy.constants.FoodCategories;

public class FoodItem {

    private long id;
    private String name;
    private Double price;
    private FoodCategories category;
    private Currencies currency;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public FoodCategories getCategory() {
        return category;
    }

    public void setCategory(FoodCategories category) {
        this.category = category;
    }

    public Currencies getCurrency() {
        return currency;
    }

    public void setCurrency(Currencies currency) {
        this.currency = currency;
    }
}
