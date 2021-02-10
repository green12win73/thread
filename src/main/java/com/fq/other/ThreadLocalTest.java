package com.fq.other;

/**
 * @author fangqi
 * @description
 * @date 2021/1/15 9:42
 */
public class ThreadLocalTest {

    public static final ThreadLocal<Integer> THREAD_LOCAL = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {
//        THREAD_LOCAL.set(123);
//        for (int i = 0; i < 18; i++) {
//            final int A = i;
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    System.out.println(Thread.currentThread().getName()+"==>>写===>>>"+(456+A));
//                    THREAD_LOCAL.set(456+A);
//                    System.out.println(Thread.currentThread().getName()+"==>>读===>>>"+THREAD_LOCAL.get());
//                }
//            }).start();
//        }
//        Thread.sleep(1000);
//        System.out.println("main===>>>"+Thread.currentThread().getName()+"===>>>"+THREAD_LOCAL.get());

        System.out.println(get());

    }

    public static String get(){
        StringBuffer stringBuffer =  new StringBuffer();
        try{
            stringBuffer.append("123");
            return stringBuffer.toString();
        }finally {
            stringBuffer.append("444");
        }
    }
}
