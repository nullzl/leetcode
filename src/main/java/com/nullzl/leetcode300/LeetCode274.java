package com.nullzl.leetcode300;

public class LeetCode274 {

    private void swap(int[] nums,int i ,int j){
        if(i != j){
            nums[i] = nums[i] ^ nums[j];
            nums[j] = nums[i] ^ nums[j];
            nums[i] = nums[i] ^ nums[j];
        }
    }

    private int partition(int[] nums,int s,int e){
        if(s > e){
            return nums.length;
        }
        if(s == e){
            if(nums[s] < nums.length - s)
                return nums.length - s - 1;
            else
                return nums.length;
        }
        int k = s - 1;
        for(int i = s ; i < e ; i++){
            if(nums[i] <= nums[e])
                swap(nums,++k,i);
        }
        swap(nums,e,++k);
        if(nums[k] < nums.length - k){
            return partition(nums,k,e);
        }else{
            return partition(nums,s,k - 1);
        }
    }
    public int hIndex(int[] citations) {

        if(null == citations)
            return 0;
        return partition(citations,0,citations.length - 1);

    }
}
