package main.java.com.nullzl.leetcode800;

public class LeetCode766 {

    public boolean isToeplitzMatrix(int[][] matrix) {
        if(1 == matrix.length || 1 == matrix[0].length)
            return true;

        for(int i = 1 ; i < matrix.length ; i++){
            for(int j = 1 ; j < matrix[i].length ; j++){
                if(matrix[i][j] != matrix[i-1][j-1])
                    return false;
            }
        }
        return true;
    }
}
