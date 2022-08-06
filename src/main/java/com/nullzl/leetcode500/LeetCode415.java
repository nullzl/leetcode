package com.nullzl.leetcode500;

public class LeetCode415    {

    public String addStrings(String num1, String num2) {

        char[] arr1 = num1.toCharArray();
        char[] arr2 = num2.toCharArray();
        int num = 0 ;
        StringBuilder builder = new StringBuilder();
        for(int i = arr1.length-1 , j = arr2.length-1 ; i >= 0 || j >= 0 ; i--,j--){
            num += (i >= 0 ? (arr1[i] - '0') : 0) + (j >= 0 ? arr2[j] - '0' : 0);
            builder.append((char)(num % 10 + '0'));
            num /= 10;
        }
        if(0 != num)
            builder.append((char)(num + '0'));
        return builder.reverse().toString();
    }
}
