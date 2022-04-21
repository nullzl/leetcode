package com.nullzl.leetcode500;

import java.util.HashSet;

public class LeetCode421 {

    public int findMaximumXOR(int[] nums) {

        int ans = 0;
        int[] prefix = new int[nums.length];
        for(int i = 0 ;i <= 30 ; i++){
            HashSet<Integer> set = new HashSet<>();
            int j = 0;
            for(int num : nums){
                prefix[j] = num >>> (30 - i);
                set.add(prefix[j++]);
            }

            ans <<= 1;
            int tmp = ans + 1;
            for(j = 0; j < prefix.length ; j++){
                if(set.contains(tmp ^ prefix[j])){
                    ans = tmp;
                    break;
                }
            }
        }
        return ans;
    }
}
