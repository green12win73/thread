package com.fq.thread.pool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @author fangqi
 * @description
 * @date 2020/6/12 14:22
 */
public class CallableTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Integer> callable1 = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                for (int i = 0; i < 100; i++) {
                    System.out.println("======callabel1_+"+i+"======");
                }
                return 12;
            }
        };
        Callable<Integer> callable2 = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                for (int i = 0; i < 100; i++) {
                    System.out.println("======callabel2_+"+i+"======");
                }
                return 22;
            }
        };
        FutureTask<Integer> futureTask1 = new FutureTask<>(callable1);
        new Thread(futureTask1).start();
        FutureTask<Integer> futureTask2 = new FutureTask<>(callable2);
        new Thread(futureTask2).start();
        System.out.println("============打印返回结果============");
        System.out.println(futureTask1.get());
        System.out.println(futureTask2.get());
    }
}
