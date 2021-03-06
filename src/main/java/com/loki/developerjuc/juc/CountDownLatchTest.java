package com.loki.developerjuc.juc;

import java.util.concurrent.CountDownLatch;

/**
 * @Author xujs
 * CountDownLatch 闭锁 : 在完成某些运算时,只有其他所有线程的运算全部完成,当前运算才会继续进行
 */
public class CountDownLatchTest {

    public static void main(String[] args) {
        final CountDownLatch latch = new CountDownLatch(5);
        LatchDemo ld = new LatchDemo(latch);

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 5; i++) {
            new Thread(ld).start();
        }

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long endTime = System.currentTimeMillis();

        System.out.println("耗时:" + (endTime - startTime));
    }

}

class LatchDemo implements Runnable {

    private CountDownLatch latch;

    public LatchDemo(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        synchronized (this) {
            try {
                for (int i = 0; i < 10000; i++) {
                    if (i % 2 == 0) {
                        System.out.println(i);
                    }
                }
            } finally {
                latch.countDown();
            }
        }
    }
}
