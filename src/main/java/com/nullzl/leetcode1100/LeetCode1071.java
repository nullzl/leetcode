package com.nullzl.leetcode1100;

public class LeetCode1071 {

    public String gcdOfStrings(String str1, String str2) {

        if(null == str1 || null == str2
                || 0 == str1.length() || 0 == str2.length())
            return "";

        if(str1.length() < str2.length())
            return gcdOfStrings(str2,str1);

        int i,k;
        for(i = 0 ,k = 0; i < str1.length() ; i++,k = (k + 1) % str2.length()){
            if(str1.charAt(i) != str2.charAt(k))
                return "";
        }

        if(0 == k)
            return str2;
        return gcdOfStrings(str2.substring(0,k),str2.substring(k,str2.length()));
    }

    public static void main(String[] args){
        System.out.println(new LeetCode1071().gcdOfStrings("LEET","ABAB"));
    }
}
