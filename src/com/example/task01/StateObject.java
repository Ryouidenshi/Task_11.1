package com.example.task01;

public class StateObject {
    public StateObject() {

    }
    private int x = 0;
    private int count = 0;
    public int getX(){
        return x;
    }

    public int getCount(){
        return count;
    }

    public void incrementX() {
        x++;
    }
    public void incrementCount(){
        count++;
    }
}