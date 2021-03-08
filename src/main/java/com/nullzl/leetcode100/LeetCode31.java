package com.nullzl.leetcode100;

public class LeetCode31 {
    /**
     * 对于数字a1,a2,a3,...an，尽量保持高位不变，从最低位开始寻找
     * 对于每个ai，从n到i+1开始寻找第一个ak，ak > ai
     * 由寻找方式决定，ai+1,必然大于ai+2,ai+3,...an
     * 所以有an<=an-1<=an-2<=ak<=...<=ai+1
     * 由于ai<ak,所以下一个排列为
     * a1,a2,..ai-1,ak,(an,an-1,an-2,...,ak+1,ai),ak-1,ak-2,...ai+1
     */
    public void nextPermutation(int[] nums) {
        if(null == nums || 0 == nums.length)
            return ;
        if(1 == nums.length){
            System.out.println(nums[0]);
            return ;
        }

        int i,j,k = -1;
        for(i = nums.length - 2 ; i >= 0 ; i--){
            if(nums[i] < nums[i+1])
                break;
        }
        if(i < 0){
            reverse(nums,0,nums.length - 1);
        } else{
            for(j = nums.length - 1 ; j >= i + 1 ; j--){
                if(nums[j] > nums[i]){
                    k = j;
                    break;
                }
            }
            swap(nums,i,k);
            reverse(nums,i + 1,nums.length - 1);
        }
    }

    private void swap(int[] nums,int i,int j){
        if(i != j){
            nums[i] = nums[i] ^ nums[j];
            nums[j] = nums[i] ^ nums[j];
            nums[i] = nums[i] ^ nums[j];
        }
    }

    private void reverse(int[] nums,int start,int end){
        while(start < end){
            swap(nums,start,end);
            start++;
            end--;
        }
    }
}
