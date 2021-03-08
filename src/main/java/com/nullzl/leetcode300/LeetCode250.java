package com.nullzl.leetcode300;

import javafx.util.Pair;

import java.util.HashSet;
import java.util.LinkedList;

public class LeetCode250 {

    public int numIslands(char[][] grid) {

        if(null == grid || 0 == grid.length
                || null == grid[0] || 0 == grid[0].length)
            return 0;

        int count = 0;
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[i].length ; j++){
                if('0' == grid[i][j] || '2' == grid[i][j])
                    continue;
                count++;
                LinkedList<Pair<Integer,Integer>> list = new LinkedList<>();
                list.addLast(new Pair<>(i,j));
                grid[i][j] = '2';
                while(!list.isEmpty()){
                    Pair<Integer,Integer> p = list.pollFirst();
                    int x = p.getKey();
                    int y = p.getValue();
                    if(x + 1 < grid.length && '1' == grid[x+1][y]){
                        grid[x + 1][y] = '2';
                        list.addLast(new Pair<>(x + 1,y));
                    }
                    if(x - 1 >= 0 && '1' == grid[x-1][y]){
                        grid[x - 1][y] = '2';
                        list.addLast(new Pair<>(x - 1,y));
                    }
                    if(y + 1 < grid[i].length && '1' == grid[x][y + 1]){
                        grid[x][y + 1] = '2';
                        list.addLast(new Pair<>(x,y + 1));
                    }
                    if(y - 1 >= 0 && '1' == grid[x][y - 1]){
                        grid[x][y - 1] = '2';
                        list.addLast(new Pair<>(x,y - 1));
                    }
                }


            }
        }
        return count;
    }
}
