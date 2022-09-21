package com.nullzl.leetcode500;

public class LeetCode414 {

    public int thirdMax(int[] nums){
        int[] ans = new int[3];
        int i = 0 , j = 0;
        for(; i < nums.length; i++){
            int k = j - 1;
            while(k >= 0 && ans[k] < nums[i])k--;
            if((k >= 0 && nums[i] == ans[k]) || 2 == k)
                continue;
            for(int x = 3 == j ? 1 : j - 1 ; x > k ; x--)
                ans[x + 1] = ans[x];
            ans[k + 1] = nums[i];
            j = j < 3 ? j + 1 : j;
        }
        return j < 3 ? ans[0] : ans[2];
    }
}
