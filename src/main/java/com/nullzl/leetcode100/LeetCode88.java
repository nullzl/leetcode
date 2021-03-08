package com.nullzl.leetcode100;

public class LeetCode88 {

    private void swap(int[] nums,int i , int j){
        if(i != j){
            nums[i] = nums[i] ^ nums[j];
            nums[j] = nums[i] ^ nums[j];
            nums[i] = nums[i] ^ nums[j];
        }
    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {


        int index = m + n - 1;
        int i,j;
        for(i = m - 1,j = n - 1; i >= 0 && j >= 0 ; ){
            if(nums1[i] >= nums2[j]){
                nums1[index--] = nums1[i];
                i--;
            }else{
                nums1[index--] = nums2[j];
                j--;
            }
        }
        while(j >= 0)
            nums1[index--] = nums2[j--];


    }
}
