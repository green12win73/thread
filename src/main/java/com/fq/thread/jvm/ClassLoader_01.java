package com.fq.thread.jvm;

import com.sun.javafx.collections.ChangeHelper;

/**
 * 打印不同类的类加载器
 */
public class ClassLoader_01 {

    public static void main(String[] args) {
        System.out.println(String.class.getClassLoader());
        System.out.println(ChangeHelper.class.getClassLoader());
        System.out.println(ClassLoader_01.class.getClassLoader());
    }
}
