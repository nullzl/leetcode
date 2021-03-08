package com.nullzl.leetcode100;

public class LeetCode67 {

    public String addBinary(String a, String b) {

        if(a.length() < b.length())
            return addBinary(b,a);

        StringBuilder str = new StringBuilder();
        int add = 0;
        int i ,j;
        for(i = a.length()-1,j = b.length()-1 ; i>=0 && j>=0 ; i--,j--){
            int x = a.charAt(i) - '0';
            int y = b.charAt(j) - '0';
            int sum = add + x + y;
            str.append((char)(sum % 2 + '0'));
            add = sum / 2;
        }
        for(;i>= 0 && '0' != add ; i--){
            int x = a.charAt(i) - '0';
            int sum = add + x ;
            str.append((char)(sum % 2 + '0'));
            add = sum / 2;
        }
        for(; i>= 0 ; i--){
            str.append(a.charAt(i));
        }
        if(0 != add){
            str.append((char)(add + '0'));
        }
        return str.reverse().toString();

    }
}
