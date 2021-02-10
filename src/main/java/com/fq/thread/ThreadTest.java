package com.fq.thread;

/**
 * @author fangqi
 * @description 测试 对同一个对象获取锁，执行的wait和notify才是有效的
 * @date 2020/8/26 10:37
 */
public class ThreadTest {

    public static void main(String[] args) throws InterruptedException {
        Object o1 = new Object();
        Object o2 = new Object();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("==========o1 对象 wait===========");
                boolean flag = false;
                while (!(flag=Thread.currentThread().interrupted())){
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println(Thread.currentThread().getName());
                    System.out.println("中断状态："+Thread.currentThread().getState().name()+",flag="+flag);
                }
                System.out.println("jiesh状态："+Thread.currentThread().getState().name()+",flag="+flag);
//                System.out.println("==========o1 对象 被唤醒===========");
            }
        });
//        Thread t2 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (true){
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println(Thread.currentThread().getName());
//                }
//            }
//        });
        t1.start();
        Thread.sleep(3000);
        System.out.println("中断线程");
        t1.interrupt();
        Thread.sleep(3000);
        System.out.println("中断状态："+t1.getState().name());
        System.out.println("中断状态："+t1.interrupted());
//        t2.start();
//        t1.join();
//        t2.join();
    }
}
