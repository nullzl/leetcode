package com.nullzl.offer;

public class Offer04 {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {

        if(null == matrix)
            return false;

        for(int i = matrix.length - 1,j = 0 ; i >= 0 && j < matrix[0].length ; ){
            if(matrix[i][j] < target)
                j++;
            else if(matrix[i][j] > target)
                i--;
            else
                return true;
        }
        return false;
    }
}
