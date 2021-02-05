package com.fq.thread.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author fangqi
 * @description
 * @date 2020/5/11 16:56
 */
public class CyclicBarrierTest {

    public static void main(String[] args) {
        //等待指定数量的线程全部执行完成后，在继续往下，循环执行
        CyclicBarrier barrier = new CyclicBarrier(10, ()->{
            System.out.println("已经执行满10个线程，可以继续往下了。。。");
        });
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"执行完成!");
                try {
                    barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },"thread-"+i).start();
        }
    }
}
