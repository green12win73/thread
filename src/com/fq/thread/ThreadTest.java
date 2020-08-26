package com.fq.thread;

/**
 * @author fangqi
 * @description 测试 对同一个对象获取锁，执行的wait和notify才是有效的
 * @date 2020/8/26 10:37
 */
public class ThreadTest {

    public static void main(String[] args) throws InterruptedException {
        Object o1 = new Object();
        Object o2 = new Object();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("==========o1 对象 wait===========");
                synchronized (o1) {
                    try {
                        o1.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("==========o1 对象 被唤醒===========");
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o2) {
                    System.out.println("==========o2 对象 唤醒其他线程===========");
                    o2.notify();
                }
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}
