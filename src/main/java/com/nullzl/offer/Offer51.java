package com.nullzl.offer;

import java.util.Random;

public class Offer51 {

    public int count(int[] nums,int s , int e){
        if(s >= e)
            return 0;

        int mid = s + ((e - s) >> 1);
        int count = count(nums,s,mid);
        count += count(nums,mid + 1 , e);
        int[] cp = new int[ e - s + 1];
        int  i = s , j = mid + 1, k = 0;
        while(i <= mid && j <= e ){
            if(nums[i] <= nums[j]){
                cp[k++] = nums[i++];
            }else{
                cp[k++] = nums[j++];
                count += (mid - i + 1);
            }
        }
        while(i <= mid)
            cp[k++] = nums[i++];
        while(j <= e)
            cp[k++] = nums[j++];

        System.arraycopy(cp,0,nums,s,cp.length);
        return count;
    }

    public int reversePairs(int[] nums) {

        if(null == nums || 0 == nums.length)
            return 0;

        return count(nums,0,nums.length - 1);

    }

    public static void main(String[] args){
        Random r = new Random();
        for(int i = 0 ;i < 10000 ; i++ ){
            System.out.print(r.nextInt() + ",");
        }
    }
}
