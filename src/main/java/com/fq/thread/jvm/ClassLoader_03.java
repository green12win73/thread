package com.fq.thread.jvm;

import com.sun.javafx.collections.ChangeHelper;

/**
 * 打印类加载器的父加载器
 */
public class ClassLoader_03 {

    public static void main(String[] args) {
        System.out.println(String.class.getClassLoader());
        System.out.println(ChangeHelper.class.getClassLoader());
        System.out.println(ChangeHelper.class.getClassLoader().getParent());
        System.out.println(ClassLoader_03.class.getClassLoader().getParent());
        System.out.println(ClassLoader_03.class.getClassLoader().getParent().getParent());
    }
}
