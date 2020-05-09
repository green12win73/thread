package com.fq.thread.design;

import java.util.concurrent.CountDownLatch;

/**
 * @author fangqi
 * @description
 * @date 2020/5/9 10:19
 */
public class HungaryDesignPattern {
    private static final HungaryDesignPattern hungary = new HungaryDesignPattern();
    public int count = 1;
    private HungaryDesignPattern(){
        System.out.println("=============初始化============");
    }

    public static HungaryDesignPattern getInstance(){
        return hungary;
    }

    public static void main(String[] args) throws Exception {
        HungaryDesignPattern o = (HungaryDesignPattern)Class.forName("com.fq.thread.design.HungaryDesignPattern").newInstance();
        o.count = 2;
        System.out.println(o.count);
    }
}
