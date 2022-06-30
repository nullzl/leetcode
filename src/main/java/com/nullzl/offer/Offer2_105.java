package com.nullzl.offer;

import java.util.Random;

public class Offer2_105 {

    private int visit(int[][] grid,boolean[][] visited,int i , int j){
        if(i < 0 || i >= grid.length || j < 0 || j>= grid[i].length)
            return 0;
        if(visited[i][j] || 0 == grid[i][j])
            return 0;

        visited[i][j] = true;
        return 1 + visit(grid,visited,i + 1, j)
                + visit(grid,visited,i - 1 , j)
                + visit(grid,visited,i,j + 1)
                + visit(grid,visited,i,j-1);

    }


    public int maxAreaOfIsland(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int max = 0;
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[i].length ; j++){
                if(0 == grid[i][j] || visited[i][j])
                    continue;
                max = Math.max(max,visit(grid,visited,i,j));
            }
        }
        return max;
    }

    public static void main(String[] args){
        Random r = new Random();
        int len1 = r.nextInt(20) + 20;
        int len2 = r.nextInt(20) + 20;
        System.out.print("[");
        for(int i = 0 ; i < len1 ; i++){
            System.out.print("[");
            System.out.print(r.nextInt(2));
            for(int j = 1 ; j < len2 ; j++){
                System.out.print("," + r.nextInt(2));
            }
            System.out.print("],");
        }
        System.out.print("]");
    }


}
