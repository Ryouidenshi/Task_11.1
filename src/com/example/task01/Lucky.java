package com.example.task01;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Lucky {
    static StateObject so = new StateObject(); //критическая секция
    
    static class LuckyThread<Mutex> extends Thread {

        private final Lock _mutex = new ReentrantLock(true);

        @Override
        public void run() {
            int x;
            while (true) {
                _mutex.lock();
                synchronized (so) {
                    so.incrementX();
                    x = so.getX();
                }
                _mutex.unlock();

                if (x > 999999) {
                    break;
                }

                if ((x % 10) + (x / 10) % 10 + (x / 100) % 10 == (x / 1000)
                        % 10 + (x / 10000) % 10 + (x / 100000) % 10) {
                    System.out.println(x + " " + this.getName());

                    _mutex.lock();
                    so.incrementCount();
                    _mutex.unlock();
                }
            }
        }

        public static int getCount() {
            return so.getCount();
        }
    }
}