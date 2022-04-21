package com.nullzl.offer;

public class Offer53 {

    public int search(int[] nums, int target) {
        if(null == nums || 0 == nums.length)
            return 0;
        int s = 0 , e = nums.length - 1;

        while(s <= e){
            int mid = s + ((e - s) >> 1);
            if(nums[mid] >= target)
                e = mid - 1;
            else
                s = mid + 1;
        }
        int left = s;
        s = 0 ; e = nums.length - 1;
        while(s <= e){
            int mid = s + ((e - s) >> 1);
            if(nums[mid] > target)
                e = mid - 1;
            else
                s = mid + 1;
        }
        int right = e;
        return right - left + 1;

    }


    public int missingNumber(int[] nums) {

        int pos = -1;
        for(int i = 0 ; i < nums.length ; ){
            if(nums[i] == i)
                i++;
            else if(nums[i] == nums.length){
                pos = i;
                i++;
            }else{
                int j = nums[i];
                nums[i] = nums[i] ^ nums[j];
                nums[j] = nums[i] ^ nums[j];
                nums[i] = nums[i] ^ nums[j];
            }

        }
        return -1 == pos ? nums.length : pos;
    }
}
