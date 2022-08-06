package com.nullzl.leetcode700;

public class LeetCode622 {
}

class MyCircularQueue {

    int[] arr;
    int start;
    int end;
    int size;

    public MyCircularQueue(int k) {
        arr = new int[k];
        start = 0;
        end = 0;
        size = 0;
    }

    public boolean enQueue(int value) {
        if(isFull())
            return false;
        arr[end] = value;
        end  = (end + 1) % arr.length;
        size++;
        return true;
    }

    public boolean deQueue() {
        if(isEmpty())
            return false;
        start = (start + 1) % arr.length;
        size--;
        return true;
    }

    public int Front() {
        if(isEmpty())
            return -1;
        return arr[start];
    }

    public int Rear() {
        if(isEmpty())
            return -1;
        int idx = (0 == end) ? arr.length - 1 : end - 1;
        return arr[idx];
    }

    public boolean isEmpty() {
        return 0 == size;
    }

    public boolean isFull() {
        return size == arr.length;
    }
}
