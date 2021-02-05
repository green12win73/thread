package com.fq.thread.concurrent;

import java.util.concurrent.locks.LockSupport;

/**
 * @author fangqi
 * @description
 * @date 2020/5/13 10:29
 */
public class LockSupportTest {
    public static Thread t1;
    public static Thread t2;
    public static void main(String[] args) {
        t1 = new Thread(()->{
            for(int i=0; i<10; i++){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(i==5){
                    System.out.println("Thread-1 park");
                    LockSupport.unpark(t2);
                    LockSupport.park();
                }
                System.out.println("Thread-1, i="+i);
            }
        });

        t2 = new Thread(()->{
            System.out.println("Thread-2 park");
            LockSupport.park();
            System.out.println("Thread-2 unpark Thread-1");
            LockSupport.unpark(t1);
        });
        t1.start();
        t2.start();
    }
}
