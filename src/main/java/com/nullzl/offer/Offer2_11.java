package com.nullzl.offer;

import java.util.HashMap;
import java.util.Random;

public class Offer2_11 {

    public int findMaxLength(int[] nums) {
        for(int i = 1 ;i < nums.length; i++)
            nums[i] += nums[i-1];
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int ans = 0;
        for(int i = 0 ; i < nums.length ; i++){
            int num = (nums[i] << 1) - i -1;
            Integer idx = map.putIfAbsent(num,i);
            ans = Math.max(ans,i - (null == idx ? i : idx));
        }
        return ans;
    }

    public static void main(String[] args){
        Random r = new Random();
        int len = 10000;
        System.out.print("[" + r.nextInt(2));
        for(int i = 0 ;i < len ; i++){
            System.out.print("," + r.nextInt(2));
        }
        System.out.println("]");
    }
}
