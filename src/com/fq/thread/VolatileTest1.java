package com.fq.thread;

import java.awt.geom.FlatteningPathIterator;
import java.util.ArrayList;
import java.util.List;

/**
 * @author fangqi
 * @description
 * @date 2020/5/7 15:34
 */
public class VolatileTest1 extends Thread{

   private static volatile boolean flag = false;
//    private static volatile boolean flag = false;

   @Override
   public void run(){
       while (!flag) {
//           System.out.println("======================");
       }
       System.out.println("退出死循环");
   }

    public static void main(String[] args) throws InterruptedException {
//        new VolatileTest1().start();
//        Thread.sleep(1000);
        flag = true;

        Long g = 3L;
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer e = 321;
        Integer f = 321;
        System.out.println(g==(a+b));
        System.out.println(g.equals(a+b));
        System.out.println(c.equals(a+b));
        System.out.println(e == f);
    }
}
