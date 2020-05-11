package com.fq.thread.concurrent;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {

    public static void main(String[] args) {
        //信号量，只要能获取到信号量就可以执行
        Semaphore semaphore = new Semaphore(10);

        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                try {
                    semaphore.acquire();
                    Thread.sleep(1000);
                    System.out.println("==========="+Thread.currentThread().getName()+"获取到锁===========");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                }
            },"Thread-"+i).start();
        }
    }
}
