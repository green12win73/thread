package com.fq.thread.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author fangqi
 * @description
 * @date 2020/5/14 8:35
 */
public class ReadAQS_02 {

    private String s = "s";
    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void test(){
        try{
            lock.lock();
            System.out.println("================");
            condition.await();
        }catch (Exception e){

        }finally {
            lock.unlock();
        }
    }


    public static void main(String[] args) {
        ReadAQS_02 aqs_01 = new ReadAQS_02();
        new Thread(()->{
            try {
                Thread.sleep(60000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            aqs_01.test();
        },"Thread-01").start();
        new Thread(()->{
            try {
                Thread.sleep(50000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            aqs_01.test();
        },"Thread-02").start();
        new Thread(()->{
            aqs_01.test();
        },"Thread-03").start();
    }
}
