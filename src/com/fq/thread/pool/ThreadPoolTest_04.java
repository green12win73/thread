package com.fq.thread.pool;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Complement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import javax.swing.plaf.ListUI;

/**
 * @author fangqi
 * @description
 * @date 2020/6/12 15:56
 */
public class ThreadPoolTest_04 {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        //打印
        printResult_1(executorService);

        System.out.println("========================分割线1=========================");
        //打印
        printResult_2(executorService);

        System.out.println("========================分割线2=========================");
        //打印
        printResult_1(executorService);
    }

    private static void printResult_1(ExecutorService executorService){
        for (int i = 0; i < 10; i++) {
            Callable<Integer> callable = Executors.callable(new Runnable() {
                @Override
                public void run() {
                    System.out.println("当前线程名称：" + Thread.currentThread().getName());
                }
            }, i);
            Future<Integer> submit = executorService.submit(callable);
            try {
                //1.如果future.get()在submit()后执行，实际上就不能算是异步操作，会执行一个任务后才会继续往下执行
                System.out.println(submit.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }

    private static void printResult_2(ExecutorService executorService){
        //保存提交的任务的结果
        List<Future<Integer>> futures = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            //这里也可以自己实现Callable接口，不用工具类生成
            Callable<Integer> callable = Executors.callable(new Runnable() {
                @Override
                public void run() {
                    System.out.println("当前线程名称：" + Thread.currentThread().getName());
                }
            }, i);
            // 提交任务，这里不使用execute()，是因为execute()没有返回值，
            // 所以如果是Callabel的任务，返回结果会在execute()中封装，如果Runnabel没有返回任务
            // submit()会封装一个Future来记录最终结果，同时核心也是调用execute方法，但这个时候传入的都是Future,这样就可以保存执行结果
            Future<Integer> submit = executorService.submit(callable);
            //2.保存任务结果
            futures.add(submit);
        }
        //3.循环遍历获取结果（如果需要结果的话）
        if(null!=futures&&futures.size()>0){
            for (Future<Integer> future : futures) {
                try {
                    // 获取结果，阻塞操作（直到线程执行任务结束，才返回结果）
                    System.out.println(future.get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        }
        //4.如果后续不会有其他任务,且不执行shutdown()，核心线程将会一直存活，导致资源的浪费，
        //所以需要这里调用shutdown().调用必须是在所有任务执行完成之后，否则会导致部分任务得不到执行
        //注意：
        // shutdown():启动有序关闭，在该关闭中执行先前提交的任务，但不接受新任务。如果已经关闭，调用没有额外的影响。
        //            此方法不等待先前提交的任务完成执行。使用{@link #awaitTermination awaitTermination}来完成此操作。
        // shutdownNow():尝试停止所有正在执行的任务，停止等待任务的处理，并返回等待执行的任务列表。
        //               此方法不等待正在执行的任务终止。使用{@link #awaitTermination awaitTermination}来完成此操作。
        executorService.shutdown();
    }
}
