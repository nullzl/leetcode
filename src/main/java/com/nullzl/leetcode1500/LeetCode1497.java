package com.nullzl.leetcode1500;

public class LeetCode1497 {

    public boolean canArrange(int[] arr, int k) {
        int[] map = new int[k];
        for(int n : arr){
            int idx = n % k;
            idx = idx < 0 ? k + idx : idx;
            map[idx]++;
        }
        if(0 != (1 & map[0]))
            return false;
        int i ,j;
        for(i = 1 , j = arr.length - 1 ;i < j ; i++,j--){
            if(map[i] != map[j])
                return false;
        }
        return i != j || 1 != (map[i] & 1);
    }
}
