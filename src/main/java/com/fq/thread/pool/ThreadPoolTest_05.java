package com.fq.thread.pool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author fangqi
 * @description
 * @date 2020/6/12 15:56
 */
public class ThreadPoolTest_05 {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        ExecutorCompletionService<String> completionService = new ExecutorCompletionService<>(executorService);
        //打印
        printResult(completionService);
        //关闭线程池
        executorService.shutdown();

    }

    private static void printResult(CompletionService completionService){
        int count = 10;
        for (int i = 0; i < 10; i++) {
            completionService.submit(new Callable() {
                @Override
                public String call() throws Exception {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return "当前线程名称：" + Thread.currentThread().getName();
                }
            });
        }
        while (count>0) {
            try {
                // 获取结果，阻塞操作（直到线程执行任务结束，才返回结果）
                System.out.println(completionService.take().get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            count--;
        }
    }
}
