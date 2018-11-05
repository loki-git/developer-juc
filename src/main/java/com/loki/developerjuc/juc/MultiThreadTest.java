package com.loki.developerjuc.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author xujs
 * 按顺序执行多个线程
 */
public class MultiThreadTest {

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(new Thread1());
        executorService.submit(new Thread2());
        executorService.submit(new Thread3());
        executorService.shutdown();

        /*Thread thread1 = new Thread(new Thread1());
        thread1.start();
        thread1.join();

        Thread thread2 = new Thread(new Thread2());
        thread2.start();
        thread2.join();

        Thread thread3 = new Thread(new Thread3());
        thread3.start();
        thread1.join();*/
    }

    public static class Thread1 implements Runnable {
        @Override
        public void run() {
            System.out.println("Thread 1");
        }
    }

    public static class Thread2 implements Runnable {
        @Override
        public void run() {
            System.out.println("Thread 2");
        }
    }

    public static class Thread3 implements Runnable {
        @Override
        public void run() {
            System.out.println("Thread 3");
        }
    }

}
