package com.fq.thread;

import java.util.ArrayList;
import java.util.List;
import javax.swing.LayoutFocusTraversalPolicy;

/**
 * @author fangqi
 * @description
 * @date 2020/5/7 17:18
 */
public class LazySingletonPattern {

    private static /*volatile*/ LazySingletonPattern lazy = null;
    private int count = 0;
    private LazySingletonPattern(){
        count = 8;
    }

    public static LazySingletonPattern getInstance(){
        if(null==lazy){
            synchronized (LazySingletonPattern.class){
                if(null==lazy){
                    lazy = new LazySingletonPattern();
                }
            }
        }
        return lazy;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public static void main(String[] args) {
        //定义线程组
        ThreadGroup threadGroup = new ThreadGroup("test");
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(threadGroup, String.valueOf(i)){
                @Override
                public void run() {
                    System.out.println("线程名称：" + this.getName()+",count="+LazySingletonPattern.getInstance().getCount());
                }
            });
        }
        for (Thread thread : threads) {
            thread.start();
        }
        //等待同组的线程全部执行完成
        while(threadGroup.activeCount()>0){
            //如果还有子线程没有执行完成，则主线yield，让子线程继续执行
            Thread.yield();
        }
    }
}
