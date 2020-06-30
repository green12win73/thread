package com.fq.thread.pool;

/**
 * @author fangqi
 * @description
 * @date 2020/6/12 14:22
 */
public class ThreadTest {

    public static void main(String[] args) throws InterruptedException {
//        testJoin();
//        testYield();
        testDaemon();
        System.out.println("=====================");
    }

    private static void testDaemon() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("============"+ Thread.currentThread().getName() +"_"+ i + "===========");
                }
            }
        });
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("============ Thread_"+ i + "===========");
                }
            }
        });
        thread1.setDaemon(true);
        thread.start();
        thread1.start();
    }

    public static void testYield(){
        for (int j = 0; j < 100; j++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 10; i++) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        if(i==5 && Thread.currentThread().getName().equals("Thread_5")){
                            System.out.println("Thread_5 让出处理器");
                            Thread.yield();
                        }
                        System.out.println("============"+ Thread.currentThread().getName() +"_"+ i + "===========");
                    }
                }
            },"Thread_"+j);
            thread.start();
        }
    }

    public static void testJoin(){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("============" + i + "===========");
                }
            }
        });

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
//                    try {
//                        thread.join();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                    System.out.println("============ thread1" + i + "===========");
                }
            }
        });
        thread.start();
        thread1.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("=========================");
    }
}
