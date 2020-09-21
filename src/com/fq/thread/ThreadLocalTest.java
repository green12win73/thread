package com.fq.thread;

/**
 * @author fangqi
 * @description
 * @date 2020/9/16 10:32
 */
public class ThreadLocalTest {

    class Person{
        public int age=10;
        public String name="John";
    }

    public ThreadLocal<Person> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {
        ThreadLocalTest threadLocalTest = new ThreadLocalTest();
        Person person = threadLocalTest.new Person();
        threadLocalTest.threadLocal.set(person);
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                threadLocalTest.threadLocal.set(person);
            }
        }, "Thread-1");

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                threadLocalTest.threadLocal.set(person);
//                threadLocalTest.threadLocal.get().age=12;
//                threadLocalTest.threadLocal.set(person);
            }
        }, "Thread-2");
        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("age="+threadLocalTest.threadLocal.get().age);
//        System.out.println("Thread-2,age="+threadLocalTest.threadLocal.get().age);
    }
}
