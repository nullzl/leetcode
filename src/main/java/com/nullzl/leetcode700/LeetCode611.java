package com.nullzl.leetcode700;

import java.util.Arrays;

public class LeetCode611 {

    private boolean nextSeq(int[] seq){
        int count = seq[seq.length - 1] == 1 ? 1 : 0;
        int i;
        for( i = seq.length - 2 ; i >= 0 ; i--){
            if(0 == seq[i] && 1 == seq[i+1]){
                seq[i + 1] = 0;
                break;
            }
            seq[i + 1] = 0;
            count += seq[i];
        }
        if(i < 0)
            return false;
        seq[i] = 1;
        for(i = 1 ; i < count ; i++){
            seq[seq.length - i] = 1;
        }
        return true;
    }

    private boolean verify(int[] edges){
        return edges[0] + edges[1] > edges[2]
                && edges[0] + edges[2] > edges[1]
                && edges[1] + edges[2] > edges[0];
    }

    //超时
    public int triangleNumber1(int[] nums) {
        if(nums.length < 3)
            return  0;

        int[] seq = new int[nums.length];
        seq[nums.length-1] = 1;
        seq[nums.length-2] = 1;
        seq[nums.length-3] = 1;
        int[] tmp = new int[3];
        int count = 0;
        do{
            int j = 0;
            for(int i = 0 ; i < nums.length ; i++){
                if(1 == seq[i])
                    tmp[j++] = nums[i];
            }
            if(verify(tmp))
                count++;
        }while(nextSeq(seq));
        return count;
    }

    public int triangleNumber(int[] nums) {

        if(null == nums || nums.length < 3)
            return 0;
        Arrays.sort(nums);
        int s = 0;
        while(s < nums.length && 0 == nums[s])s++;
        int count = 0;
        for(int i = s + 2 ; i < nums.length ; i++){
            int m = i - 1;
            int n = s;
            for( ; m >= s && n <= i -1 ; m--){
                while(n <= i - 1 && nums[n] + nums[m] <= nums[i]) n++;
                count += (i - n);
            }
        }
        return count;
    }
}
