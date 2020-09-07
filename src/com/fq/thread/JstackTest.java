package com.fq.thread;

/**
 * @author fangqi
 * @description
 * @date 2020/8/25 9:15
 */
public class JstackTest {

    private int count = 0;
    public void test(){
        synchronized (this){
            while(true) {
                count++;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        JstackTest test = new JstackTest();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                test.test();
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                test.test();
            }
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
    }
}
