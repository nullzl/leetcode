package com.nullzl.leetcode1100;

public class LeetCode1047 {

    public String removeDuplicates(String s) {

        char[] arr = s.toCharArray();
        int i = 0, j = 0;
        for(; j < arr.length ; j++){
            if(i <= 0 || arr[i-1] != arr[j])
                arr[i++] = arr[j];
            else{
                i--;
            }
        }
        return new String(arr,0,i);
    }
}
