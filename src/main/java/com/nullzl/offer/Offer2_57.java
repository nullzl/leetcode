package com.nullzl.offer;

import java.util.HashMap;

public class Offer2_57 {

    private boolean check(HashMap<Long,Integer> map,long key,int val,int t){
        Integer num = map.get(key);
        return null != num && Math.abs((long)val -  (long)num) <= (long)t;
    }

    private long getKey(long num , long t){
        long key = Math.abs(num) / (t + 1);
        if(num < 0)
            key = -key - 1;
        return key;
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        if(null == nums || 0 == nums.length || 0 == k)
            return false;

        HashMap<Long,Integer> map = new HashMap<>();
        for(int i = 0 ; i < nums.length ; i++){
            if(i - k - 1 >= 0){
                map.remove(getKey(nums[i-k-1],t));
            }
            long key = getKey(nums[i],t);
            if(map.containsKey(key))
                return true;
            map.put(key,nums[i]);
            if(check(map,key - 1,nums[i],t) || check(map,key + 1,nums[i],t))
                return true;
        }
        return false;
    }
}
