package com.nullzl.leetcode200;

import java.util.HashMap;

public class LeetCode167 {

    private int search(int[] nums,int s,int e,int target){
        if(s > e)
            return -1;
        int mid = (s + e) >> 1;
        if(nums[mid] == target)
            return mid;
        if(nums[mid] > target){
            return search(nums,s,mid-1,target);
        }else{
            return search(nums,mid+1,e,target);
        }
    }

    public int[] twoSum1(int[] numbers, int target) {

        int[] rs = new int[2];
        int maxIndex = numbers.length - 1;
        for(int i = 0 ; i < maxIndex ; i++){
            rs[0] = i + 1;
            int left = target - numbers[i];
            int leftIndex = search(numbers,i + 1,maxIndex,left);
            if(-1 != leftIndex){
                rs[1] = leftIndex + 1;
                break;
            }
        }
        return rs;
    }

    public int[] twoSum2(int[] numbers, int target) {

        int[] rs = new int[2];
        HashMap<Integer,Integer> map = new HashMap<>(numbers.length);
        for(int i = 0 ; i < numbers.length ; i++){
            map.put(numbers[i] , i);
        }
        for(int i = 0 ; i < numbers.length ;i++){
            int left = target - numbers[i];
            int val = map.getOrDefault(left , -1);
            if(-1 != val){
                rs[0] = i + 1;
                rs[1] = val + 1;
                break;
            }
        }
        return rs;
    }

    public int[] twoSum3(int[] numbers, int target) {

        int[] rs = new int[2];
        HashMap<Integer,Integer> map = new HashMap<>(numbers.length);
        for(int i = 0 ; i < numbers.length ; i++){
            int index = map.getOrDefault(numbers[i],-1);
            if(-1 != index){
                rs[0] = index + 1;
                rs[1] = i + 1;
                break;
            }else{
                map.put(target - numbers[i] , i);
            }
        }
        return rs;
    }

    public int[] twoSum(int[] numbers, int target) {

        int[] rs = new int[2];
        int s = 1;
        int e = numbers.length ;
        while(s < e){
            int sum = numbers[s-1] + numbers[e-1];
            if(sum == target){
                rs[0] = s;
                rs[1] = e;
                break;
            }else if(sum > target){
                e--;
            }else{
                s++;
            }
        }
        return rs;
    }
}
