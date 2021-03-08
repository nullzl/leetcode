package com.nullzl.leetcode300;

import java.util.HashMap;

public class LeetCode279 {

    private int sum(int n, HashMap<Integer,Integer> map){
        if(0 == n) {
            return 0;
        }
        int val = map.getOrDefault(n,0);
        if(0 != map.getOrDefault(n,0))
            return val ;
        int max = (int)Math.sqrt(n);
        int minCount = Integer.MAX_VALUE;
        for(int i = max; i >= 1 ; i--){
            int temp = sum(n - i * i ,map);
            if(temp < minCount)
                minCount = temp;
        }
        map.put(n,minCount+1);
        return minCount + 1;
    }

    public int numSquares(int n) {
        HashMap<Integer,Integer> map = new HashMap<>();
        return sum(n,map);
    }

    public static void main(String[] args){
        System.out.print(new LeetCode279().numSquares(7));
    }
}
