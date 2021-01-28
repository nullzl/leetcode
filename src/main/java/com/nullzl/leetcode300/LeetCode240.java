package main.java.com.nullzl.leetcode300;

public class LeetCode240 {
    /**
     *
     */
    private int binaryRowSearch(int[][] matrix,int target,int r,int s,int e){
        while(s <= e){
            int mid = (s + e) >> 1;
            if(matrix[r][mid] == target){
                return -2;
            }else if(matrix[r][mid] < target)
                s = mid + 1;
            else
                e = mid - 1;
        }
        return e;
    }

    private int binaryColumnSearch(int[][] matrix,int target,int c,int s,int e){
        while(s <= e){
            int mid = (s + e) >> 1;
            if(matrix[mid][c] == target)
                return -2;
            else if(matrix[mid][c] < target)
                s = mid + 1;
            else
                e = mid -1;
        }
        return e;
    }
    private boolean search(int[][] matrix,int target,
                           int sRow,int eRow,int sColumn,int eColumn){

        if(eRow < sRow || eColumn < sColumn)
            return false;
        int c = binaryRowSearch(matrix,target,sRow,sColumn,eColumn);
        if(-2 == c)
            return true;
        int r = binaryColumnSearch(matrix,target,sColumn,sRow,eRow);
        if(-2 == r)
            return true;
        return search(matrix,target,sRow + 1,r,sColumn + 1,c);
    }
    public boolean searchMatrix1(int[][] matrix, int target) {
        if(null == matrix || 0 == matrix.length || null == matrix[0])
            return false;
        return  search(matrix,target,0,matrix.length-1,0,matrix[0].length-1);
    }

    /**
     * 1. 对于矩阵的左下角，列增加，数值变大，行减小数值变小。
     * 2. 从左下角开始，对于某个nums[i][j]：
     *    如果相等，直接返回
     *    如果nums[i][j]>target,说明目标值一定存在于0到i-1行
     *    如果nums[i][j]<target,说明目标值一定存在于j+1列到最后一列
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if(null == matrix || 0 == matrix.length || null == matrix[0])
            return false;
        int i = matrix.length - 1;
        int j = 0;
        while(i >= 0 && j < matrix[0].length){
            if(matrix[i][j] == target)
                return true;
            if(matrix[i][j] > target)
                i--;
            else if(matrix[i][j] < target)
                j++;
        }
        return false;
    }

    public static void main(String[] args){
        int[][] matrix = new int[][]{
                {1,2,3,4,5,1000,1001},
                {10,20,30,40,50,10000,10010},
                {11,21,31,41,51,10001,10011},
                {12,22,32,42,52,10002,10012},
                {13,23,33,54,57,10003,10013},
                {19,29,39,55,59,10009,10019}
        };
        System.out.println(new LeetCode240().searchMatrix(matrix,54));
    }
}
