package com.nullzl.leetcode1000;

import java.util.PriorityQueue;

public class LeetCode973 {

    public int[][] kClosest(int[][] points, int K) {

        if(K == points.length)
            return points;

        int[] distances = new int[points.length];
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>((o1,o2) ->{
            return distances[o1] - distances[o2];
        });
        int[][] rs = new int[K][];

        for(int i = 0 ; i < points.length; i++){
            distances[i] = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            heap.add(i);
        }

        for(int i = 0 ; i < K ; i++){
            rs[i] = points[heap.poll()];
        }

        return rs;
    }
}
