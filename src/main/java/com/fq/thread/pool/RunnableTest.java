package com.fq.thread.pool;

/**
 * @author fangqi
 * @description
 * @date 2020/6/12 14:22
 */
public class RunnableTest {

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("================");
            }
        }).start();
    }
}
