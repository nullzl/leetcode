package com.nullzl.leetcode500;

import java.util.Arrays;

public class LeetCode493 {

    class Num{
        public int index0;
        public int index1;
        public int index2;

        public Num(int i){
            this.index0 = i;
        }
    }
    private void update(int[] sums,int i){
        while(i < sums.length){
            sums[i]++;
            i += (i & (-i));
        }
    }

    private int query(int[] sums,int i){
        int rs = 0;
        i--;
        while(i > 0){
            rs += sums[i];
            i -= (i & (-i));
        }
        return rs;
    }

    public int reversePairs(int[] nums) {

        if(null == nums || nums.length < 2)
            return 0;

        Num[] ns = new Num[nums.length];
        Num[] copy = new Num[nums.length];
        Num[] arr = new Num[nums.length * 2];
        int[] sums = new int[nums.length * 2 + 1];

        for(int i = 0 ; i < nums.length ; i++){
            ns[i] = new Num(i);
        }
        System.arraycopy(ns,0,copy,0,ns.length);
        Arrays.sort(copy,(p1,p2) ->{
            if(nums[p1.index0] == nums[p2.index0])
                return 0;
            else if(nums[p1.index0] < nums[p2.index0])
                return -1;
            return 1;
        });

        int i = 0 ,j = 0,k = 1;
        while(i < copy.length && j < copy.length){
            if(nums[copy[i].index0] <= nums[copy[j].index0] * 2L)
                copy[i++].index1 = k++;
            else
                copy[j++].index2 = k++;
        }
        while(i < copy.length)
            copy[i++].index1 = k++;
        while(j < copy.length)
            copy[j++].index2 = k++;

        int rs = 0;
        for(i = ns.length -1  ; i >= 0 ; i--){
            rs += query(sums,ns[i].index1);
            update(sums,ns[i].index2);
        }
        return rs;
    }

    public static void main(String[] args){
        new LeetCode493().reversePairs(new int[]{2147483647,2147483647,-2147483647,-2147483647,-2147483647,2147483647});
    }
}
