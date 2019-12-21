package com.company;

public class MyThread extends Thread {
    private String message;
    MyThread(String m) {
        this.message = m;
    }

    @Override
    public void run() {
        while(true) {
            Main.test(message);
        }
    }
}
