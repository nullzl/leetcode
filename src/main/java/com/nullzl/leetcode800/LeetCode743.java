package com.nullzl.leetcode800;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class LeetCode743 {

    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> edges = new ArrayList<>(n + 1);
        for(int i = 0 ; i <= n ; i++)
            edges.add(new ArrayList<>());
        for(int [] time : times)
            edges.get(time[0]).add(time);
        boolean[] visited = new boolean[n + 1];
        int[] delay = new int[n + 1];
        Arrays.fill(delay,Integer.MAX_VALUE);
        delay[k] = 0;
        int count = 0;
        PriorityQueue<int[]> heap = new PriorityQueue<int[]>((op1, op2) ->{
            return Integer.compare(op1[1],op2[1]);
        });
        heap.add(new int[]{k,0});
        while(!heap.isEmpty() && count < n){
            int[] d = heap.poll();
            if(visited[d[0]])
                continue;
            visited[d[0]] = true;
            count++;
            List<int[]> list = edges.get(d[0]);
            for(int[] time : list){
                if(!visited[time[1]] && d[1] + time[2] < delay[time[1]]){
                    delay[time[1]] = d[1] + time[2];
                    heap.offer(new int[]{time[1],delay[time[1]]});
                }
            }
        }
        delay[0] = Integer.MIN_VALUE;
        int max = Arrays.stream(delay).max().getAsInt();
        return max == Integer.MAX_VALUE ? -1 : max;
    }
}
