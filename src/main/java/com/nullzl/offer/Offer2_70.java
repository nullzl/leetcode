package com.nullzl.offer;

public class Offer2_70 {

    public int singleNonDuplicate(int[] nums) {
        int s = 0 , e = nums.length - 1;
        while(s < e){
            int mid = s + ((e - s) >> 1);
            if(mid - 1 >= 0 && nums[mid - 1] == nums[mid]){
                if(0 == (1 & (mid - 1)))
                    s = mid + 1;
                else
                    e = mid - 1;
            }else if(mid + 1 < nums.length && nums[mid + 1] == nums[mid]){
                if(0 == (1 & mid))
                    s = mid + 1;
                else
                    e = mid - 1;
            }else{
                return nums[mid];
            }
        }
        return nums[s];
    }
}
