package com.fq.thread.jvm;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 自定义类加载器
 */
public class ClassLoader_04 {

    static class MyClassLoader extends ClassLoader{
        private static final String loadPath = "C:\\Users\\fq\\Desktop\\class\\";
        private static final String suffix = ".class";
        @Override
        protected Class<?> findClass(String name) throws ClassNotFoundException{
            String fullPath = loadPath+name+suffix;
            try {
                FileInputStream fileInputStream = new FileInputStream(fullPath);
                byte[] buffer = new byte[fileInputStream.available()];
                fileInputStream.read(buffer);
                return defineClass(name, buffer, 0 , buffer.length);
            } catch (IOException e) {
                e.printStackTrace();
            }
            throw new ClassNotFoundException("找不到这个类["+fullPath+"]");
        }
    }

    public static void main(String[] args) throws Exception {
        MyClassLoader myClassLoader = new MyClassLoader();
        //jdk类加载器加载类
        Class<?> aClass = myClassLoader.loadClass("com.sun.javafx.collections.ChangeHelper");
        //自定义类加载器加载类
        Class<?> clazz = myClassLoader.loadClass("HelloWorld");
        System.out.println(clazz.toString());
        System.out.println("aClass的类加载器："+aClass.getClassLoader());
        System.out.println("clazz的类加载器："+clazz.getClassLoader());
        System.out.println("clazz的类加载器的parent类加载器："+clazz.getClassLoader().getParent());
        System.out.println("------------------执行自定义类加载器加载类的方法------------------");
        //初始化
        Constructor<?> constructor = clazz.getConstructor(null);
        Object o = constructor.newInstance(null);
        //执行方法
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            method.invoke(o,null);
        }
    }
}
