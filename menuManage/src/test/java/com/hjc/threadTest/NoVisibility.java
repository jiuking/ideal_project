package com.hjc.threadTest;

import javax.sound.midi.SoundbankResource;

/**
 * Created by Bravowhale on 2017/7/27.
 */
public class NoVisibility extends Thread {
    private static volatile boolean ready;
    private static int number;
    @Override
    public void run() {
        while (!ready)
            System.out.println(number);
    }

    public synchronized void m1(){
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + i);
        }
    }

    public synchronized void m2(){
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + i);
        }
    }
    public static void main(String[] args) throws InterruptedException{
        System.out.println(ready);
        NoVisibility n = new NoVisibility();
//        new NoVisibility().start();
//        Thread.sleep(1000);
        new Thread(new Runnable() {
            @Override
            public void run() {
                n.m1();
            }
        },"m1").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                n.m2();
            }
        },"m2").start();
        number = 42;
        ready = true;
    }
}
