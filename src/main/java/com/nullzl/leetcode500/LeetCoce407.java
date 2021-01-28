package com.nullzl.leetcode500;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.PriorityQueue;

public class LeetCoce407 {
    class Position{
        int x;
        int y;
        int height;
        private Position(int a,int b,int c){
            x = a;
            y = b;
            height = c;
        }
    }

    public int trapRainWater(int[][] heightMap) {

        if(null == heightMap ||  heightMap.length <= 1
        || null == heightMap[0] || heightMap[0].length <= 1)
            return 0;

        PriorityQueue<Position> queue = new PriorityQueue<>(
                (p1,p2) ->{
                    return p1.height - p2.height;
                }
        );
        int m = heightMap[0].length - 1;
        int n = heightMap.length - 1;
        boolean[][] flag = new boolean[heightMap.length][heightMap[0].length];
        for(int i = 0 ; i < heightMap[0].length ; i++){
            queue.add(new Position(0,i,heightMap[0][i]));
            queue.add(new Position(n,i,heightMap[n][i]));
        }
        for(int i = 1 ; i < heightMap.length - 1 ; i++){
            queue.add(new Position(i,0,heightMap[i][0]));
            queue.add(new Position(i,m,heightMap[i][m]));
        }
        int[][] delta = new int[][]{
                {-1,0}, {0,-1}, {0,1},{1,0}
        };
        Position p;
        int x,y;
        int sum = 0 ;
        while(!queue.isEmpty()){
            p = queue.poll();
            for(int i = 0 ; i < delta.length ; i++){
                x = p.x + delta[i][0];
                y = p.y + delta[i][1];
                if(x > 0 && x < n && y > 0 && y < m && !flag[x][y]){
                    sum += (heightMap[x][y] < p.height ? p.height - heightMap[x][y] : 0);
                    flag[x][y] = true;
                    queue.add(new Position(x,y,Math.max(p.height,heightMap[x][y])));
                }
            }
        }
        return sum;
    }

    public static void main(String[] args){
        System.out.println(new LeetCoce407().trapRainWater(
                new int[][]{
                        {1,4,3,1,3,2},{3,2,1,3,2,4},{2,3,3,2,3,1}
                }
        ));
    }
}
