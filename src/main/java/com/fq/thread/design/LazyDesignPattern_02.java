package com.fq.thread.design;

/**
 * @author fangqi
 * @description
 * @date 2020/5/9 10:48
 */
public class LazyDesignPattern_02 {
    private static LazyDesignPattern_02 lazy=null;
    private LazyDesignPattern_02(){}

    public static LazyDesignPattern_02 getInstance(){
        if(null==lazy){
            synchronized (LazyDesignPattern_02.class) {
                lazy = new LazyDesignPattern_02();
            }
        }
        return lazy;
    }
}
