package com.nullzl.leetcode500;

public class LeetCode409 {

    public int longestPalindrome(String s) {

        if(null == s || 0 == s.length())
            return 0;
        int len = 'z' - 'a' + 1;
        int[] count = new int[len << 1];
        char ch;
        for(int i = 0 ; i < s.length() ; i++){
            ch = s.charAt(i);
            if(ch >= 'a' && ch <= 'z'){
                count[ch - 'a']++;
            }else{
                count[len + ch - 'A']++;
            }
        }
        int sum = 0;
        int odds = 0;
        len = len << 1;
        for(int i = 0 ; i < len ; i++){
            sum += count[i];
            if(0 != count[i] % 2)
                odds++;
        }

        sum = sum - (odds > 0 ? odds - 1 : 0);
        return sum;

    }

    public static void main(String[] args){
        System.out.println(new LeetCode409().longestPalindrome("abcdefghijklmnopqrstuvwxyzabcdeabcde"));
    }
}
