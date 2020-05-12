package com.fq.thread.interviewQuestions;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fangqi
 * @description
 * @date 2020/5/12 15:35
 */
public class ConcurrentContainerTest01 {

    List<Integer> list = new ArrayList<>();
    private static final int MAX = 10;
    private int count = 0;
    public synchronized void put(Integer e) {
        //当线程被唤醒后，会继续监测是否等于MAX，如果等于，则继续等待
        while(MAX == list.size()){
            try {
                System.out.println("生产者线程阻塞，threadName="+Thread.currentThread().getName());
                //释放所
                this.wait();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        list.add(e);
        count++;
        //不会释放锁，需要唤醒其他等待队列，主要希望唤醒消费线程，获取元素
        this.notifyAll();
    }

    public synchronized Integer get() {
        while(0 == list.size()){
            try {
                System.out.println("消费者线程阻塞，threadName="+Thread.currentThread().getName());
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Integer remove = list.remove(0);
        count--;
        //唤醒其他线程，主要希望唤醒生产线程，添加元素
        this.notifyAll();
        return remove;
    }

    public synchronized Integer getCount() {
        return count;
    }

    public static void main(String[] args) {
        ConcurrentContainerTest01 test = new ConcurrentContainerTest01();
        for(int i=0; i<2; i++) {
            new Thread(() -> {
                for (int j = 0; j < 10; j++) {
                    System.out.println("添加元素，e="+j);
                    test.put(j);
                }
            },"producter-"+i).start();
        }
        for(int i=0; i<10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 10; j++) {
                    System.out.println("获取元素，e="+test.get());
                }
            },"consumer-"+i).start();
        }
    }
}
