package com.nullzl.leetcode200;

import java.util.HashMap;

public class LeetCode169 {

    public int majorityElement1(int[] nums) {

        HashMap<Integer,Integer> map = new HashMap<>(nums.length);
        int min = nums.length / 2;
        for(int i = 0 ; i < nums.length ; i++){
            int count = map.getOrDefault(nums[i],0);
            count++;
            if(count > min)
                return nums[i];
            map.put(nums[i],count);
        }
        return -1;

    }


    private void swap(int[] nums,int m,int n){
        if(m != n){
            nums[m] = nums[m] ^ nums[n];
            nums[n] = nums[m] ^ nums[n];
            nums[m] = nums[m] ^ nums[n];
        }
    }
    private int partition(int[] nums,int s,int e,int min){
        int num = nums[e];
        int count = 1;
        if(count > min)
            return num;
        int index = s - 1;
        for(int i = s ; i < e ; i++){
            if(nums[i] <= num){
                if(nums[i] == num && ++count > min) {
                    return nums[i];
                }
                swap(nums,++index,i);
            }
        }
        swap(nums,++index,e);
        if(index - s > min){
            return partition(nums,s,index - 1,min);
        }else{
            return partition(nums,index + 1,e,min);
        }

    }


    public int majorityElement2(int[] nums) {
        int min = nums.length / 2;
        int s = 0 ;
        int e = nums.length - 1;
        return partition(nums,s,e,min);
    }


    // 众数
    public int majorityElement(int[] nums) {
        int count = 1;
        int candidate = nums[0];
        for(int i = 1 ;i < nums.length ; i++){
            if(0 == count){
                candidate = nums[i];
                count = 1;
            }else{
                if(candidate == nums[i])
                    count++;
                else
                    count--;
            }
        }
        return candidate;
    }

    public static void main(String[] args){
        int[] nums = {6,5,5};
        System.out.println(new LeetCode169().majorityElement(nums));
    }
}
