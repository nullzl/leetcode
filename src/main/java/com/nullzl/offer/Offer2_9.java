package com.nullzl.offer;

public class Offer2_9 {

    public int numSubarrayProductLessThanK(int[] nums, int k) {

        int s = 0;
        int rs = 1;
        int ans = 0;
        for(int i = 0; i < nums.length ; i++){
            rs *= nums[i];
            while(s <= i && rs >= k)
                rs /= nums[s++];
            ans += (i - s + 1);
        }
        return ans;
    }
}
