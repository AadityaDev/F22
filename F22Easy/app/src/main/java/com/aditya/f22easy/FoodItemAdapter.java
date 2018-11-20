package com.aditya.f22easy;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class FoodItemAdapter extends RecyclerView.Adapter<FoodItemAdapter.FoodItemViewHolder>{

    private Context context;
    private List<FoodItem> foodItemList;

    public FoodItemAdapter(List<FoodItem> foodItemList){
        this.foodItemList = foodItemList;
    }

    @NonNull
    @Override
    public FoodItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.food_item_card, viewGroup, false);
        return new FoodItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodItemViewHolder foodItemViewHolder, int i) {
        FoodItem foodItem = foodItemList.get(i);
        if(foodItem!=null){
            foodItemViewHolder.foodCurrency.setText(foodItem.getCurrency().getSymbol());
            foodItemViewHolder.foodPrice.setText(foodItem.getPrice()+"");
            foodItemViewHolder.foodTitle.setText(foodItem.getName());
        }
    }

    @Override
    public int getItemCount() {
        return foodItemList.size();
    }

    public static class FoodItemViewHolder extends RecyclerView.ViewHolder{

        private TextView foodTitle;
        private TextView foodCurrency;
        private TextView foodPrice;

        public FoodItemViewHolder(@NonNull View itemView) {
            super(itemView);
            foodTitle = (TextView)itemView.findViewById(R.id.food_title);
            foodCurrency = (TextView)itemView.findViewById(R.id.food_price);
            foodPrice = (TextView)itemView.findViewById(R.id.currency_symbol);
        }
    }

}
