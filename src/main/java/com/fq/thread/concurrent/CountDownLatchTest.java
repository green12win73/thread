package com.fq.thread.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * @author fangqi
 * @description
 * @date 2020/5/11 16:32
 */
public class CountDownLatchTest {


    public static void main(String[] args) {
        //等待一个或一组线程操作完成后再继续执行
        CountDownLatch latch = new CountDownLatch(10);

        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                //每执行一次该方法，上面设置的10的参数就减一，直到等于0为止
                latch.countDown();
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"执行完成!");
            },"thread-"+i).start();
        }
        try {
            System.out.println("==============");
            //执行等待操作，直到上面设置的10参数等于0，再执行后面的代码
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("所有线程执行完成");
        while(true){}
        //以上这种方式等价于循环执行Thread.join()，直到所有线程都执行完成；
        //但是Thread.join性能上不如以上方法，thread.join后必须等待thread执行完成后，才能继续往下，
        //而CountDownLatch则不需要，10线程可以并发执行
    }
}
