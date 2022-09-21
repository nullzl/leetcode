package com.nullzl.leetcode1100;

import com.nullzl.util.Util;

import java.util.Arrays;
import java.util.Random;

public class LeetCode1035 {

    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int max = 2000;
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        int[] last1 = new int[max + 1];
        int[] last2 = new int[max + 1];

        for(int i = 1 ; i < dp.length ; i++){
            last1[nums1[i-1]] = i;
            Arrays.fill(last2,0);
            for(int j = 1 ; j < dp[i].length ; j++){
                last2[nums2[j-1]] = j;
                if(0 != last2[nums1[i-1]])
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][last2[nums1[i-1]]-1] + 1);
                if(0 != last1[nums2[j-1]])
                    dp[i][j] = Math.max(dp[i][j],dp[last1[nums2[j-1]]-1][j-1] + 1);
                dp[i][j]= Math.max(dp[i][j],Math.max(dp[i-1][j],dp[i][j-1]));
            }
        }
        return dp[nums1.length][nums2.length];
    }
    public static void main(String[] args){
        Random r = new Random();
        int len1 = r.nextInt(100) + 400;
        int len2 = r.nextInt(100) + 350;
        System.out.println(Util.generateRandomArray(len1,1,200));
        System.out.println(Util.generateRandomArray(len2,1,200));
    }
}
