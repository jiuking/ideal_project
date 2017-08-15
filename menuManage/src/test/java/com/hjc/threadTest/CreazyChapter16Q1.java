package com.hjc.threadTest;

/**
 * Created by Bravowhale on 2017/7/20.
 */
class Print{

    private boolean flag = true;
    public synchronized void printNum(int num){
        try {
            if (flag && num % 2 == 0) {
                System.out.print(num);
                flag = false;
                notifyAll();
                wait();
            }else //else 不要有问题。
                System.out.print(num);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    public synchronized void printChar(char i){
        try {
            if(!flag) {
                flag = true;
                System.out.print(i);
                notifyAll();
                if (i != 90)
                    wait();
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
class PrintNum extends Thread{
    private Print print;
    PrintNum(Print print){
        this.print = print;
    }
    @Override
    public void run() {
        int i = 1;
        for (;i<53;i++) {
            print.printNum(i);
        }
        System.out.println("接口"+i);
    }
}
class PrintChar extends Thread{
    private Print print;
    PrintChar(Print print){
        this.print = print;
    }

    @Override
    public void run() {
        int i = 65;
        for (;i<91;i++)
            print.printChar((char) i);
        System.out.println("结果"+i);
    }
}
public class CreazyChapter16Q1{

    public static void main(String[] args) {
        Print print = new Print();
        PrintNum pn = new PrintNum(print);
        PrintChar pc = new PrintChar(print);
        pn.start();
        pc.start();
    }
}
