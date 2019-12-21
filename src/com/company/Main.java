package com.company;

public class Main {

    public static void main(String[] args) throws InterruptedException {
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
        Thread.sleep(2000);
        t1.flag = false;

        t1.join(); // t2 ждет завершение t1
        test("1-st stopped!");

    }
    private static Object key = new Object();
    static volatile int count = 0; // volatile доступна к записи в потоках

    public static void test(String m) {
        try {
            synchronized (key) {
                System.out.print("[");
                Thread.sleep(500);
                System.out.print(m);
                Thread.sleep(500);
                System.out.print("]");
               // key.notify(); // возобн. поток который в wait
               // key.wait(); // выставляет поток в режим wait до вызова notify();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
