package com.nullzl.leetcode1000;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class LeetCode994 {

    public int orangesRotting(int[][] grid) {

        if(null == grid || 0 == grid.length
                || null == grid[0] || 0 == grid[0].length)
            return 0;

        int columns = grid[0].length;
        int sum = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < columns ; j++){
                if(2 == grid[i][j]) {
                    set.add(i * columns + j);
                }else if(1 == grid[i][j])
                    sum++;
            }
        }

        int count = 0;
        while(!set.isEmpty() && 0 != sum){
            HashSet<Integer> tempSet = new HashSet<>();
            Iterator<Integer> iterator = set.iterator();
            while(iterator.hasNext()){
                int num = iterator.next();
                int i = num / columns;
                int j = num % columns;
                if(i - 1 >= 0 && 1 == grid[i-1][j]){
                    grid[i-1][j] = 2;
                    tempSet.add((i-1) * columns + j);
                    sum--;
                }
                if(i + 1 < grid.length && 1 == grid[i + 1][j]){
                    grid[i+1][j] = 2;
                    tempSet.add((i + 1) * columns + j);
                    sum--;
                }
                if(j - 1 >= 0 && 1 == grid[i][j-1]){
                    grid[i][j-1] = 2;
                    tempSet.add((i * columns) + j - 1);
                    sum--;
                }
                if(j + 1 < columns && 1 == grid[i][j+1]){
                    grid[i][j+1] = 2;
                    tempSet.add((i * columns) + j + 1);
                    sum--;
                }
            }
            set = tempSet;
            count++;
        }
        if(0 == sum)
            return count;
        return -1;

    }

    public static void main(String[] args){
        System.out.println(new LeetCode994().orangesRotting(
                new int[][]{
                        {2,1,1},{1,1,0},{0,1,1}
                }
        ));
    }
}
