package com.nullzl.interview;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Interview0802 {

    List<List<Integer>> pt;

    public boolean dfs(List<List<Integer>> path,boolean[][] rs,int[][] grid,int i,int j){

        if(i >= grid.length || j >= grid[0].length)
            return false;
        if(1==grid[i][j] || rs[i][j])
            return false;
        List<Integer> item = new ArrayList<Integer>(2);
        item.add(i);
        item.add(j);
        if(i == grid.length - 1 && j == grid[0].length - 1){
            pt = new ArrayList<>(path.size() + 1);
            pt.addAll(path);
            pt.add(item);
            return true;
        }
        rs[i][j] = true;
        path.add(item);
        boolean find = dfs(path,rs,grid,i+1,j) || dfs(path,rs,grid,i,j+1);
        path.remove(path.size() - 1);
        return find;
    }

    public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
        if(null == obstacleGrid || 0 == obstacleGrid.length || null == obstacleGrid[0]
        || 0 == obstacleGrid[0].length || 1 == obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1] )
            return new ArrayList<>();

        List<List<Integer>> list = new LinkedList<>();
        boolean[][] rs = new boolean[obstacleGrid.length][obstacleGrid[0].length];
        return dfs(list,rs,obstacleGrid,0,0) ? pt : new ArrayList<>(0);


    }

}
