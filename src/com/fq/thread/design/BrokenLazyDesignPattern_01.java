package com.fq.thread.design;

/**
 * @author fangqi
 * @description
 * @date 2020/5/9 10:48
 */
public class BrokenLazyDesignPattern_01 {
    private static volatile BrokenLazyDesignPattern_01 lazy=null;

    private BrokenLazyDesignPattern_01(){}

    public static BrokenLazyDesignPattern_01 getInstance(){
        if(null==lazy){
            synchronized (BrokenLazyDesignPattern_01.class) {
                if(null==lazy) {
                    lazy = new BrokenLazyDesignPattern_01();
                }
            }
        }
        return lazy;
    }

    public static void main(String[] args)
            throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        BrokenLazyDesignPattern_01 instance = BrokenLazyDesignPattern_01.getInstance();

        Object o = Class.forName("com.fq.thread.design.BrokenLazyDesignPattern_01").newInstance();
        BrokenLazyDesignPattern_01 lazy = (BrokenLazyDesignPattern_01)o;

        System.out.println("instance.hashCode="+instance.hashCode());
        System.out.println("lazy.hashCode="+lazy.hashCode());
    }
}
