package com.fq.thread.concurrent;

import java.util.concurrent.Exchanger;

public class ExchangerTest {

    public static void main(String[] args) {
        Exchanger exchanger = new Exchanger();

        new Thread(()->{
            String s = "s1";
            try {
                s = String.valueOf(exchanger.exchange(s));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread-1, s="+s);
        },"Thread-1").start();

        new Thread(()->{
            String s = "s2";
            try {
                s = String.valueOf(exchanger.exchange(s));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread-2, s="+s);
        },"Thread-2").start();
    }
}
