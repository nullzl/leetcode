package com.nullzl.leetcode1400;

import java.util.Arrays;

public class LeetCode1356 {

    private int countBits(int num){
        int count = 0;
        while(0 != num){
            num &= (num - 1);
            count++;
        }
        return count;
    }

    public int[] sortByBits(int[] arr) {

        int[][] bits = new int[14][arr.length];
        int[] len = new int[14];


        for(int i = 0 ; i < arr.length ; i++){
            int count = countBits(arr[i]);
            bits[count][len[count]++] = arr[i];
        }

        for(int i = 0,j = 0 ; i < bits.length ; i++){
            Arrays.sort(bits[i],0,len[i]);
            System.arraycopy(bits[i],0,arr,j,len[i]);
            j+= len[i];
        }
        return arr;
    }

    public static void main(String[] args){
        Arrays.sort(new int[10],0,0);
    }
}
