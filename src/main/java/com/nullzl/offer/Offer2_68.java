package com.nullzl.offer;

public class Offer2_68 {

    public int searchInsert(int[] nums, int target) {
        int s = 0 , e = nums.length - 1;
        while(s <= e){
            int mid = s + ((e - s) >> 1);
            if(nums[mid] >= target)
                e = mid - 1;
            else
                s = mid + 1;
        }
        return s;
    }
}
