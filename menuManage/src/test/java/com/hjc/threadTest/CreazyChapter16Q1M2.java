package com.hjc.threadTest;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Bravowhale on 2017/7/20.
 */
class PrintM2{
    private volatile boolean flag = true;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void printNum(int i ){
        lock.lock();
        try {
                if (flag && i % 2 == 0) {
                    System.out.print(i);

                        flag = false;
                        condition.signalAll();
                        condition.await();

                }else
            System.out.print(i);

        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void printChar(char ch){
        lock.lock();
        try{
        if (!flag){
            flag = true;
            System.out.print(ch);
            condition.signalAll();
            if (ch != 90)
                condition.await();
        }/*else
            condition.await();*/
        }catch (InterruptedException e){

        }finally {
            lock.unlock();
        }
    }
}
class PrintNumM2 extends Thread{
    private PrintM2 printM2;

    public PrintNumM2(PrintM2 printM2) {
        this.printM2 = printM2;
    }

    @Override
    public void run() {
        for (int i = 1; i < 53; i++) {
            printM2.printNum(i);
        }
    }
}
class PrintCharM2 extends Thread{
    private PrintM2 printM2;

    public PrintCharM2(PrintM2 printM2) {
        this.printM2 = printM2;
    }

    @Override
    public void run() {
        for (int i = 65; i < 91; i++) {
            printM2.printChar((char)i);
        }

    }
}
public class CreazyChapter16Q1M2 {
    public static void main(String[] args) {
        PrintM2 printM2 = new PrintM2();
        PrintCharM2 printCharM2 = new PrintCharM2(printM2);
        PrintNumM2 printNumM2 = new PrintNumM2(printM2);
        printNumM2.start();
        printCharM2.start();
    }
}
