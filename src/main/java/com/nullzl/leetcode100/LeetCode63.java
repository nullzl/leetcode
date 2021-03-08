package com.nullzl.leetcode100;

public class LeetCode63 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(null == obstacleGrid || 0 == obstacleGrid.length || 0 == obstacleGrid[0].length)
            return 0 ;

        int[][] steps = new int[obstacleGrid.length][obstacleGrid[0].length];
        steps[0][0] = (obstacleGrid[0][0] == 0 ? 1 : 0);
        for(int i = 1 ; i < obstacleGrid[0].length ; i++)
            steps[0][i] = (obstacleGrid[0][i] == 0 ? steps[0][i-1] : 0);
        for(int i = 1 ; i < obstacleGrid.length ; i++)
            steps[i][0] = (obstacleGrid[i][0] == 0 ? steps[i-1][0] : 0);

        for(int i = 1 ; i < obstacleGrid.length ; i++){
            for(int j = 1 ; j < obstacleGrid[0].length ; j++)
                steps[i][j] = (0 == obstacleGrid[i][j] ? steps[i-1][j] + steps[i][j-1] : 0);
        }
        return steps[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }
}
