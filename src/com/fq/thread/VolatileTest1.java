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
    }
}
