package com.nullzl.offer;

public class Offer49 {

    public int nthUglyNumber(int n) {
        if(n < 1)
            throw new IllegalArgumentException();
        int arr[] = new int[n];
        arr[0] = 1;

        int[] p = new int[]{0,0,0};
        long[] m = new long[]{2,3,5};
        int[] s = new int[]{2,3,5};

        for(int i = 1 ; i < n ; ){
            int min = 0;
            for(int j = 1; j < 3 ; j++)
                min = m[j] < m[min] ? j : min;
            if(m[min] != arr[i-1]){
                arr[i++] = (int)m[min];
            }
            p[min]++;
            m[min] = arr[p[min]] * (long)s[min];
        }
        return arr[n - 1];
    }
}
