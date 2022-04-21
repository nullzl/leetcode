package com.nullzl.interview;

import com.nullzl.util.Util;

import java.util.Arrays;

public class Interview1606 {




    public int smallestDifference(int[] a, int[] b) {
        if(a.length < b.length)
            return smallestDifference(b,a);
        long min = Long.MAX_VALUE;
        Arrays.sort(a);
        Arrays.sort(b);
        int s = 0;
        for(int i = 0 ; i < b.length ; ){
            int m = Arrays.binarySearch(a,s,a.length,b[i]);
            if(m >= 0){
                min = 0;
                break;
            }
            m = -m - 1;
            if(m > 0){
                min = Math.min(min,(long)b[i] - a[m-1]);
            }
            if(m == a.length){
                break;
            }
            int n = Arrays.binarySearch(b,i,b.length,a[m]);
            if(n >= 0){
                min = 0;
                break;
            }
            n = -n -1;
            min = Math.min(min,a[m] - (long)b[n-1]);
            i = n;
        }
        return (int)min;
    }

    public static void main(String[] args){
        System.out.println(Util.generateRandomArray(10000,-2147483648,2147483647));
        System.out.println(Util.generateRandomArray(1000,-2147483648,2147483647));
    }
}
