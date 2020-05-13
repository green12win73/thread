package com.fq.thread.interviewQuestions;

import java.util.concurrent.locks.LockSupport;

/**
 * @author fangqi
 * @description LockSupport实现，两个线程交替输出A1B2....Z26,A线程输出A-Z,B线程输出1-26
 * @date 2020/5/13 10:43
 */
public class AlternatePrintTest01 {
    public static Thread t1;
    public static Thread t2;
    public static void main(String[] args) {
        //一下方式可以实现交替打印，但是字母在前还是数字在前不确定，除非让打印数字的线程在启动时先睡一会，让打印字母的先执行
        t1 = new Thread(()->{
            for (int i = 65; i <= 90; i++) {
                char a = (char) i;
                System.out.println(a);
                LockSupport.unpark(t2);
                if(i<90) {
                    LockSupport.park();
                }
            }
        });

        t2 = new Thread(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 1; i <= 26; i++) {
                System.out.println(i);
                LockSupport.unpark(t1);
                if(i<26) {
                    LockSupport.park();
                }
            }
        });
        t1.start();
        t2.start();
    }
}
