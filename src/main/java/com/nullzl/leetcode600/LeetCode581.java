package com.nullzl.leetcode600;

public class LeetCode581 {

    public int findUnsortedSubarray(int[] nums) {

        if(null == nums || 0 == nums.length)
            return 0;

        int min,max,i,s = -1,e = -1;
        for(i = 1 ; i < nums.length ; i++){
            if(nums[i] < nums[i-1])
                break;
        }
        if(i == nums.length)
            return 0;
        e = i;
        s = i - 1;
        min = nums[e];
        max = nums[s];
        while(s-1 >= 0 && nums[s-1] > min)
            s--;
        for(i++; i < nums.length ; i++){
            if(nums[i] < min){
                min = nums[i];
                while(s-1 >= 0 && nums[s-1] > min)
                    s--;
                e = i;
            }else if(nums[i] < max){
                e = i;
            }else{
                max = nums[i];
            }
        }
        return e - s + 1;
    }
    public static void main(String[] args){
        System.out.println(new LeetCode581().findUnsortedSubarray(
                new int[] {
                    1,2,1,4,5,6,2,7,9,0
                }
        ));
    }
}
