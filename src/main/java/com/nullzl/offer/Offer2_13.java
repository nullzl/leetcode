package com.nullzl.offer;

public class Offer2_13 {
    class NumMatrix {

        private int[][] sum ;

        public NumMatrix(int[][] matrix) {
            sum = new int[matrix.length][matrix[0].length];
            for(int i = 0 ; i < matrix.length ; i++){
                for(int j = 0; j < matrix[i].length ; j++){
                    matrix[i][j] = j - 1 >= 0 ? matrix[i][j] + matrix[i][j-1] : matrix[i][j];
                    sum[i][j] += i - 1 >= 0 ? sum[i-1][j] : 0;
                    sum[i][j] += matrix[i][j];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int ans = sum[row2][col2];
            ans -= row1 - 1 >= 0 ? sum[row1 - 1][col2] : 0;
            ans -= col1 - 1 >= 0 ? sum[row2][col1 - 1] : 0;
            ans += row1 - 1 >= 0 && col1 - 1 >= 0 ? sum[row1 - 1][col1 - 1] : 0;
            return ans;
        }
    }
}
