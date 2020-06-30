package com.fq.thread.container;

import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TransferQueue;

/**
 * @author fangqi
 * @description
 * @date 2020/6/3 9:11
 */
public class DequeContainerTest {

    public static void main(String[] args) {
//        int head = (0 - 1) & (8 - 1);
//        System.out.println(head);
//        System.out.println((head - 1) & (8 - 1));

        DelayQueue<MyDelayed> delayeds = new DelayQueue<>();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 10; i++) {
//                    try {
//                        Thread.sleep(2000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                    delayeds.add(new MyDelayed(i));
                }
            }
        },"Thread-1").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (;;) {
                    try {
                        System.out.println(delayeds.take());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"Thread-2").start();
    }

    static class MyDelayed implements Delayed{
        private Random random = new Random();
        public int i;
        public long time = 0;
        public MyDelayed(int i){
            this.i = i;
        }

        @Override
        public long getDelay(TimeUnit unit) {
            while(time <= 0){
                int i = random.nextInt(10);
                System.out.println(i);
                System.out.println(i * 1000 * 1000);
                time = i ;
            }
            return time;
        }

        @Override
        public int compareTo(Delayed o) {
            MyDelayed myDelayed = (MyDelayed)o;
            if(this.i>myDelayed.i){
                return 1;
            }
            if(this.i<myDelayed.i){
                return -1;
            }
            return 0;
        }

        @Override
        public String toString() {
            return "MyDelayed{" +
                    "i=" + i +
                    ", time=" + time +
                    '}';
        }
    }
}
