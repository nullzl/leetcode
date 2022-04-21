package com.nullzl.leetcode600;

import java.net.Socket;
import java.util.HashMap;

public class LeetCode525 {

    public int findMaxLength(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int oneCount = 0;
        int zeroCount = 0;
        int max = 0;
        for(int i = 0 ; i < nums.length; i++){
            oneCount += (nums[i] == 1 ? 1 : 0);
            zeroCount += (nums[i] == 0 ? 1 : 0);
            int delta = oneCount - zeroCount;
            int idx = map.getOrDefault(delta,-2);
            if(-2 == idx)
                map.put(delta,i);
            else
                max = Math.max(max,i - idx);
        }
        Socket s = new Socket();

        return max;
    }
}
