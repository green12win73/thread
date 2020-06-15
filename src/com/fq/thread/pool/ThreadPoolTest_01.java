package com.fq.thread.pool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author fangqi
 * @description
 * @date 2020/6/12 15:56
 */
public class ThreadPoolTest_01 {

    public static void main(String[] args) {
        //实例化方式一：
//        ExecutorService executorService = new ThreadPoolExecutor(2,3,10, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(1));
        //实例化方式二：
//        ExecutorService executorService = new ThreadPoolExecutor(2, 3, 10, TimeUnit.SECONDS,
//                new ArrayBlockingQueue<>(1), new ThreadFactory() {
//            @Override
//            public Thread newThread(Runnable r) {
//                return new Thread(r);
//            }
//        });
//        //或
//        ExecutorService executorService = new ThreadPoolExecutor(2, 3, 10, TimeUnit.SECONDS,
//                new ArrayBlockingQueue<>(1),Executors.defaultThreadFactory());
        //实例化方式三：
        ExecutorService executorService = new ThreadPoolExecutor(2, 3, 10, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(1),Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
//        手动实例化线程池，相关参数说明：
//        1.corePoolSize:核心线程，工作线程的最小数量，创建之后一直在池中存在（不允许超时），
//         除非直到线程池消毁或设置了{allowCoreThreadTimeOut=true}，表示允许核心线程超时，
//         那么线程在等待一定时间后还是没有任务，那么线程将被销毁，这种情况下的最小线程数是0。
//         当任务数小于等于corePoolSize，且没有空闲线程的时候，提交一个任务就会创建一个核心线程
//        2.maximumPoolSize:最大线程数，线程池可以创建的最大线程数量。
//        3.keepAliveTime:非核心线程的最大存活时间，如果超过当前时间任然没有任务处理，线程会被销毁，等待需要的时候才会被创建。
//        4.TimeUnit:时间单位，毫秒、秒、小时、天...
//        5.BlockingQueue<Runnable>:阻塞队列，当线程池中线程数达到了maximumPoolSize时，且没有空闲的线程，那么任务将会放到阻塞队列中，等待空闲线程消费。
//        6.创建线程的工厂（工厂方法模式）：可以自己实现，也可以通过Excutors.defaultThreadFactory()或Excutors》privilegedThreadFactory()创建。
//        7.拒绝任务策略：当任务不能被处理采用的处理方式，都实现了RejectedExecutionHandler
//         有如下几种：
//         1.ThreadPoolExecutor.CallerRunsPolicy：当任务被拒绝时，会在调用execute方法的线程中直接执行任务，除非执行程序被关闭，这种情况下任务会被丢弃。
//         2.ThreadPoolExecutor.AbortPolicy：任务被拒绝时，直接抛出RejectedExecutionException异常。
//         3.ThreadPoolExecutor.DiscardPolicy:静默方式直接丢弃被拒绝的任务。
//         4.ThreadPoolExecutor.DiscardOldestPolicy:丢弃最老的未被处理的任务，然后重试execute()方法，除非执行程序被关闭，这种情况下任务会被丢弃。
    }
}
