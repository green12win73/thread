package com.fq.thread.concurrent;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author fangqi
 * @description
 * @date 2020/5/14 8:35
 */
public class ReadAQS_01 {

    private String s = "s";
    private ReentrantLock lock = new ReentrantLock(true);

    public void update(){
        boolean b = lock.tryLock();
        if(b) {
            try {
                s = "s1";
                print();
                try {
                    Thread.sleep(20000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } catch (Exception e) {

            } finally {
                lock.unlock();
            }
        }
    }

    public void print(){
        boolean b = lock.tryLock();
        if(b) {
            try {
                System.out.println(s);
            } catch (Exception e) {

            } finally {
                lock.unlock();
            }
        }
    }

    public void test(){
        try {
            lock.lock();
            System.out.println(s);
            Thread.sleep(60000);
        } catch (Exception e) {

        } finally {
//            lock.unlock();
        }
    }


    public static void main(String[] args) {
        ReadAQS_01 aqs_01 = new ReadAQS_01();
        new Thread(()->{
            try {
                Thread.sleep(60000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            aqs_01.test();
        },"Thread-01").start();
        new Thread(()->{
            aqs_01.test();
        },"Thread-02").start();
    }
}
