package com.fq.thread;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author fangqi
 * @description
 * @date 2020/9/21 10:48
 */
public class TimerTest {


    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("开始执行.....");
            }
        },2000, 5000 );
    }

}
