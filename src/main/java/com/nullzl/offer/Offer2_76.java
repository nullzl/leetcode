package com.nullzl.offer;

public class Offer2_76 {

    private int partition(int[] nums,int s , int e){
        int temp = nums[s];
        while(s < e){
            while(e > s && nums[e] > temp) e--;
            nums[s] = nums[e];
            while(s < e && nums[s] <= temp) s++;
            nums[e] = nums[s];
        }
        nums[s] = temp;
        return s;
    }



    public int findKthLargest(int[] nums, int k) {

        int idx = nums.length - k;
        int s = 0 , e = nums.length - 1;
        while(true){
            int i = partition(nums,s,e);
            if(i == idx)
                return nums[i];
            if(idx > i)
                s = i + 1;
            else
                e = i - 1;
        }
    }
}
