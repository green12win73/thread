package com.fq.thread.concurrent;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author fangqi
 * @description
 * @date 2020/5/13 14:35
 */
public class ReadAQS {
    static String s = "a";
    public static void main(String[] args) {

        ReentrantLock lock = new ReentrantLock();
        new Thread(()->{
            try{
                lock.lock();
                s = "b";
                System.out.println("s = "+s);
                Thread.sleep(2000);
            }catch (Exception e){

            }finally {
                lock.unlock();
            }
        }).start();
//        new Thread(()->{
//            try{
//                Thread.sleep(500);
//                lock.lock();
//                s = "c";
//                System.out.println("s = "+s);
//            }catch (Exception e){
//
//            }finally {
//                lock.unlock();
//            }
//        }).start();

    }
}
