package com.fq.thread.container;

/**
 * @author fangqi
 * @description
 * @date 2020/6/3 9:11
 */
public class DequeContainerTest {

    public static void main(String[] args) {
        int head = (0 - 1) & (8 - 1);
        System.out.println(head);
        System.out.println((head - 1) & (8 - 1));
    }
}
