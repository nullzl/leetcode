package com.nullzl.offer;

import java.util.HashMap;

public class Offer2_10 {

    public int subarraySum(int[] nums, int k) {
        for(int i = 1; i < nums.length ; i++)
            nums[i] += nums[i-1];
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int ans = 0;
        for(int i = 0 ; i < nums.length ; i++){
            ans += map.getOrDefault(nums[i] - k , 0);
            map.put(nums[i],map.getOrDefault(nums[i],0) + 1);
        }
        return ans;
    }
}
