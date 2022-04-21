package com.nullzl.interview;

public class Interview1001 {

    public void merge(int[] A, int m, int[] B, int n) {

        if(null == B || 0 == B.length || null == A || 0 == A.length)
            return ;
        int k = A.length - 1;
        int j = m - 1;
        int i = B.length - 1;
        while(i >= 0 && j >= 0 ){
            while(j >= 0 && A[j] > B[i])
                A[k--] = A[j--];
            A[k--] = B[i--];
        }
        while(i >= 0)
            A[k--] = B[i--];

    }
}
