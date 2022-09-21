package com.nullzl.leetcode900;

import com.nullzl.util.Util;

public class LeetCode845 {

    public int longestMountain(int[] arr) {
        int count = 0;
        int state = 0;
        int max = 0;
        for(int i = 1 ; i < arr.length; i++){
            if(arr[i] == arr[i-1]){
                if(2 == state)
                    max = Math.max(max,count + 1);
                state = 0;
                count = 0;
            }else if(arr[i] > arr[i-1]){
                if(2 == state) {
                    state = 1;
                    max = Math.max(max, count + 1);
                    count = 1;
                }else {
                    state = 1;
                    count++;
                }
            }else{
                if(1 == state){
                    state = 2;
                    count++;
                }else if(2 == state)
                    count++;
            }
        }
        if(2 == state){
            max = Math.max(max, count + 1);
        }
        return max;
    }

    public  static void main(String[] args){
        System.out.println(Util.generateRandomArray(10000,0,10000));
    }

}
