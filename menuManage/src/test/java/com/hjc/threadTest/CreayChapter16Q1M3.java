package com.hjc.threadTest;

import java.util.concurrent.BlockingDeque;

/**
 * Created by Bravowhale on 2017/7/20.
 */
class PrintNumM3 extends Thread{
    private BlockingDeque bq;

    public PrintNumM3(BlockingDeque bq) {
        this.bq = bq;
    }

    @Override
    public void run() {
        super.run();
    }
}
public class CreayChapter16Q1M3 {
}
