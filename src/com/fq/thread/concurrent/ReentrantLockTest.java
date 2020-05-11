package com.fq.thread.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author fangqi
 * @description
 * @date 2020/5/11 15:18
 */
public class ReentrantLockTest {

    private ReentrantLock lock = new ReentrantLock();
//    private ReentrantLock lock = new ReentrantLock(true);
//    private ReentrantLock lock = new ReentrantLock(false);

    private int count = 0;

    public void add(){
        try {
            lock.lock();
            Thread.sleep(5000);
            count++;
        }catch (Exception e){

        }finally {
            lock.unlock();
        }
    }

    public void tryLock(){
        boolean b = false;
        try {
            b = lock.tryLock();
            if(!b){
                System.out.println("尝试获取锁失败!");
                return;
            }
            System.out.println("====================");
        }catch (Exception e){

        }finally {
            if(b) lock.unlock();
        }
    }

    public void tryLockTime(){
        boolean b = false;
        try {
            lock.tryLock(1000, TimeUnit.MILLISECONDS);
            if(!b){
                System.out.println("1s内尝试获取锁失败!");
                return;
            }
            System.out.println("==========tryLockTime===========");
        }catch (Exception e){

        }finally {
            if(b) lock.unlock();
        }
    }

    public void lockInterruptibly(){
        try {
            Thread.currentThread().interrupt();
            lock.lockInterruptibly();
            System.out.println("获取锁成功");
        }catch (Exception e){
            System.out.println("线程中断，获取锁失败!");
            e.printStackTrace();
        }finally {
            //如果线程已经中断，这个时候抛出的异常：Exception in thread "Thread-1" java.lang.IllegalMonitorStateException
            //表示monitor状态异常
            lock.unlock();
        }
    }

    public void lockInterruptibly1(){
        try {
            Thread.currentThread().interrupt();
            lock.lockInterruptibly();
            try {
                System.out.println("获取锁成功");
            }catch (Exception e){

            }finally {
                lock.unlock();
            }
        }catch (Exception e){
            System.out.println("线程中断，获取锁失败!");
            //这个时候抛出的异常：java.lang.InterruptedException
            //线程中断异常
            e.printStackTrace();
        }
    }

    public void lock(){
        for (int i = 0; i < 100; i++) {
            try {
                lock.lock();
                System.out.println("Thread Name:" + Thread.currentThread().getName());
            } catch (Exception e) {

            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        ReentrantLockTest lockTest = new ReentrantLockTest();
//        new Thread(()->{
//            lockTest.add();
//        }).start();
//        new Thread(()->{
//            lockTest.tryLock();
//        }).start();
//        new Thread(()->{
//            lockTest.tryLockTime();
//        }).start();
//        Thread thread = new Thread(()->{
//            lockTest.lockInterruptibly();
//        });
//        thread.start();

        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(new Runnable() {
                            @Override
                            public void run() {
                                lockTest.lock();
                            }
                        }, "thread-" + i));
        }
        for (Thread thread : threads) {
            thread.start();
        }
    }
}
