package com.nullzl.leetcode100;

public class LeetCode48 {

    public void rotate(int[][] matrix) {
        if(null == matrix)
            return ;

        int len = (matrix.length >> 1);
        for(int k = 0 ; k <= len ; k++ ){
            int i = k;
            int j = matrix.length - 1 - i;

            for(int t = 0 ; i + t < j ; t++){
                int temp = matrix[i][i+t];
                matrix[i][i+t] = matrix[j-t][i];
                matrix[j-t][i] = matrix[j][j-t];
                matrix[j][j-t] = matrix[i+t][j];
                matrix[i+t][j] = temp;

            }
        }
    }
}
