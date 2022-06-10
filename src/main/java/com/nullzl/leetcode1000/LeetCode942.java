package com.nullzl.leetcode1000;

public class LeetCode942 {

    public int[] diStringMatch(String s) {

        char[] arr = s.toCharArray();
        int left = 0 , right = arr.length;
        int[] rs = new int[arr.length + 1];
        if('I' == arr[0])
            rs [0] = left++;
        else
            rs[0] = right--;

        for(int i = 0 ; i < arr.length ; ){
            int j = i + 1;
            while(j < arr.length && arr[j] == arr[i]) j++;
            if('I' == arr[i]){
                for(int k = j ; k > i ; k--){
                    rs[k] = right--;
                }
            }else{
                for(int k = j ; k > i ; k--)
                    rs[k] = left++;
            }
            i = j;
        }
        return rs;
    }
}
