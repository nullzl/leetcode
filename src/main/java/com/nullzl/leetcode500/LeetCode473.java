package com.nullzl.leetcode500;

import com.nullzl.util.Util;

import java.util.Arrays;

public class LeetCode473 {

    private boolean dfs(int[] cache,int[] nums,int target,int set,int sum){
        if(target * 4 == sum)
            return true;
        if(-1 == cache[set])
            return false;
        int left = target - sum % target;
        boolean ans = false;
        for(int i = 0 ; !ans && i < nums.length ; i++){
            if(0 != ((1 << i) & set) || nums[i] > left)
                continue;
            ans = ans || dfs(cache,nums,target,set | (1 << i),sum + nums[i]);
        }
        cache[set] = ans ? 1 : -1;
        return ans;
    }

    public boolean makesquare(int[] matchsticks) {

        int sum = Arrays.stream(matchsticks).sum();
        if(matchsticks.length < 4 || 0 != sum % 4)
            return false;
        int target = sum / 4;
        int[] cache = new int[1 << matchsticks.length];
        return dfs(cache,matchsticks,target,0,0);
    }

    public static void main(String[] args){
        System.out.println(Util.generateRandomArray(15,1,10));
    }
}
