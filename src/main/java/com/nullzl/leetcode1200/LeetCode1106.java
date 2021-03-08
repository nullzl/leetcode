package com.nullzl.leetcode1200;

import java.util.Arrays;

public class LeetCode1106 {

    public int countCharacters(String[] words, String chars) {

        if(null == chars || 0 == chars.length()
            || null == words || 0 == words.length)
            return 0;

        char[] str = chars.toCharArray();
        int[] amount = new int['z' - 'a' + 1];
        for(int i = 0 ; i < str.length ; i++){
            amount[str[i] - 'a']++;
        }

        int count = Arrays.stream(words).filter(s ->{
            char[] temp = s.toCharArray();
            int[] wordAmount = new int['z' - 'a' + 1];
            for(int i = 0; i < temp.length ; i++){
                if(++wordAmount[temp[i] - 'a'] > amount[temp[i] - 'a'])
                    return false;
            }
            return true;
        }).mapToInt(s -> s.length()).sum();
        return count;
    }
}
