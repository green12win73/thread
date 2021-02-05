package com.fq.thread;

import java.awt.geom.FlatteningPathIterator;
import java.util.ArrayList;
import java.util.List;

/**
 * @author fangqi
 * @description
 * @date 2020/5/7 15:34
 */
public class VolatileTest1 {

   private static volatile boolean flag = false;


    public static void main(String[] args) throws InterruptedException {
        Object o = new Object();

        Thread A = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (o){
                    System.out.println("===21212=======");
                }
                System.out.println(Thread.currentThread().getName()+"=============>>>>>>>>>>>>进入循环....");
                while(!flag){

                }
                System.out.println(Thread.currentThread().getName()+"=============>>>>>>>>>>>>退出循环....");
            }
        }, "Thread-A");
        Thread B = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (o){
                    System.out.println("==111========");
                }
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                flag = true;
                System.out.println(Thread.currentThread().getName()+"=============>>>>>>>>>>>>退出循环....");
            }
        },"Thread-B");
        A.start();
        B.start();
        A.join();
        B.join();
        System.out.println("==================flag="+flag);
    }
}
