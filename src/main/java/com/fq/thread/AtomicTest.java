package com.fq.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author fangqi
 * @description
 * @date 2020/8/26 8:47
 */
public class AtomicTest {

    public static volatile AtomicInteger count = new AtomicInteger();

    public static void main(String[] args) {
        count.incrementAndGet();
        count.incrementAndGet();
        count.incrementAndGet();
        System.out.println(count.get());
    }
}
