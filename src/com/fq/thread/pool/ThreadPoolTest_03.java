package com.fq.thread.pool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * @author fangqi
 * @description
 * @date 2020/6/12 15:56
 */
public class ThreadPoolTest_03 {

    public static void main(String[] args) {
        ScheduledExecutorService defaultThreadFactoryNewSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor(Executors.defaultThreadFactory());
        //打印
        print(defaultThreadFactoryNewSingleThreadScheduledExecutor);

    }

    private static void print(ExecutorService executorService){
        final List<Integer> list = new ArrayList<>();
        list.add(1);
        for (int i = 0; i < 100; i++) {
            executorService.submit(Executors.callable(new Runnable() {
                @Override
                public void run() {
                    System.out.println("当前线程名称："+Thread.currentThread().getName());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }));
        }
        executorService.shutdown();
    }
}
