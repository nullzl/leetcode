package com.nullzl.offer;

import com.nullzl.util.Util;

import java.util.HashMap;

public class Offer2_119 {

    public int longestConsecutive(int[] nums) {
        if(null == nums || 0 == nums.length)
            return 0;

        HashMap<Integer,Boolean> map = new HashMap<>();
        for(int n : nums)
            map.put(n,false);
        int max = 0;
        for(int n : nums){
            if(map.get(n))
                continue;
            int s = n - 1 , e = n + 1;
            map.put(n,true);
            while(null != map.get(s)){
                map.put(s--,true);
            }
            while(null != map.get(e)){
                map.put(e++,true);
            }
            max = Math.max(max,e - s - 1);
        }
        return max;
    }

    public static void main(String[] args){
        System.out.println(Util.generateRandomArray(10000,-1000,1000));
    }

}
