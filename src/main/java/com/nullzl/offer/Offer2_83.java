package com.nullzl.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Offer2_83 {
    private void swap(int[] nums,int i, int j ){
        if(i != j){
            nums[i] = nums[i] ^ nums[j];
            nums[j] = nums[i] ^ nums[j];
            nums[i] = nums[i] ^ nums[j];
        }
    }
    private int[] next(int[] nums){
        int i = nums.length - 2;
        while(i >= 0 && nums[i] >= nums[i + 1])
            i--;
        if(i < 0)
            return null;
        int j = i + 1;
        while(j < nums.length && nums[j] > nums[i]) j++;
        j--;
        swap(nums,i,j);
        for(int x = i + 1, y = nums.length - 1; x < y ; x++,y--)
            swap(nums,x,y);
        return nums;
    }

    public List<List<Integer>> permute(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new LinkedList<>();
        while(null != nums){
            List<Integer> list = new ArrayList<>(nums.length);
            for(int n : nums)
                list.add(n);
            ans.add(list);
            nums = next(nums);
        }
        return ans;
    }
}
