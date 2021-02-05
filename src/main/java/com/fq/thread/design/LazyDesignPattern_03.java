package com.fq.thread.design;

/**
 * @author fangqi
 * @description
 * @date 2020/5/9 10:48
 */
public class LazyDesignPattern_03 {
    private static LazyDesignPattern_03 lazy=null;
    private static int count = 8;
    static{
        System.out.println("=======================");
    }

    private LazyDesignPattern_03(){
        count = 10;
        System.out.println("============初始化==========");
    }

    public static LazyDesignPattern_03 getInstance(){
        if(null==lazy){
            synchronized (LazyDesignPattern_03.class) {
                if(null==lazy) {
                    lazy = new LazyDesignPattern_03();
                }
            }
        }
        return lazy;
    }

    public static void main(String[] args) {
        LazyDesignPattern_03.getInstance();
    }
}
