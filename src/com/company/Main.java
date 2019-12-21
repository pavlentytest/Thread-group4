package com.company;

public class Main {

    public static void main(String[] args) {
        // процесс
        // поток - потоки в процессах
        // 1 -> extends Thread -> run();
        // 2 -> implements Runnable -> run();
        // [+][-][+][-]

        // анонимного класса
        //new MyThread("+").start();

        MyThread t1 = new MyThread("+");
        MyThread t2 = new MyThread("-");
        t1.start();
        t2.start();

    }
    private static Object key = new Object();
    public static void test(String m) {
        try {
            synchronized (key) {
                System.out.print("[");
                Thread.sleep(1000);
                System.out.print(m);
                Thread.sleep(1000);
                System.out.print("]");
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
