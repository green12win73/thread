package com.fq.thread.container;

import java.util.PriorityQueue;

/**
 * @author fangqi
 * @description
 * @date 2021/1/12 9:56
 */
public class PriorityQueueTest {

    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 10; i >= 0; i--) {
            priorityQueue.add(i);
        }
        priorityQueue.remove(4);
    }
}
