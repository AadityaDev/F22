package com.aditya.f22easy.constants;

public enum Currencies {

    INR("INDIAN","\u20B9");

    private String name;
    private String symbol;

    Currencies(String name,String symbol){
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }
}
