package com.jasper;

import java.util.PriorityQueue;

/**
 * 小顶堆：任意一个字节点的值<=其父节点的值
 * 大顶堆：任意一个字节点的值>=其父节点的值
 *
 */
public class PriorityQueueDemo {
    public static void main(String[] args) {
        final PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        final PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

    }
}
