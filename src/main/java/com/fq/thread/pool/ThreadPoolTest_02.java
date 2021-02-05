package com.fq.thread.pool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author fangqi
 * @description
 * @date 2020/6/12 15:56
 */
public class ThreadPoolTest_02 {

    public static void main(String[] args) {
        // 1.创建固定线程数的线程池，
        // 等价于new ThreadPoolExecutor(nThreads, nThreads,0L, TimeUnit.MILLISECONDS,new LinkedBlockingQueue<Runnable>())
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        // 2.创建一个线程池，根据需要创建新线程，但在可用时重用之前构造的线程。
        // 等价于new ThreadPoolExecutor(0, Integer.MAX_VALUE,60L, TimeUnit.SECONDS,new SynchronousQueue<Runnable>())
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        // 3.等价于new ThreadPoolExecutor(0, Integer.MAX_VALUE,60L, TimeUnit.SECONDS,new SynchronousQueue<Runnable>(),threadFactory)
        ExecutorService defaultThreadFactoryCachedThreadPool = Executors.newCachedThreadPool(Executors.defaultThreadFactory());
        // 4.创建一个任务调度线程池，任务在一定时间后会被调用
        // 等价于new ScheduledThreadPoolExecutor(corePoolSize)
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);
        // 5.等价于new ScheduledThreadPoolExecutor(corePoolSize, threadFactory)
        ScheduledExecutorService defaultThreadFactoryScheduledExecutorService = Executors.newScheduledThreadPool(2, Executors.defaultThreadFactory());
        // 6.创建一个执行器，该执行器使用单个工作线程操作一个未绑定队列。
        // (但是请注意，如果这个线程在关闭之前由于执行失败而终止，那么在需要执行后续任务时，一个新的线程将取代它。)
        // 任务保证按顺序执行，并且在任何给定时间内活动的任务不超过一个。
        // 等价于new FinalizableDelegatedExecutorService(new ThreadPoolExecutor(1, 1,0L, TimeUnit.MILLISECONDS,new LinkedBlockingQueue<Runnable>()))
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        // 7.等价于new FinalizableDelegatedExecutorService(new ThreadPoolExecutor(1, 1,0L, TimeUnit.MILLISECONDS,new LinkedBlockingQueue<Runnable>(),threadFactory))
        ExecutorService defaultThreadFactorySingleThreadExecutor = Executors.newSingleThreadExecutor(Executors.defaultThreadFactory());
        // 8.创建一个执行器，(但是请注意，如果这个线程在关闭之前由于执行失败而终止，那么在需要执行后续任务时，一个新的线程将取代它。)
        // 等价于new DelegatedScheduledExecutorService(new ScheduledThreadPoolExecutor(1))
        ScheduledExecutorService singleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        // 9.等价于new DelegatedScheduledExecutorService(new ScheduledThreadPoolExecutor(1, threadFactory))
        ScheduledExecutorService defaultThreadFactoryNewSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor(Executors.defaultThreadFactory());

        //打印
        print(singleThreadExecutor);

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
