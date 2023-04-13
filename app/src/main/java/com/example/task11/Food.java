package com.example.task11;

import java.util.Comparator;
import java.io.Serializable;
public class Food implements Serializable {

    private String name;
    private String memo;

    private int timeCounter;
    private int timeCalculator;
    private static final long serialVersionUID = 2458334561L;

    public Food(String name, String memo, int timeCounter){
        this.name=name;
        this.memo=memo;
        this.timeCounter=timeCounter;
        this.timeCalculator=0;
    }
    public String getName(){
        return name;
    }
    public String getMemo(){
        return  memo;
    }
    public int getTimeCounter(){ return timeCounter;}

    //comparator
    public static Comparator<Food> nameComparator = new Comparator<Food>() {
        @Override
        public int compare(Food us1, Food us2) {
            return us1.getName().compareTo(us2.getName());
        }
    };
    public static Comparator<Food> timeComparator = new Comparator<Food>() {
        @Override
        public int compare(Food us1, Food us2) {
            return us1.getTimeCounter() - (us2.getTimeCounter());
        }
    };

    public void setName(String name){
        this.name=name;
    }

    public int getTimeCalculator(){
        return timeCalculator;
    }

    public void setTimeCalculator(int timeCalculator){
        this.timeCalculator=timeCalculator;
    }

}
