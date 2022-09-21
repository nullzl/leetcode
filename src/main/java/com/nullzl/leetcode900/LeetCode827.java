package com.nullzl.leetcode900;

import java.util.Random;

public class LeetCode827 {

    private int visit(int[][] grid,int i , int j,int k){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || 1 != grid[i][j])
            return 0;
        grid[i][j] = k;
        return 1 + visit(grid,i + 1,j,k) +
                visit(grid,i-1,j,k) +
                visit(grid,i,j+1,k) +
                visit(grid,i,j-1,k);
    }


    public int largestIsland(int[][] grid) {
        int[] area = new int[grid.length * grid[0].length + 2];
        int size = 2;
        int max = 0;
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                if(1 == grid[i][j]){
                    area[size] = visit(grid,i,j,size);
                    max = Math.max(area[size],max);
                    size++;
                }
            }
        }
        int[] nums = new int[4];

        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[i].length ; j++){
                if(0 == grid[i][j]){
                    int sum = 1;
                    nums[0] = i - 1 >= 0 ? grid[i-1][j] : 0;
                    nums[1] = i + 1 < grid.length ? grid[i+1][j] : 0;
                    nums[2] = j - 1 >= 0 ? grid[i][j-1] : 0;
                    nums[3] = j + 1 < grid[0].length ? grid[i][j+1]:0;
                    sum += area[nums[0]];
                    sum += nums[1] != nums[0] ? area[nums[1]] : 0;
                    sum += nums[2] != nums[0] && nums[2] != nums[1] ? area[nums[2]] : 0;
                    sum += nums[3] != nums[0] && nums[3] != nums[1] && nums[3] != nums[2] ? area[nums[3]] : 0;
                    max = Math.max(sum,max);

                }
            }
        }
        return max;
    }
    public static void main(String[] args){
        Random r = new Random();
        System.out.print("[" );
        for(int i = 0 ; i < 500 ; i++){
            System.out.print("[" + r.nextInt(2));
            for(int j = 0 ; j < 499; j++){
                System.out.print("," + r.nextInt(2));
            }
            System.out.print("]," );
        }
        System.out.print("]" );
    }
}
