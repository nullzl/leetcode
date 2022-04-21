package com.nullzl.leetcode1000;

import com.nullzl.util.Util;

import java.util.Random;

public class LeetCode992 {

    public int subarraysWithKDistinct(int[] nums, int k) {
        int rs = 0;
        int lastNum = nums.length + 1;
        int[] map = new int[nums.length + 1];
        int count = 0;
        int left1 = 0, left2 = 0;
        for(int right = 0; right < nums.length ; right++){
            if(0 == map[nums[right]] && lastNum != nums[right])
                left1 = left2;
            count += (0 == map[nums[right]]++ ? 1 : 0);
            while(count >= k){
                lastNum = nums[left2++];
                count += (0 == --map[lastNum] ? -1 : 0);
            }
            rs += (left2 - left1);
        }
        return rs;
    }

    public static void main(String[] args){
        Random r= new Random();
        int len = r.nextInt(10000) + 10000;
        int k = r.nextInt(len) + 1;
        int[] arr = new int[len];
        System.out.println(Util.generateRandomArray(len,1,len));
        System.out.println(k);
    }
}
