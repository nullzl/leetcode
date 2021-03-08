package com.nullzl.interview;

public class LeetCode1001 {

    public void merge(int[] A, int m, int[] B, int n) {

        int k = m + n - 1;
        int i,j;
        for(i = m - 1, j = n - 1 ; i >= 0 && j >= 0;){
            if(A[i] >= B[j]){
                A[k--] = A[i--];
            }else{
                A[k--] = B[j--];
            }
        }
        while(j >= 0)
            A[k--] = B[j--];

    }
}
