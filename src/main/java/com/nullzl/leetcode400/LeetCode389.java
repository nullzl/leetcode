package com.nullzl.leetcode400;

public class LeetCode389 {

    public char findTheDifference(String s, String t) {

        if(null == s || null == t || t.length() - s.length() != 1)
            throw new IllegalArgumentException();

        int[] amount = new int['z' - 'a' + 1];
        int i;
        for(i = 0 ; i < s.length() ; i++) {
            amount[s.charAt(i) - 'a']++;
            amount[t.charAt(i) - 'a']--;
        }
        amount[t.charAt(i) - 'a']--;
        for(i = 0 ; i < amount.length ; i++){
            if(0 != amount[i])
                return (char)('a' + i);
        }
        return ' ';
    }
}
