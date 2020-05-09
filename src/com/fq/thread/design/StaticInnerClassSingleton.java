package com.fq.thread.design;

/**
 * @author fangqi
 * @description
 * @date 2020/5/9 10:48
 */
public class StaticInnerClassSingleton {

    private StaticInnerClassSingleton(){
        System.out.println("=======StaticInnerClassSingleton========");
        if(null!=SingletonHolder.holder){
            throw new RuntimeException("不能通过反射初始化该对象");
        }
    }

    public static StaticInnerClassSingleton getInstance(){
        return SingletonHolder.holder;
    }

    private static class SingletonHolder{
        static{
            System.out.println("===========SingletonHolder==========");
        }
        private static final StaticInnerClassSingleton holder = new StaticInnerClassSingleton();
    }


    public static void main(String[] args)
            throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        StaticInnerClassSingleton instance = StaticInnerClassSingleton.getInstance();

        Object o = Class.forName("com.fq.thread.design.StaticInnerClassSingleton").newInstance();
        StaticInnerClassSingleton lazy = (StaticInnerClassSingleton)o;

        System.out.println("instance.hashCode="+instance.hashCode());
        System.out.println("lazy.hashCode="+lazy.hashCode());
    }
}
