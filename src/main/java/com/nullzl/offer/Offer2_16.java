package com.nullzl.offer;

import java.util.Arrays;

public class Offer2_16 {

    public int lengthOfLongestSubstring(String s) {
        int[] map = new int[256];
        Arrays.fill(map,-1);
        char[] arr = s.toCharArray();
        int k = 0;
        int max = 0;
        for(int i = 0 ; i < arr.length ; i++){
            int idx = (int)arr[i];
            int to = map[idx];
            k = Math.max(k,to + 1);
            map[idx] = i;
            max = Math.max(max,i - k + 1);
        }
        return max;
    }
}
