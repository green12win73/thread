package com.fq.thread;


/**
 * @author fangqi
 * @description
 * @date 2020/11/5 14:29
 */
public class StringSyncTest {

    public void test(String s){
        String lock = "_lock";
        synchronized (lock){
            while(true){
                System.out.println(Thread.currentThread().getName());
            }
        }
    }

    public static void main(String[] args) {
        StringSyncTest stringSyncTest = new StringSyncTest();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                stringSyncTest.test("test");
            }
        },"thread-1");

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                stringSyncTest.test("test");
            }
        },"thread-2");

        thread1.start();
        thread2.start();
        while (true){}
    }
}
