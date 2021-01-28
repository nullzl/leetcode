package main.java.com.nullzl.leetcode300;

import java.util.PriorityQueue;

public class LeetCode295 {

    class MedianFinder {

        private PriorityQueue<Integer> maxHeap;
        private PriorityQueue<Integer> minHeap;

        /** initialize your data structure here. */
        public MedianFinder() {
            maxHeap = new PriorityQueue<>(
                    (n1,n2) -> n2 - n1
            );
            minHeap = new PriorityQueue<>(
                    (n1,n2) -> n1 - n2
            );
        }

        public void addNum(int num) {
            if(0 == maxHeap.size() && 0 == minHeap.size()){
                maxHeap.add(num);
                return;
            }
            if(maxHeap.size() == minHeap.size()){
                if(num <= maxHeap.peek())
                    maxHeap.add(num);
                else minHeap.add(num);
            }else if(maxHeap.size() > minHeap.size()){
                if(num >= maxHeap.peek())
                    minHeap.add(num);
                else{
                    minHeap.add(maxHeap.poll());
                    maxHeap.add(num);
                }
            }else{
                if(num <= minHeap.peek())
                    maxHeap.add(num);
                else{
                    maxHeap.add(minHeap.poll());
                    minHeap.add(num);
                }
            }
        }

        public double findMedian() {
            if(0 == maxHeap.size() && 0 == minHeap.size())
                throw new IllegalArgumentException();
            if(maxHeap.size() == minHeap.size()){
                return (((double)maxHeap.peek()) + minHeap.peek()) / 2;
            }else if(maxHeap.size() > minHeap.size())
                return maxHeap.peek();
            else
                return minHeap.peek();
        }
    }
}
