package com.nullzl.leetcode100;

public class LeetCode74 {

    public boolean find(int[][] matrix,int target,int rows,int columns,int start,int end){
        if(start > end)
            return false;
        int mid = (start + end) >> 1;
        int midVal = matrix[mid / columns][mid % columns];
        if(target == midVal)
            return true;
        if(midVal > target)
            return find(matrix,target,rows,columns,start,mid - 1);
        return find(matrix,target,rows,columns,mid+1,end);
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if(null == matrix || 0 == matrix.length || null == matrix[0] || 0 == matrix[0].length)
            return false;

        int rows = matrix.length ;
        int columns = matrix[0].length;
        return  find(matrix,target,rows,columns,0,rows*columns - 1);
    }
}
