package main.java.com.nullzl.leetcode100;

import java.util.ArrayList;
import java.util.List;

public class LeetCode51 {

    private void solve(List<List<String>> rs,int n, int rowIndex,int[] rows,int[] columns,int[] line1,int[] line2,String rsStr){
        if(rowIndex == n){
            List<String> list = new ArrayList<String>(n);
            for(int k = 0 ;k < n ; k++){
                StringBuilder str = new StringBuilder(rsStr);
                for(int x = 1,t = 0; t < n ; t++,x=x<<1){
                    if(0 != (rows[k] & x)){
                        str.setCharAt(t,'Q');
                        break;
                    }
                }
                list.add(str.toString());
            }
            rs.add(list);
            return ;
        }
        int i = rowIndex;
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
                solve(rs,n,rowIndex + 1 ,rows,columns,line1,line2,rsStr);
                rows[i] = 0;
                columns[j] = 0;
                line1[index1] = 0;
                line2[index2] = 0;
            }
        }
    }



    public List<List<String>> solveNQueens(int n) {
        List<List<String>> rs = new ArrayList<List<String>>(n);
        if(n <= 0)
            return rs;
        int[] rows = new int[n];
        int[] columns = new int[n];
        int[] line1 = new int[2 * n - 1];
        int[] line2 = new int[2 * n - 1];

        StringBuilder str = new StringBuilder(n);
        for(int i = 0 ; i < n ; i++){
            str.append('.');
        }
        String rsStr = str.toString();

        solve(rs,n,0,rows,columns,line1,line2,rsStr);
        return rs;

    }

    public static void main(String[] args){
        System.out.println(new LeetCode51().solveNQueens(4).size());
    }
}
