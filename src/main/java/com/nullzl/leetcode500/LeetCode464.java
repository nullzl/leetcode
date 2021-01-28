package com.nullzl.leetcode500;

import java.util.Arrays;

public class LeetCode464 {




    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if(desiredTotal == 0)
            return true;

        if(0 == maxChoosableInteger )
            return false;

        int sum = ((1 + maxChoosableInteger) * maxChoosableInteger) / 2;

        if( sum < desiredTotal)
            return false;


        int len = 1 << maxChoosableInteger;
        boolean[] dp0 = new boolean[len];
        boolean[] dp1 = new boolean[len];
        int[] nums = new int[len];
        Arrays.fill(nums,Integer.MIN_VALUE);
        nums[0] = desiredTotal - sum;
        Arrays.fill(dp1,true);

        int i,j,k;
        for(i = 0 ; i < len ; i++){
            for(k = 1 , j = 1 ; k <= maxChoosableInteger ; j <<= 1 , k++){
                if(0 != (j & i))
                    continue;
                int idx = i | j;
                int left = nums[i] + k;
                if(nums[idx] == Integer.MIN_VALUE)
                    nums[idx] = left;
                if(left > 0){
                    dp1[idx] = dp0[i] && dp1[idx];
                    dp0[idx] = dp1[i] || dp0[idx];

                    if(idx == len - 1 && dp0[idx])
                        return dp0[idx];
                }
            }
        }
        return dp0[len - 1];
    }
}
