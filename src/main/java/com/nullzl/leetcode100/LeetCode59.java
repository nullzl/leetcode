package com.nullzl.leetcode100;

public class LeetCode59 {

    public int[][] generateMatrix(int n) {
        if(n <= 0){
            return new int[0][0];
        }

        int[][] rs = new int[n][n];
        int i = 0,j = n - 1;
        int max = (n - 1) >> 1;
        int num = 1;
        for(;i<=max;i++,j--){
            if(i == j){
                rs[i][j] = num++;
            }else{
                for(int x = i ; x < j ; x++){
                    rs[i][x] = num++;
                }
                for(int x = i ; x < j ; x++){
                    rs[x][j] = num++;
                }
                for(int x = j ; x > i ; x--){
                    rs[j][x] = num++;
                }
                for(int x = j ; x > i ; x--){
                    rs[x][i] = num++;
                }
            }
        }
        return rs;
    }
}
