package com.nullzl.leetcode600;

public class LeetCode540 {

    public int singleNonDuplicate(int[] nums) {

        int s = 0 , e = nums.length - 1;
        while(s < e){
            int mid = s + ((e - s) >> 1);
            if(mid - 1 >= 0 && nums[mid] == nums[mid - 1]){
                if(0 != (1 & mid))
                    s = mid + 1;
                else
                    e = mid - 2;
            }else if(mid + 1 < nums.length && nums[mid] == nums[mid+1]){
                if(0 != (1 & mid))
                    e = mid - 1;
                else
                    s = mid + 2;
            }else
                return nums[mid];
        }

        return nums[s];

    }
}
