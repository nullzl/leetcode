package com.nullzl.leetcode1000;

import java.util.Random;

public class LeetCode907 {

    public int sumSubarrayMins(int[] arr) {
        int[] stk = new int[arr.length + 1];
        int[] count = new int[arr.length + 1];
        count[0] = 0;
        stk[0] = -1;
        int size = 0;
        int sum = 0;
        int mod = 1000000007;
        for(int i = 0 ; i < arr.length ; i++){
            while(size > 0 && arr[stk[size]] >= arr[i]) size--;
            stk[++size] = i;
            count[size] = (count[size-1] + ((stk[size] - stk[size - 1]) * arr[i]) % mod) % mod;
            sum = (sum + count[size]) % mod;
        }
        return sum;
    }

    public static void main(String[] args){
        Random r= new Random();
        int[] arr = new int[30000];
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = 10 + r.nextInt(20000);
            System.out.print(arr[i] + ",");
        }
    }
}
