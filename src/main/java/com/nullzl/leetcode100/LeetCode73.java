package main.java.com.nullzl.leetcode100;

public class LeetCode73 {

    public void setZeroes(int[][] matrix) {

        if(null == matrix || 0 == matrix.length || null == matrix[0] || 0 == matrix[0].length)
            return ;

        boolean lastRow = false;
        boolean curRow = false;
        int rows = matrix.length - 1;
        for(int i = 0 ; i < matrix[0].length ; i++){
            if(0 == matrix[rows][i]){
                lastRow = true;
                break;
            }
        }
        for(int i = 0 ; i < rows ; i++,curRow=false){
            for(int j = 0 ; j < matrix[0].length ; j++){
                if(0 == matrix[i][j]){
                    curRow = true;
                    for(int k = i - 1; k >= 0  ; k--)
                        matrix[k][j] = 0;
                    for(int k = j -1 ; k >= 0  ; k--)
                        matrix[i][k] = 0;
                    matrix[rows][j] = 0;
                }else{
                    if(curRow)
                        matrix[i][j] = 0;
                }
            }
        }
        for(int i = 0 ; i < matrix[0].length ; i++){
            if(0 == matrix[rows][i]){
                for(int k = rows - 1; k >= 0  ; k--)
                    matrix[k][i] = 0;
            }else{
                if(lastRow)
                    matrix[rows][i] = 0;
            }
        }

    }
    public static void main(String[] args){
        int[][] nums = {{0,0,0,5},{4,3,1,4},{0,1,1,4},{1,2,1,3},{0,0,1,1}};
        new LeetCode73().setZeroes(nums);
    }
}
