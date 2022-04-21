package com.nullzl.interview;

public class Interview1009 {

    public boolean searchMatrix(int[][] matrix, int target) {
        if(null == matrix || 0 == matrix.length || null == matrix[0])
            return false;

        int i = matrix.length - 1;
        int j= 0;
        while(i >= 0 && j < matrix[0].length){
            if(target == matrix[i][j])
                return true;
            if(matrix[i][j] < target)
                j++;
            else
                i--;
        }
        return false;
    }
}
