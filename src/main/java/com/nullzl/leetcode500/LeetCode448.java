package com.nullzl.leetcode500;

import java.util.LinkedList;
import java.util.List;

public class LeetCode448 {

    public List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> list = new LinkedList<>();
        int temp,k;
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] - 1 == i  || 0 == nums[i])
                continue;
            k = nums[i];
            nums[i] = 0;
            while(0 != k && k != nums[k - 1]){
                temp = nums[k-1];
                nums[k-1] = k;
                k = temp;
            }
        }
        for(int i = 0 ; i < nums.length ; i++){
            if(0 == nums[i])
                list.add(i + 1);
        }
        return list;
    }

    public static void main(String[] args){

    }
}
