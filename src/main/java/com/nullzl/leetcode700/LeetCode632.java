package com.nullzl.leetcode700;

import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class LeetCode632 {

    public int[] smallestRange(List<List<Integer>> nums) {
        final int[][] ns = new int[nums.size()][];
        int i = 0;
        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;
        for(List<Integer> list : nums){
            ns[i] = new int[list.size()];
            int j = 0;
            Iterator<Integer> iterator = list.iterator();
            while(iterator.hasNext()) {
                ns[i][j++] = iterator.next();
            }
            i++;
        }

        PriorityQueue<int[]> heap = new PriorityQueue<int[]>((op1,op2) ->{
            return Integer.compare(ns[op1[0]][op1[1]], ns [op2[0]][op2[1]]);
        });
        int max = 0;
        for(i = 0 ; i < ns.length; i++){
            heap.offer(new int[]{i,0});
            max = Math.max(ns[i][0],max);
            left = Math.min(left,ns[i][0]);
            right = Math.max(right,ns[i][ns[i].length - 1]);
        }
        while(true){
            int[] pos = heap.poll();
            if(max - ns[pos[0]][pos[1]] < right - left){
                left = ns[pos[0]][pos[1]];
                right = max;
            }
            if(++pos[1] < ns[pos[0]].length){
                heap.offer(pos);
                max = Math.max(max,ns[pos[0]][pos[1]]);
            }else
                break;
        }
        return new int[]{left,right};
    }
}
