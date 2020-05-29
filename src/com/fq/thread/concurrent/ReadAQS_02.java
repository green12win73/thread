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

    public void await(){
        try{
            lock.lock();
            System.out.println("========"+Thread.currentThread()+"获取到锁========");
            //阻塞，当前线程添加到阻塞队列，释放锁，被唤醒后会继续争抢锁
            System.out.println("========"+Thread.currentThread()+"调用await()阻塞线程，释放锁========");
            condition.await();
            s += "["+Thread.currentThread().getName()+"],";
            System.out.println(Thread.currentThread()+"被唤醒！！！");
            System.out.println("s="+s);
        }catch (Exception e){

        }finally {
            lock.unlock();
        }
    }

    public void signalAll(){
        try{
            lock.lock();
            System.out.println("========"+Thread.currentThread()+"========");
            //唤醒所有阻塞的队列中的线程，争抢锁
            System.out.println("========"+Thread.currentThread()+"唤醒所有阻塞线程，争抢锁========");
            condition.signalAll();//唤醒所有节点从首节点开始
//            condition.signal();//唤醒首节点的等待线程
        }catch (Exception e){

        }finally {
            lock.unlock();
        }
    }


    public static void main(String[] args) {
        ReadAQS_02 aqs_01 = new ReadAQS_02();
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                aqs_01.await();
            },"Thread-"+i).start();
        }
        new Thread(()->{
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            aqs_01.signalAll();
        },"Thread-03").start();
    }
}
