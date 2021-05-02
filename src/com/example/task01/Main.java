package com.example.task01;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Lucky.LuckyThread();
        Thread t2 = new Lucky.LuckyThread();
        Thread t3 = new Lucky.LuckyThread();

        t1.setName("t1");
        t2.setName("t2");
        t3.setName("t3");

        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
        System.out.println("Total: " + Lucky.LuckyThread.getCount());
    }


}