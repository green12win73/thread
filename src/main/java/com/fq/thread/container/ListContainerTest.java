package com.fq.thread.container;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;

/**
 * @author fangqi
 * @description
 * @date 2020/6/2 9:48
 */
public class ListContainerTest {

    public static void main(String[] args) {
        /*final int num = 100000;
        List<Integer> vector = new Vector<>();
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();
        List<Integer> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        System.out.println("=============================写入["+num+"]条数据到不同的容器，测试各自性能===============================");
        new Thread(new Runnable() {
            @Override
            public void run() {
                long time = System.currentTimeMillis();
                for (int i = 0; i < num; i++) {
                    vector.add(i);
                }
                System.out.println(Thread.currentThread().getName()+",耗时："+(System.currentTimeMillis()-time));
            }
        }, "vecotr-write").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                long time = System.currentTimeMillis();
                for (int i = 0; i < num; i++) {
                    arrayList.add(i);
                }
                System.out.println(Thread.currentThread().getName()+",耗时："+(System.currentTimeMillis()-time));
            }
        }, "arrayList-write").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                long time = System.currentTimeMillis();
                for (int i = 0; i < num; i++) {
                    linkedList.add(i);
                }
                System.out.println(Thread.currentThread().getName()+",耗时："+(System.currentTimeMillis()-time));
            }
        }, "linkedList-write").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                long time = System.currentTimeMillis();
                for (int i = 0; i < num; i++) {
                    copyOnWriteArrayList.add(i);
                }
                System.out.println(Thread.currentThread().getName()+",耗时："+(System.currentTimeMillis()-time));
            }
        }, "copyOnWriteArrayList-write").start();

        try {
           Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("=============================从不同的容器中读取["+num+"]条数据到，测试各自性能===============================");
        new Thread(new Runnable() {
            @Override
            public void run() {
                long time = System.currentTimeMillis();
                for (Integer integer : vector) {

                }
                System.out.println(Thread.currentThread().getName()+",耗时："+(System.currentTimeMillis()-time));
            }
        },"vector-read").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                long time = System.currentTimeMillis();
                for (Integer integer : arrayList) {

                }
                System.out.println(Thread.currentThread().getName()+",耗时："+(System.currentTimeMillis()-time));
            }
        },"arrayList-read").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                long time = System.currentTimeMillis();
                for (Integer integer : linkedList) {

                }
                System.out.println(Thread.currentThread().getName()+",耗时："+(System.currentTimeMillis()-time));
            }
        },"linkedList-read").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                long time = System.currentTimeMillis();
                for (Integer integer : copyOnWriteArrayList) {

                }
                System.out.println(Thread.currentThread().getName()+",耗时："+(System.currentTimeMillis()-time));
            }
        },"copyOnWriteArrayList-read").start();*/
        List<Integer> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        for (int i=0; i<10; i++) {
            copyOnWriteArrayList.add(i);
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                Iterator<Integer> iterator = copyOnWriteArrayList.iterator();
                while(iterator.hasNext()){
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(iterator.next());
                }
            }
        },"copyOnWriteArrayList-read").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                long time = System.currentTimeMillis();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for(int i=0; i<3; i++){
                    System.out.println("替换元素值 i="+(100*i));
                    copyOnWriteArrayList.add(i, 100*i);
                }
                System.out.println(Thread.currentThread().getName()+",耗时："+(System.currentTimeMillis()-time));
            }
        },"copyOnWriteArrayList-write").start();
        while (true){}
    }
}
