package com.nullzl.interview;

import java.util.PriorityQueue;

public class Interview1720 {

    class MedianFinder {

        PriorityQueue<Integer> maxHeap;
        PriorityQueue<Integer> minHeap;

        /** initialize your data structure here. */
        public MedianFinder() {
            maxHeap = new PriorityQueue<>((op1,op2) ->{
                return op2 - op1;
            });
            minHeap = new PriorityQueue<>((op1,op2) ->{
                return op1 - op2;
            });
        }

        public void addNum(int num) {
            if(!minHeap.isEmpty() && num < minHeap.peek())
                maxHeap.add(num);
            else
                minHeap.add(num);
            if(Math.abs(minHeap.size() - maxHeap.size()) == 2){
                if (minHeap.size() > maxHeap.size()) {
                    maxHeap.add(minHeap.poll());
                } else {
                    minHeap.add(maxHeap.poll());
                }
            }
        }

        public double findMedian() {
            if(maxHeap.isEmpty() && minHeap.isEmpty())
                throw new IllegalArgumentException();
            if(maxHeap.size() == minHeap.size()){
                double sum = maxHeap.peek() + minHeap.peek();
                return sum / 2;
            }else if(maxHeap.size() > minHeap.size())
                return maxHeap.peek();
            else
                return minHeap.peek();
        }
    }
}
