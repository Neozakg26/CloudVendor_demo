package com.example.cloudVendordemo.entity;

import lombok.Getter;

import java.util.ArrayList;
@Getter
public class Basket {
    private ArrayList<String> foodItems = new ArrayList<>();

    public void addItem(String food){
        foodItems.add(food);
    }

    public void removeItem(String food){
        foodItems.remove(food);
    }

    public void clearItems(){
        foodItems.clear();
    }

}
