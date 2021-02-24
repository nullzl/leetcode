package com.nullzl.leetcode900;

public class LeetCode832 {

    public int[][] flipAndInvertImage(int[][] A) {

        for(int x = 0 ; x < A.length ; x++){
            int i = 0, j = A[x].length - 1;
            while(i < j){
                if(A[x][i] == A[x][j])
                    A[x][i] = A[x][j] = 1 ^ A[x][i];
                i++;
                j--;
            }
            if(i == j)
                A[x][i] = 1 ^ A[x][i];
        }
        return A;
    }


}
