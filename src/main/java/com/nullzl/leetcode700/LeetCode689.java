package com.nullzl.leetcode700;

import java.util.Arrays;

public class LeetCode689 {

    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        if(0 == k || 3 * k > nums.length)
            throw new IllegalArgumentException();
        int[] sub = new int[nums.length - k + 1];
        for(int i = 1 ;i < nums.length ; i++)
            nums[i] += nums[i - 1];
        sub[0] = nums[k-1];
        for(int i = 1 ; i < sub.length ; i++) {
            sub[i] = nums[i + k - 1] - nums[i - 1];
        }

        int[] preMax = new int[nums.length];
        int[] postMax = new int[nums.length];
        preMax[k - 1] = 0;
        for(int i = k ; i < nums.length - 2 * k ; i++){
            preMax[i] = sub[i - k + 1] > sub[preMax[i - 1]] ? i - k + 1 : preMax[i-1];
        }
        postMax[nums.length - k] = nums.length  - k;
        for(int i = nums.length - k - 1 ; i >= 2 * k ; i--){
            postMax[i] = sub[i] >= sub[postMax[i+1]] ? i : postMax[i+1];
        }
        int max = 0;
        int[] idx = new int[3];
        for(int i = k ; i <= nums.length - 2 * k; i++){
            int sum = sub[preMax[i - 1]] + sub[i] + sub[postMax[i + k]];
            if(sum > max){
                max = sum;
                idx[0] = preMax[i-1];
                idx[1] = i;
                idx[2] = postMax[i + k];
            }
        }
        return idx;
    }

    public int[] maxSumOfThreeSubarrays1(int[] nums, int k) {

        if(0 == k || 3 * k > nums.length)
            throw new IllegalArgumentException();
        int[] sub = new int[nums.length - k + 1];
        for(int i = 1 ;i < nums.length ; i++)
            nums[i] += nums[i - 1];
        sub[0] = nums[k-1];
        int[] stk = new int[sub.length];
        int[] next = new int[sub.length];
        Arrays.fill(next,-1);
        int x = 1;
        stk[0] = 0;
        for(int i = 1 ; i < sub.length ; i++) {
            sub[i] = nums[i + k - 1] - nums[i - 1];
            while(x > 0 && sub[i] > sub[stk[x-1]])
                next[stk[--x]] = i;
            stk[x++] = i;
        }

        int[] idx = new int[nums.length - k + 1];
        idx[idx.length - 1] = idx.length - 1;
        for(int i = idx.length - 2 ; i >= 2 * k ; i--){
            idx[i] = sub[i] >= sub[idx[i+1]] ? i : idx[i+1];
        }
        int max = 0;
        int[] rs = new int[3];
        for(int i = 0; -1 != i && i < nums.length - 3 * k + 1 ; i = next[i]){
            for(int j = i + k ; -1 != j && j < nums.length - 2 * k + 1 ; j = next[j]){
                int sum = sub[i] + sub[j] + sub[idx[j + k]];
                if(sum > max){
                    max = sum;
                    rs[0] = i;
                    rs[1] = j;
                    rs[2] = idx[j+k];
                }
            }
        }
        return rs;
    }

    public static void main(String[] args){
//        Random r = new Random();
//        int len = r.nextInt(2000) + 1;
//        for(int i = 0 ; i < len ; i++){
//            System.out.print(r.nextInt(65534) + 1);
//            System.out.print(",");
//        }
        new LeetCode689().maxSumOfThreeSubarrays(new int[]{1,2,1,2,6,7,5,1},2);
    }
}
