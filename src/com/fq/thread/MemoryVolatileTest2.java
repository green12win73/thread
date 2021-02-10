package com.fq.thread;

/**
 * @author fangqi
 * @description 内存可见测试
 * @date 2020/5/7 15:34
 */
public class MemoryVolatileTest2 {

   private static volatile boolean flag = false;

    public static void main(String[] args) throws InterruptedException {
        Thread A = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"===>>>进入循环....");
                while(!flag){

                }
                System.out.println(Thread.currentThread().getName()+"===>>>退出循环....");
            }
        },"Thread-A");
        Thread B = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                flag = true;
                System.out.println(Thread.currentThread().getName()+"===>>>flag="+flag);
            }
        },"Thread-B");
        A.start();
        B.start();
        A.join();
        B.join();
        System.out.println("=================>>>>>>>>>>>>>>>主线程退出");
    }
}
