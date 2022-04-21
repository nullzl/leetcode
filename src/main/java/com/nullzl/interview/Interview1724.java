package com.nullzl.interview;

public class Interview1724 {

    public int[] getMaxMatrix1(int[][] matrix) {

        for(int i = 1 ; i < matrix[0].length ; i++){
            matrix[0][i] = matrix[0][i] + matrix[0][i-1];
        }
        for(int i = 1; i < matrix.length ; i++){
            matrix[i][0] = matrix[i][0] + matrix[i-1][0];
        }
        for(int i = 1 ; i < matrix.length ; i++){
            for(int j = 1 ; j < matrix[i].length ; j++){
                matrix[i][j] += (matrix[i-1][j] - matrix[i-1][j-1] + matrix[i][j-1]);
            }
        }
        int max = Integer.MIN_VALUE;
        int[] ans = new int[0];
        for(int i = 0 ; i < matrix.length ; i++){
            for(int j = i  ; j < matrix.length ; j++){
                int min = 0;
                int index = -1;
                for(int k = 0 ; k < matrix[j].length ; k++){
                    int sum = matrix[j][k] - (i == 0 ? 0 : matrix[i-1][k]);
                    int rs = sum - min;
                    if(rs > max) {
                        max = rs;
                        ans = new int[]{i,index + 1,j,k};
                    }
                    if(sum < min) {
                        min = sum;
                        index = k;
                    }
                }
            }
        }
        return ans;
    }

    public int[] getMaxMatrix(int[][] matrix) {
        int maxSum = Integer.MIN_VALUE;
        int[] pos = null;

        for(int i = 0 ; i < matrix.length ; i++){
            for(int j= i ; j < matrix.length ; j++){
                int p = -1;
                int sum = 0;
                if(j != i){
                    for(int k = 0 ; k < matrix[i].length ; k++)
                        matrix[i][k] += matrix[j][k];
                }
                for(int k = 0 ; k < matrix[i].length ; k++){
                    matrix[i][k] += (j == i ? 0 : matrix[j][k]);
                    if(sum > 0){
                        sum += matrix[i][k];
                    }else{
                        p = k;
                        sum = matrix[i][k];
                    }
                    if(sum > maxSum){
                        maxSum = sum;
                        pos = new int[]{i,p,j,k};
                    }

                }
            }
        }
        return pos;
    }
}
