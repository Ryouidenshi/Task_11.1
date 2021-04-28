package com.example.task01;

public class Lucky {
    static StateObject so = new StateObject();

    static class LuckyThread extends Thread {
        @Override
        public void run() {
            while (true) {
                synchronized (so) {
                    if(so.getX() >= 999999) break;
                    so.incrementX();
                    if ((so.getX() % 10) + (so.getX() / 10) % 10 + (so.getX() / 100) % 10 == (so.getX() / 1000)
                            % 10 + (so.getX() / 10000) % 10 + (so.getX() / 100000) % 10) {
                        System.out.println(so.getX() + " ");
                        so.incrementCount();
                    }
                }
            }
        }

        public static int getCount(){
            return so.getCount();
        }
    }
}