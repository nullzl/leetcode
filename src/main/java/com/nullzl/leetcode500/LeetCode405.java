package com.nullzl.leetcode500;

public class LeetCode405 {

    public String toHex(int num) {
        char[] arr = new char[8];
        int n = 15;
        for(int i = 0 ; i < 8 ; i++){
            int tmp = num & n;
            arr[7 - i] =  tmp <= 9 ? (char)('0' + tmp) : (char)('a' + tmp - 10);
            num >>>= 4;
        }
        int k = 0;
        for(; k < arr.length && '0' == arr[k] ; k++);
        if(k == arr.length)
            return "0";
        return new String(arr,k,8-k);
    }
}
