package com.fq.thread.concurrent;

/**
 * @author fangqi
 * @description
 * @date 2020/8/31 10:38
 */
public class SynchorinizedTest {

    private Object object = new Object();

    public void print(){
        synchronized (object){
            while(true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("===================");
            }
        }
    }

    public static void main(String[] args) {
        SynchorinizedTest synchorinizedTest = new SynchorinizedTest();
        new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                synchorinizedTest.print();
            }
        }).start();
    }
}
