package com.fq.thread.design;

/**
 * 不使用责任链模式的处理逻辑
 */
public class ChainOfResponsibility_01 {
    public static void main(String[] args) {
        String string = "HELLO";
        //第一步添加下划线
        string = doSomething1(string);
        //第二步添加world
        string = doSomething2(string);
        //第三步转小写
        string = doSomething3(string);

        System.out.println(string);
    }

    private static String doSomething1(String s){
        return s+"_";
    }

    private static String doSomething2(String s){
        return s+"world";
    }

    private static String doSomething3(String s){
        return s.toLowerCase();
    }
}
