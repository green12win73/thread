package com.fq.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author fangqi
 * @description
 * @date 2020/5/7 15:34
 */
public class VolatileTest2 {

    private volatile AtomicInteger count=new AtomicInteger();

    public void increment(){
        count.incrementAndGet();
    }

    public int getCount(){
        return count.get();
    }

    public static void main(String[] args) {
        VolatileTest2 test = new VolatileTest2();
        //定义线程组
        ThreadGroup threadGroup = new ThreadGroup("test");
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(threadGroup, String.valueOf(i)){
                @Override
                public void run() {
                    for (int i = 0; i < 10000; i++) {
                        test.increment();
                    }
                    System.out.println("线程名称：" + this.getName());
                }
            });
        }
        for (Thread thread : threads) {
            thread.start();
        }
        System.out.println("======================");
        //确保每个线程执行完成
        for (Thread thread : threads) {
            try {
                thread.join();
                System.out.println(thread.getName()+"执行完成.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //等待同组的线程全部执行完成
//        while(threadGroup.activeCount()>0){
//            //如果还有子线程没有执行完成，则主线yield，让子线程继续执行
//            Thread.yield();
//        }
        System.out.println("累加结果："+test.getCount());
    }
}
