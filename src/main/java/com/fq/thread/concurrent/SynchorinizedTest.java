package com.fq.thread.concurrent;

/**
 * @author fangqi
 * @description
 * @date 2020/8/31 10:38
 */
public class SynchorinizedTest {

    private Object object = new Object();

    public void print(){
        synchronized (object){
            while(true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("===================");
            }
        }
    }

    public synchronized void test1(){
        while (true){

        }
    }

    public synchronized void test2(){
        System.out.println("获取对象锁");
    }

    public void test3(){
        System.out.println("非同步方法");
    }

    public static void main(String[] args) {
        SynchorinizedTest synchorinizedTest = new SynchorinizedTest();
//        new Thread(() -> {
////            for (int i = 0; i < 10000; i++) {
////                synchorinizedTest.print();
////            }
////        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchorinizedTest.test1();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchorinizedTest.test2();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchorinizedTest.test3();
            }
        }).start();
        new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchorinizedTest.print();
        }).start();
        while (true){}
    }
}
