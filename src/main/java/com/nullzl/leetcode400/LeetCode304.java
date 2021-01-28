package com.nullzl.leetcode400;

public class LeetCode304 {

    int[][] mx;

    public LeetCode304(int[][] matrix) {
        if(null == matrix || 0 == matrix.length
                || null == matrix[0] || 0 == matrix[0].length)
            mx = null;
        else{
            mx = new int[matrix.length + 1][matrix[0].length + 1];
            for(int i = 1 ; i <= matrix.length ; i++){
                for(int j = 1 ; j <= matrix[0].length ; j++){
                    mx[i][j] = mx[i][j-1] + matrix[i-1][j-1] + mx[i-1][j] - mx[i-1][j-1];
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {

        return mx[row2+1][col2+1] - mx[row1][col2+1] - mx[row2+1][col1] + mx[row1][col1];
    }
}
