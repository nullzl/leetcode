package com.nullzl.leetcode1700;

import java.util.PriorityQueue;

public class LeetCode1642 {

    public int furthestBuilding(int[] heights, int bricks, int ladders) {

        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int i ;
        for(i = 1; i < heights.length ; i++){
            int need = heights[i] - heights[i-1];
            if(need <= 0)
                continue;
            if(heap.size() <ladders){
                heap.offer(need);
                bricks += need;
            }else if(!heap.isEmpty() && need > heap.peek()){
                int tmp = heap.poll();
                heap.offer(need);
                bricks += (need - tmp);
            }
            bricks -= need;
            if(bricks < 0)
                break;
        }
        return i - 1;
    }
}
