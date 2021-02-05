package com.fq.other;

import java.util.ArrayList;

/**
 * @author fangqi
 * @description
 * @date 2021/1/14 9:53
 */

class A{
    private static A a = new A();
    static{
        System.out.println("static");
    }
    public A(){
        System.out.println("A");

    }

}
public class B extends  A{

    public B(){
        System.out.println("B");
    }

    public static void main(String[] args) {
        B b = new B();
    }
}
