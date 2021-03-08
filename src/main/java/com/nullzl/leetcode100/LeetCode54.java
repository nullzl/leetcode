package com.nullzl.leetcode100;

import java.util.ArrayList;
import java.util.List;

public class LeetCode54 {

    public List<Integer> spiralOrder(int[][] matrix) {

        if(0 == matrix.length || 0 == matrix[0].length)
            return new ArrayList<Integer>();

        int m = matrix.length - 1;
        int n = matrix[0].length - 1;
        List<Integer> list = new ArrayList<Integer>((m+1)*(n+1));
        int rowMaxIndex = m >>1;
        int columnmaxIndex = n >> 1;
        for(int i = 0 , j = 0 ; i <= rowMaxIndex && j <= columnmaxIndex ; i++,j++,m--,n--){
            if(i == m){
                for(int x = j ; x <= n ; x++)
                    list.add(matrix[i][x]);
            }else if(j == n){
                for(int x = i ; x <= m ; x++)
                    list.add(matrix[x][j]);
            }else{
                for(int x = j ; x < n ; x++){
                    list.add(matrix[i][x]);
                }
                for(int x = i; x < m ; x++){
                    list.add(matrix[x][n]);
                }
                for(int x = n ; x > j ; x--){
                    list.add(matrix[m][x]);
                }
                for(int x = m ; x > i ; x--){
                    list.add(matrix[x][j]);
                }
            }
        }
        return list;
    }
    public static void main(String[] args){
        int[][] nums = {
                {3},
                {2}
        };
        new LeetCode54().spiralOrder(nums);
    }
}
