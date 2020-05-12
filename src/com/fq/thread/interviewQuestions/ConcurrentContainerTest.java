package com.fq.thread.interviewQuestions;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author fangqi
 * @description
 * @date 2020/5/12 15:35
 */
public class ConcurrentContainerTest {

    List<Integer> list = new ArrayList<>();
    private static final int MAX = 10;
    private int count = 0;
    private ReentrantLock lock = new ReentrantLock();
    private Condition productor = lock.newCondition();
    private Condition consumer = lock.newCondition();
    public void put(Integer e) {
        try {
            lock.lock();
            //当线程被唤醒后，会继续监测是否等于MAX，如果等于，则继续等待
            while (MAX == list.size()) {
                try {
                    System.out.println("生产者线程阻塞，threadName=" + Thread.currentThread().getName());
                    productor.await();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
            list.add(e);
            count++;
        }catch (Exception ex) {

        }finally {
            consumer.signalAll();
            lock.unlock();

        }
    }

    public Integer get() {
        Integer remove = null;
        try {
            lock.lock();
            while (0 == list.size()) {
                try {
                    System.out.println("消费者线程阻塞，threadName=" + Thread.currentThread().getName());
                    consumer.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            remove = list.remove(0);
            count--;

        }catch (Exception e){

        }finally {
            productor.signalAll();
            lock.unlock();
        }
        return remove;
    }

    public Integer getCount() {
        try {
            lock.lock();
            return count;
        }catch (Exception e){

        }finally {
            lock.unlock();
        }
        return null;
    }

    public static void main(String[] args) {
        ConcurrentContainerTest test = new ConcurrentContainerTest();
        for(int i=0; i<2; i++) {
            new Thread(() -> {
                int j = 0;
                while(true){
                    System.out.println("添加元素，e="+j);
                    test.put(j);
                    j++;
                }
            },"producter-"+i).start();
        }
        for(int i=0; i<10; i++) {
            new Thread(() -> {
                int j = 0;
                while(true){
//                    try {
//                        TimeUnit.SECONDS.sleep(1);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                    System.out.println("获取元素，e="+test.get());
                }
            },"consumer-"+i).start();
        }
    }
}
