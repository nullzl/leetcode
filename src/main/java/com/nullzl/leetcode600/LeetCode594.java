package com.nullzl.leetcode600;

import com.nullzl.util.Util;

import java.util.HashMap;
import java.util.Iterator;

public class LeetCode594 {

    public int findLHS(int[] nums) {

        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num,map.getOrDefault(num,0) + 1);
        }
        int max = 0;
        Iterator<Integer> iterator = map.keySet().iterator();
        while(iterator.hasNext()){
            int key = iterator.next();
            int count = map.getOrDefault(key-1,0);
            count = 0 == count ? 0 : count + map.get(key);
            max = Math.max(max,count);
        }
        return max;
    }

    public static void main(String[] args){

        System.out.println(Util.generateRandomArray(10000,0,100000000));
    }

}
