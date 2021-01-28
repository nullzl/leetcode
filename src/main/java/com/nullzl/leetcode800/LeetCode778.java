package com.nullzl.leetcode800;

import java.util.Arrays;
import java.util.PriorityQueue;

public class LeetCode778 {

    class Pair{
        public int x;
        public int y;
        public Pair(int a,int b){
            x = a;
            y = b;
        }
    }

    private void update(PriorityQueue<Pair> heap,int[][] dp,int[][] grid,int x,int y,int t){
        if(x < 0 || x >= dp.length || y < 0 || y >= dp[0].length || -1 != dp[x][y])
            return ;
        dp[x][y] = Math.max(t,grid[x][y]);
        heap.add(new Pair(x,y));
    }

    public int swimInWater(int[][] grid) {

        if(null == grid || 0 == grid.length)
            throw new IllegalArgumentException();

        int[][] dp = new int[grid.length][grid[0].length];
        Arrays.stream(dp).forEach(arr -> Arrays.fill(arr,-1));
        PriorityQueue<Pair> queue = new PriorityQueue<Pair>((p1,p2) ->{
            return dp[p1.x][p1.y] - dp[p2.x][p2.y];
        });
        dp[0][0] = grid[0][0];
        queue.add(new Pair(0,0));

        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            update(queue,dp,grid,p.x-1,p.y,dp[p.x][p.y]);
            update(queue,dp,grid,p.x+1,p.y,dp[p.x][p.y]);
            update(queue,dp,grid,p.x,p.y-1,dp[p.x][p.y]);
            update(queue,dp,grid,p.x,p.y+1,dp[p.x][p.y]);
            if(dp[dp.length - 1][dp[0].length - 1] != -1)
                break;
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}
