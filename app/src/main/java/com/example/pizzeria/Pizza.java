package com.example.pizzeria;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Pizza implements Serializable {
    private int size;
    private double cost;
    private Map<String, Double> filling;
    private Map<String, Integer> fillingResult;
    public static final int BIG = 3;
    public static final int MIDDLE = 2;
    public static final int SMALL = 1;
    public static final String PORK = "Pork";
    public static final String CHICKEN = "Chicken";
    public static final String PINEAPPLE = "Pineapple";
    public static final String CHEESE = "Cheese";
    public static final String TOMATO = "Tomato";
    public static final String OLIVES = "Olives";
    public static final String SAUSAGE = "Sausage";
    public static final String MUSHROOM = "Mushroom";
    public static final String BASIL = "Basil";
    private boolean isTakeOut;
    public Pizza(int size) {
        initFillingMap();
        initResultMap();

        this.size = size;
        switch (size){
            case BIG:{
                cost = 30;
                break;
            }
            case MIDDLE:{
                cost = 25;
                break;
            }
            case SMALL:{
                cost = 20;
                break;
            }
        }
    }

    private void initResultMap() {
        fillingResult = new HashMap<>();
        fillingResult.put(PORK, 0);
        fillingResult.put(CHICKEN, 0);
        fillingResult.put(PINEAPPLE, 0);
        fillingResult.put(CHEESE, 0);
        fillingResult.put(TOMATO, 0);
        fillingResult.put(OLIVES, 0);
        fillingResult.put(SAUSAGE, 0);
        fillingResult.put(MUSHROOM, 0);
        fillingResult.put(BASIL, 0);
    }

    private void initFillingMap() {
        filling = new HashMap<>();
        filling.put(PORK, 15.0);
        filling.put(CHICKEN, 13.0);
        filling.put(PINEAPPLE, 10.0);
        filling.put(CHEESE, 11.0);
        filling.put(TOMATO, 8.0);
        filling.put(OLIVES, 10.0);
        filling.put(SAUSAGE, 12.0);
        filling.put(MUSHROOM, 9.0);
        filling.put(BASIL, 5.0);
    }

    public void addToCost(String key){
        cost += filling.get(key);
    }

    public void subtractFromCost(String key){
        cost -= filling.get(key);
    }

    public Map<String, Integer> getFillingResult() {
        return fillingResult;
    }

    public void setFillingResult(Map<String, Integer> fillingResult) {
        this.fillingResult = fillingResult;
    }

    public Map<String, Double> getFilling() {
        return filling;
    }

    public boolean isTakeOut() {
        return isTakeOut;
    }

    public void setTakeOut(boolean takeOut) {
        isTakeOut = takeOut;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
