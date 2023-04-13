package com.example.task11;

import android.content.Context;
import android.view.View;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Storage {


    private static Storage storage = null;

    private ArrayList<Food> foods = new ArrayList<>();
    private int timeCalculator;
    private Storage() {
        this.timeCalculator=0;
    }

    public static Storage getInstance() {
        if (storage == null) {
            storage = new Storage();
        }
        return storage;
    }

    public void addUser(Food food) {
        foods.add(food);
    }

    public ArrayList<Food> getFoodList() {

        return foods;
    }

    public int getSize(){
        return foods.size();
    }

    public void saveFoods(Context context) {
        try {
            ObjectOutputStream userWriter = new ObjectOutputStream(context.openFileOutput("foods3.data", Context.MODE_APPEND));
            userWriter.writeObject(foods);
            userWriter.close();
        } catch (IOException e) {
            //throw new RuntimeException(e);
        }
    }

    public void loadFoods(Context context) {
        try {
            ObjectInputStream userReader = new ObjectInputStream(context.openFileInput("foods3.data"));
            foods = (ArrayList<Food>) userReader.readObject();
            userReader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void removeFood(String id){
        int i = 0;
        for(Food food: foods){
            if(food.getName().equals(id)){
                break;
            }
            i++;
        }
        foods.remove(i);
    }
    public Food getFoodById(int id){

        return foods.get(id);
    }

    public void setTimeCalculator(int timeCalculator){
        this.timeCalculator=timeCalculator;
    }

    public int getTimeCalculator(){
        return timeCalculator;

    }

}