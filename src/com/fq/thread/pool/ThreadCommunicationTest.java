package com.fq.thread.pool;

/**
 * @author fangqi
 * @description
 * @date 2020/7/2 9:35
 */
public class ThreadCommunicationTest {

    private int num;

    private Object object = new Object();

    private Object object2 = new Object();

    public void add() throws InterruptedException {
        synchronized (object){
            object.notifyAll();
            if(num==100){
                System.out.println("值为100，等待减少....");
                object.wait();
            }
        }
        num++;
        System.out.println("============add num="+num+"============");
    }

    public void sub() throws InterruptedException {
        synchronized (object){
            object.notifyAll();
            if(num==0){
                System.out.println("值为0，等待增加....");
                object.wait();
            }

        }
        num--;
        System.out.println("============sub num="+num+"============");
    }

    public void sync() throws InterruptedException {
        synchronized (object2){
            object2.wait();
            while(true) {
                System.out.println("=========object2被唤醒==========");
            }
        }
    }

    public static void main(String[] args) {
        ThreadCommunicationTest test = new ThreadCommunicationTest();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    try {
                        test.add();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    try {
                        Thread.sleep(100);
                        test.sub();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    test.sync();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
