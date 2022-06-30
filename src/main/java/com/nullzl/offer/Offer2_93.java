package com.nullzl.offer;

import java.util.HashMap;
import java.util.Random;

public class Offer2_93 {

    public int lenLongestFibSubseq(int[] arr) {

        int[][] dp = new int[arr.length][arr.length];
        int ans = 0;
        for(int j = 1; j < arr.length ; j++){
            int i = 0 , k = j + 1;
            while(i < j && k < arr.length){
                int sum = arr[i] + arr[j];
                while(k < arr.length && arr[k] < sum) k++;
                if(k < arr.length && sum == arr[k]){
                    dp[j][k] = (dp[i][j] == 0 ? 2 : dp[i][j]) + 1;
                    ans = Math.max(ans,dp[j][k]);
                }
                i++;
            }
        }
        return ans;
    }

    public int lenLongestFibSubseq1(int[] arr) {

        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ;i < arr.length ; i++)
            map.put(arr[i],i);

        int[][] dp = new int[arr.length][arr.length];
        int max = 0;
        for(int i = 0 ; i < arr.length ; i++){
            for(int j= i + 1 ; j < arr.length ; j++){
                int delta = arr[j] - arr[i];
                int idx = map.getOrDefault(delta,arr.length);
                if(idx >= i)
                    dp[i][j] = 2;
                else{
                    dp[i][j] = dp[idx][i] + 1;
                }
                max = Math.max(max,dp[i][j]);
            }
        }
        return max == 2 ? 0 : max;
    }

    public static void main(String[] args){
        Random r = new Random();
        int len = r.nextInt(500) + 3;
        int base = r.nextInt(10) + 1;
        System.out.print("[" + base);
        for(int i = 0 ; i < len ; i++){
            int k = r.nextInt(100) + 1;
            base += (r.nextInt(k) + 1);
            System.out.print("," + base);
        }
        System.out.println("]");

    }
}
