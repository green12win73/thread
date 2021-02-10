package com.fq.other;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author fangqi
 * @description
 * @date 2021/2/5 15:14
 */
public class ObjectHeaderTest {

    public static void main(String[] args) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        User user = new User();
        User[] userArr = new User[10];
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (user){
                    try {
                        user.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        System.out.println("==========>>>>>>>>>>>>>>>>>对象结构");
        System.out.println(ClassLayout.parseInstance(user).toPrintable());
        System.out.println("==========>>>>>>>>>>>>>>>>>对象数组结构");
        System.out.println(ClassLayout.parseInstance(userArr).toPrintable());
        System.gc();
        System.out.println("==============================1次垃圾回收==============================");
        System.out.println("==========>>>>>>>>>>>>>>>>>对象结构");
        System.out.println(ClassLayout.parseInstance(user).toPrintable());
        System.out.println("==========>>>>>>>>>>>>>>>>>对象数组结构");
        System.out.println(ClassLayout.parseInstance(userArr).toPrintable());
        System.gc();
        System.out.println("==============================2次垃圾回收==============================");
        System.out.println("==========>>>>>>>>>>>>>>>>>对象结构");
        System.out.println(ClassLayout.parseInstance(user).toPrintable());
        System.out.println("==========>>>>>>>>>>>>>>>>>对象数组结构");
        System.out.println(ClassLayout.parseInstance(userArr).toPrintable());
    }
}
