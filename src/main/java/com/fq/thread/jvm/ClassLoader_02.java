package com.fq.thread.jvm;

import com.sun.javafx.collections.ChangeHelper;

/**
 * 打印类加载器的加载器
 */
public class ClassLoader_02 {

    public static void main(String[] args) {
        System.out.println(String.class.getClassLoader());
        System.out.println(ChangeHelper.class.getClassLoader().getClass().getClassLoader());
        System.out.println(ClassLoader_02.class.getClassLoader().getClass().getClassLoader());
    }
}
