package com.nullzl.leetcode1000;

import java.util.Random;

public class LeetCode960 {

    public int minDeletionSize(String[] strs) {
        int len = strs[0].length();
        int[] dp = new int[len];
        char[][] arr = new char[strs.length][];
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = strs[i].toCharArray();
        }
        dp[0] = 1;

        for(int i = 1 ; i < len ; i++){
            dp[i] = 1;
            for(int j = i - 1 ; j >= 0 ; j--){
                int k = 0;
                for(; k < arr.length ; k++){
                    if(arr[k][i] < arr[k][j])
                        break;
                }
                if(k < arr.length)
                    continue;
                dp[i] = Math.max(dp[i],dp[j] + 1);
            }
        }
        int max = dp[0];
        for(int num : dp){
            max = Math.max(max,num);
        }
        return len - max;
    }

    public static void main(String[] args){
        Random r = new Random();
        int len = r.nextInt(90) + 10;
        int size = r.nextInt(90) + 5;
        System.out.print("[");
        char[] arr = new char[len];
        for(int j = 0 ; j < len ; j++){
            arr[j] = (char)('a' + r.nextInt('z' - 'a'));
        }
        System.out.print("\"" + new String(arr) + "\"");
        for(int i = 1 ; i < size ; i++){
            for(int j = 0 ; j < len ; j++){
                arr[j] = (char)('a' + r.nextInt('z' - 'a'));
            }
            System.out.print(",\"" + new String(arr) + "\"");
        }
        System.out.print("]");
    }
}
