package com.nullzl.leetcode300;

public class LeetCode268 {

    public int missingNumber(int[] nums) {

        if(null == nums || 0 == nums.length)
            return 0;
        int rs = nums.length;
        for(int i = 0 ; i < nums.length ; i++){
            if(i == nums[i])
                continue;

            int k = nums[i];
            while(k != i && k != rs){
                int temp = nums[k];
                nums[k] = k;
                k = temp;
            }

            if(k == i){
                nums[i] = k;
            }else{
                if(rs < nums.length)
                    nums[rs] = k;
                rs = i;
            }
        }
        return rs;
    }

    public static void main(String[] args){
        System.out.println(new LeetCode268().missingNumber(
                new int[]{1,2,3,4,5,0}
        ));
    }
}
