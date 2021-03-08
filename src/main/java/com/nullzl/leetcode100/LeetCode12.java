package com.nullzl.leetcode100;

public class LeetCode12 {

    public String intToRoman(int num) {

        if(num <= 0)
            return "";

        StringBuilder rs = new StringBuilder();
        int i,j,k,temp;
        char[] chs = {'M','D','C','L','X','V','I'};
        int[] nums = {1000,500,100,50,10,5,1};

        for(i = 0 ;i < nums.length && num != 0 ; i++){
            temp = num / nums[i];
            num = num % nums[i];
            for(j = 0 ; j < temp ; j++)
                rs.append(chs[i]);

            k = (i % 2 == 0) ? i + 2 : i + 1;
            if(k < nums.length && num - nums[i] + nums[k] >= 0){
                num = num - nums[i] + nums[k];
                rs.append(chs[k]);
                rs.append(chs[i]);
            }

        }

        return rs.toString();

    }
}
