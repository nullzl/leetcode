package com.nullzl.leetcode500;

import java.util.Random;

public class LeetCode424 {

    private int max(int[] count,int k){
        int max = 0;
        int i = 0 , j = 1;
        while(j < count.length){
            while(i < j && j - i - (count[j] - count[i]) > k)
                i++;
            max = Math.max(max,j - i);
            j++;
        }
        return max;
    }

    public int characterReplacement1(String s, int k) {

        char[] arr = s.toCharArray();
        int[][] count = new int['Z' - 'A' + 1][arr.length + 1];
        for(int i = 1 ; i <= arr.length ; i++){
            for(int j = 0 ; j < count.length ; j++){
                count[j][i] = count[j][i-1];
            }
            count[arr[i-1] - 'A'][i]++;
        }
        int max = 0;
        for(int i = 0 ; i < count.length ; i++){
            max = Math.max(max,max(count[i],k));
        }
        return max;
    }

    public static void main(String[] args){
        Random r = new Random();
        int len = r.nextInt(1000) + 90000;
        int k = r.nextInt(len);
        char[] arr = new char[len];
        for(int i = 0 ;i < len ; i++){
            arr[i] = (char)('A' + r.nextInt('Z' - 'A' + 1));
        }
        System.out.println("\"" + new String(arr) + "\"");
        System.out.println(k);
    }
}
