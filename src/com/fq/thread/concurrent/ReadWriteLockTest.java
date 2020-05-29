package com.fq.thread.concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

/**
 * @author fangqi
 * @description
 * @date 2020/5/11 17:38
 */
public class ReadWriteLockTest {

    static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    static Lock readLock = lock.readLock();//共享锁
    static Lock writeLock = lock.writeLock();//排他锁，加上写锁，在写的时候不能读
    static int count = 0;
    public static int read(){
        readLock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+",读取count="+count);
            return count;
        }catch (Exception e){

        }finally {
//            readLock.unlock();
        }
        return 0;
    }

    public static void write(){
        writeLock.lock();
        try {
//            Thread.sleep(1000);
            count++;
            System.out.println(Thread.currentThread().getName()+",更新count="+count);
            test();
        }catch (Exception e){

        }
        finally {
//            writeLock.unlock();
        }
    }

    private static void test(){
        writeLock.lock();
        try {
            Thread.sleep(1000);
            count++;
            System.out.println(Thread.currentThread().getName()+",锁重入");
        }catch (Exception e){

        }
        finally {
//            writeLock.unlock();
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(10000);
                    }catch (Exception e){

                    }
                    read();
                }
            }, "thread-reader" + i).start();
        }
        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
//                    try {
//                        Thread.sleep(10000);
//                    }catch (Exception e){
//
//                    }
                    write();
                }
            }, "thread-write-" + i).start();
        }
    }
}
