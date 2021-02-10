package com.fq.thread;

/**
 * @author fangqi
 * @description
 * @date 2020/9/7 8:50
 */
public class ThreadDumpTest {

    public static Object object = new Object();

    public static void main(String[] args) throws InterruptedException {
        //new状态的线程
        Thread newThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        },"new-thread");
        Thread runningThread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName());
                }
            }
        },"runningThread");
        Thread runnableThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        },"runnableThread");
        Thread waitThread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (object){
                    System.out.println(Thread.currentThread().getName());
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"waitThread");
        Thread timedWaitThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (object){
                    System.out.println(Thread.currentThread().getName());
                    try {
                        object.wait(200000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"timedWaitThread");
        Thread lockThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
                synchronized (object){
                    while(true){

                    }
                }
            }
        },"lockThread");
        Thread blockThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
                synchronized (object){
                    System.out.println(Thread.currentThread().getName()+"获取到锁");
                }
            }
        },"blockThread");
        runningThread.setPriority(1);
        runningThread.start();
        runnableThread.start();
        runnableThread.yield();
        waitThread.start();
        timedWaitThread.start();
        lockThread.start();
        blockThread.start();
        while (true){

        }
    }
}
