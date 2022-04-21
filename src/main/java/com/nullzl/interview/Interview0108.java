package com.nullzl.interview;

public class Interview0108 {

    public void setZeroes(int[][] matrix) {

        if(null == matrix || null == matrix[0])
            return ;

        boolean[] rows = new boolean[matrix.length];
        boolean[] columns = new boolean[matrix[0].length];
        for(int i = 0 ; i < matrix.length ; i++){
            for(int j = 0 ; j < matrix[i].length ; j++){
                if(0 == matrix[i][j]){
                    rows[i] = true;
                    columns[j] = true;
                }
            }
        }
        for(int i = 0 ; i < matrix.length ; i++){
            for(int j = 0 ; j < matrix[i].length ; j++){
                if(rows[i] || columns[j]){
                    matrix[i][j] = 0;
                }
            }
        }

    }
}
