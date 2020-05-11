package com.fq.thread.concurrent;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

/**
 * @author fangqi
 * @description
 * @date 2020/5/11 14:57
 */
public class ConcurrentTest {

    private static int count = 0;
    private static int count0 = 0;
    private Object object = new Object();
    private static AtomicLong atomicInteger = new AtomicLong(0);
    private static LongAdder longAdder = new LongAdder();

    public synchronized void addCount(){
        count++;
    }

    public void addCount0(){
        synchronized (object) {
            count0++;
        }
    }

    public void increment(){
        atomicInteger.incrementAndGet();
    }

    public void adder(){
        longAdder.increment();
    }

    public static void main(String[] args) {
        ConcurrentTest test = new ConcurrentTest();
        long time = System.currentTimeMillis();
        for (int i0 = 0; i0 < 120; i0++) {
            new Thread(()->{
                for(int i=0; i<10000; i++){
                    test.addCount();
                }
            }).start();
        }
        System.out.println("synchronized 耗时"+(System.currentTimeMillis()-time));
        time = System.currentTimeMillis();
        for (int i0 = 0; i0 < 120; i0++) {
            new Thread(()->{
                for(int i=0; i<10000; i++){
                    test.addCount0();
                }
            }).start();
        }
        System.out.println("synchronized0 耗时"+(System.currentTimeMillis()-time));
        time = System.currentTimeMillis();
        for (int i0 = 0; i0 < 120; i0++) {
            new Thread(() -> {
                for (int i = 0; i < 10000; i++) {
                    test.increment();
                }
            }).start();
        }
        System.out.println("AtomicLong 耗时"+(System.currentTimeMillis()-time));
        time = System.currentTimeMillis();
        for (int i0 = 0; i0 < 120; i0++) {
            new Thread(() -> {
                for (int i = 0; i < 10000; i++) {
                    test.adder();
                }
            }).start();
        }
        System.out.println("LongAdder 耗时"+(System.currentTimeMillis()-time));
    }
}
