package com.fq.thread.design;

/**
 * @author fangqi
 * @description
 * @date 2020/5/9 10:48
 */
public class LazyDesignPattern_01 {
    private static LazyDesignPattern_01 lazy=null;
    private LazyDesignPattern_01(){}

    public static LazyDesignPattern_01 getInstance(){
        if(null==lazy){
            lazy = new LazyDesignPattern_01();
        }
        return lazy;
    }
}
