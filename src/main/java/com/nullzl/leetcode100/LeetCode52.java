package main.java.com.nullzl.leetcode100;

public class LeetCode52 {
    private int solve(int n, int rowIndex,int[] rows,int[] columns,int[] line1,int[] line2){
        if(rowIndex == n){
            return 1;
        }
        int i = rowIndex;
        int count = 0;
        for(int j = 0 ; j < n ; j++){
            int index1 = i + j;
            int index2 = (i < j ? n - 1 - i + j : n - 1 + j - i);
            int rowNum = 1 << j;
            int columnNum = 1<<i;
            int line1Num = 1<<index1;
            int line2Num = 1<<index2;
            if(0 == columns[j] && 0 == line1[index1] && 0 == line2[index2]){
                rows[i] = rowNum;
                columns[j] = columnNum;
                line1[index1] = line1Num;
                line2[index2] = line2Num;
                count +=solve(n,rowIndex + 1 ,rows,columns,line1,line2);
                rows[i] = 0;
                columns[j] = 0;
                line1[index1] = 0;
                line2[index2] = 0;
            }
        }
        return count;
    }

    public int totalNQueens(int n)  {
        if(n <= 0)
            return 0;

        int[] rows = new int[n];
        int[] columns = new int[n];
        int[] line1 = new int[2 * n - 1];
        int[] line2 = new int[2 * n - 1];

        return solve(n,0,rows,columns,line1,line2);

    }
}
