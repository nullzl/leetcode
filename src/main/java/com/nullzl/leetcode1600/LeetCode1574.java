package com.nullzl.leetcode1600;

public class LeetCode1574 {

    public int findLengthOfShortestSubarray(int[] arr) {

        int ls = 0;
        int le = 0;
        int rs = arr.length - 1;
        int re = arr.length - 1;

        while(le + 1 < arr.length && arr[le + 1] >= arr[le])
            le++;
        if(arr.length - 1 == le)
            return 0;
        while(rs - 1 >= 0 && arr[rs] >= arr[rs - 1])
            rs--;

        if(arr[rs] >= arr[le])
            return rs - le - 1;

        int s = 0;
        int e = le;
        while(s <= e){
            int mid = s + ((e - s) >> 1);
            if(arr[mid] >= arr[rs])
                e = mid - 1;
            else
                s = mid + 1;
        }
        ls = s;

        s = rs;
        e = re;
        while (s <= e){
            int mid = s + ((e - s) >> 1);
            if(arr[mid] > arr[le])
                e = mid - 1;
            else
                s = mid + 1;
        }
        re = e;

        int j = rs;
        int min = ls == 0 ? rs : Integer.MAX_VALUE;
        for(int i = (ls == 0 ? 0 : ls - 1) ; i <= le ; i++){
            while(j <= re && arr[j] < arr[i]) j++;
            min = Math.min(min,j - i - 1);
        }
        return min;
    }
}
