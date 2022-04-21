package com.nullzl.interview;

public class Interview0107 {

    public void rotate(int[][] matrix) {
        int i = 0 , j = matrix.length -1;
        while(i < j){
            for(int k = 0 ; k < j - i ; k++){
                int num  = matrix[i][i + k];
                matrix[i][i + k] = matrix[j-k][i];
                matrix[j - k][i] = matrix[j][j- k];
                matrix[j][j-k] = matrix[i + k][j];
                matrix[i + k][j] = num;
            }

            i++;j--;
        }
    }
}
