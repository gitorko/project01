package com.demo.basics.datastructure;

import java.util.Collections;
import java.util.PriorityQueue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [Implement Max Heap - EASY]()
 *
 * - Heap must be a complete binary tree.
 * - Max heap is a complete binary tree, wherein the value of a root node at every step is greater than or equal to value at the child node.
 */
public class CustomMaxHeap {

    @Test
    public void test() {
        MaxHeap maxHeap = new MaxHeap(15);
        maxHeap.insert(1);
        maxHeap.insert(4);
        maxHeap.insert(2);
        maxHeap.insert(5);
        maxHeap.insert(13);
        maxHeap.insert(6);
        maxHeap.insert(17);
        Assertions.assertEquals(17, maxHeap.extractMax());
    }

    /**
     * Approach 2:
     * Using priority queue
     *
     * Time: Find O(1)
     * Time: Insert O(log n)
     * Time: Delete O(log n)
     */
    @Test
    public void test1() {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.add(1);
        maxHeap.add(4);
        maxHeap.add(2);
        maxHeap.add(5);
        maxHeap.add(13);
        maxHeap.add(6);
        maxHeap.add(17);
        Assertions.assertEquals(17, maxHeap.poll());
    }

    class MaxHeap {
        private int[] heap;
        private int size;
        private int maxsize;

        public MaxHeap(int size) {
            this.maxsize = size;
            this.size = 0;
            heap = new int[this.maxsize + 1];
            heap[0] = Integer.MAX_VALUE;
        }

        private int parent(int pos) {
            return pos / 2;
        }

        private int leftChild(int pos) {
            return (2 * pos);
        }

        private int rightChild(int pos) {
            return (2 * pos) + 1;
        }

        private void swap(int fpos, int spos) {
            int tmp;
            tmp = heap[fpos];
            heap[fpos] = heap[spos];
            heap[spos] = tmp;
        }

        private void downHeapify(int pos) {
            if (pos >= (size / 2) && pos <= size) {
                return;
            }
            if (heap[pos] < heap[leftChild(pos)] || heap[pos] < heap[rightChild(pos)]) {
                if (heap[leftChild(pos)] > heap[rightChild(pos)]) {
                    swap(pos, leftChild(pos));
                    downHeapify(leftChild(pos));
                } else {
                    swap(pos, rightChild(pos));
                    downHeapify(rightChild(pos));
                }
            }
        }

        private void heapifyUp(int pos) {
            int temp = heap[pos];
            while (pos > 0 && temp > heap[parent(pos)]) {
                heap[pos] = heap[parent(pos)];
                pos = parent(pos);
            }
            heap[pos] = temp;
        }

        public void insert(int element) {
            heap[++size] = element;
            int current = size;
            heapifyUp(current);
        }

        public int extractMax() {
            int max = heap[1];
            heap[1] = heap[size--];
            downHeapify(1);
            return max;
        }
    }

}

