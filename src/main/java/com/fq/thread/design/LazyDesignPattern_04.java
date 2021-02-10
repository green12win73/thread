package com.fq.thread.design;

/**
 * @author fangqi
 * @description
 * @date 2020/5/9 10:48
 */
public class LazyDesignPattern_04 {
    private static volatile LazyDesignPattern_04 lazy=null;
    static{
        System.out.println("=======================");
    }

    private LazyDesignPattern_04(){
        System.out.println("============初始化==========");
    }

    public static LazyDesignPattern_04 getInstance(){
        if(null==lazy){
            synchronized (LazyDesignPattern_04.class) {
                if(null==lazy) {
                    lazy = new LazyDesignPattern_04();
                }
            }
        }
        return lazy;
    }

    public static void main(String[] args) {
        LazyDesignPattern_04.getInstance();
    }
}
