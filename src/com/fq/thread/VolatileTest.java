package com.fq.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fangqi
 * @description
 * @date 2020/5/7 15:34
 */
public class VolatileTest {

    private volatile int count=0;

    public void increment(){
        count++;
    }

    public int getCount(){
        return count;
    }

    public static void main(String[] args) {
        VolatileTest test = new VolatileTest();
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
        //等待同组的线程全部执行完成
        while(threadGroup.activeCount()>0){
            //如果还有子线程没有执行完成，则主线yield，让子线程继续执行
            Thread.yield();
        }
        System.out.println("累加结果："+test.getCount());
    }
}
