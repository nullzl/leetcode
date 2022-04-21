package com.nullzl.leetcode500;

public class LeetCode498 {

    public int[] findDiagonalOrder(int[][] mat) {
        if(null == mat || 0 == mat.length || null == mat[0] || 0 == mat[0].length)
            return new int[0];
        int m = mat.length, n = mat[0].length;
        int[] ans = new int[m * n];
        int size = 0;
        int len =m + n - 2;
        for(int i = 0 ; i <= len ; i++){
            if(0 == (1 & i)){
                for(int j = Math.min(i,m-1); j >= 0 && i - j < n ; j--)
                    ans[size++] = mat[j][i-j];
            }else{
                for(int j = Math.max(i - n + 1 ,0) ; j < m && i - j >= 0 ; j++ )
                    ans[size++] = mat[j][i - j];
            }
        }
        return ans;
    }

    public static void main(String[] args){
        System.out.println(-9 % 2);
    }
}
