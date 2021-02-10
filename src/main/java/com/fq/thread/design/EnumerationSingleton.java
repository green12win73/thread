package com.fq.thread.design;

/**
 * @author fangqi
 * @description
 * @date 2020/5/9 10:48
 */
public enum EnumerationSingleton {

    INSTANCE;
    private int count=0;

    private EnumerationSingleton(){
       count=8;
    }

    public int getCount() {
        return count;
    }

    public static void main(String[] args)
            throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        EnumerationSingleton instance = EnumerationSingleton.INSTANCE;
        System.out.println("count="+instance.getCount());

        Object o = Class.forName("com.fq.thread.design.EnumerationSingleton").newInstance();
        EnumerationSingleton lazy = (EnumerationSingleton)o;

        System.out.println("instance.hashCode="+instance.hashCode());
        System.out.println("lazy.hashCode="+lazy.hashCode());
    }
}
