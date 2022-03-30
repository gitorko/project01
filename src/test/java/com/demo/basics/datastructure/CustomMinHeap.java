package com.demo.basics.datastructure;

import java.util.PriorityQueue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [Implement Min Heap - EASY]()
 *
 * - Heap must be a complete binary tree.
 * - Min heap is a complete binary tree, wherein the value of a root node at every step is lesser than or equal to value at the child node.
 * - Time: O(1) to find min element.
 */
public class CustomMinHeap {

    @Test
    public void test() {
        MinHeap minHeap = new MinHeap(15);
        minHeap.insert(4);
        minHeap.insert(2);
        minHeap.insert(5);
        minHeap.insert(13);
        minHeap.insert(1);
        minHeap.insert(6);
        minHeap.insert(17);
        minHeap.print();
        Assertions.assertEquals(1, minHeap.extractMin());
    }

    /**
     * Approach 2:
     * Using priority queue
     */
    @Test
    public void test1() {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.add(4);
        minHeap.add(2);
        minHeap.add(5);
        minHeap.add(13);
        minHeap.add(1);
        minHeap.add(6);
        minHeap.add(17);
        Assertions.assertEquals(1, minHeap.poll());
    }

    class MinHeap {
        private int[] heap;
        private int size;
        private int maxsize;

        private final int FRONT = 1;

        // Constructor of this class
        public MinHeap(int maxsize) {

            // This keyword refers to current object itself
            this.maxsize = maxsize;
            this.size = 0;

            heap = new int[this.maxsize + 1];
            heap[0] = Integer.MIN_VALUE;
        }

        // Returning the position of
        // the parent for the node currently
        // at pos
        private int parent(int pos) {
            return pos / 2;
        }

        // Returning the position of the
        // left child for the node currently at pos
        private int leftChild(int pos) {
            return (2 * pos);
        }

        // Returning the position of
        // the right child for the node currently
        // at pos
        private int rightChild(int pos) {
            return (2 * pos) + 1;
        }

        // Returning true if the passed
        // node is a leaf node
        private boolean isLeaf(int pos) {
            if (pos > (size / 2) && pos <= size) {
                return true;
            }
            return false;
        }

        // To swap two nodes of the heap
        private void swap(int fpos, int spos) {
            int tmp;
            tmp = heap[fpos];
            heap[fpos] = heap[spos];
            heap[spos] = tmp;
        }

        // To heapify the node at pos
        private void minHeapify(int pos) {

            // If the node is a non-leaf node and greater
            // than any of its child
            if (!isLeaf(pos)) {
                if (heap[pos] > heap[leftChild(pos)]
                        || heap[pos] > heap[rightChild(pos)]) {

                    // Swap with the left child and heapify
                    // the left child
                    if (heap[leftChild(pos)]
                            < heap[rightChild(pos)]) {
                        swap(pos, leftChild(pos));
                        minHeapify(leftChild(pos));
                    }

                    // Swap with the right child and heapify
                    // the right child
                    else {
                        swap(pos, rightChild(pos));
                        minHeapify(rightChild(pos));
                    }
                }
            }
        }

        // To insert a node into the heap
        public void insert(int element) {
            if (size >= maxsize) {
                return;
            }
            heap[++size] = element;
            int current = size;
            while (heap[current] < heap[parent(current)]) {
                swap(current, parent(current));
                current = parent(current);
            }
        }

        // To print the contents of the heap
        public void print() {
            for (int i = 1; i <= size / 2; i++) {
                // Printing the parent and both childrens
                System.out.print(
                        " PARENT : " + heap[i]
                                + " LEFT CHILD : " + heap[2 * i]
                                + " RIGHT CHILD :" + heap[2 * i + 1]);

                // By here new line is required
                System.out.println();
            }
        }

        public int extractMin() {
            int popped = heap[FRONT];
            heap[FRONT] = heap[size--];
            minHeapify(FRONT);
            return popped;
        }
    }

}

