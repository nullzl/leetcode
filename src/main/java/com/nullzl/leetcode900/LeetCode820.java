package com.nullzl.leetcode900;

import java.util.Arrays;

public class LeetCode820 {


    public int minimumLengthEncoding(String[] words) {
        if(null == words || 0 == words.length)
            return 0;
        Arrays.sort(words,(s1,s2) -> {
            return s1.length() - s2.length();
        });
        boolean[] flag = new boolean[words.length];
        for(int i = 1 ; i < words.length ; i++){
            for(int j = 0 ; j < i ; j++){
                if(flag[j])
                    continue;
                if(words[i].endsWith(words[j]))
                    flag[j] = true;
            }
        }
        int count = 0;
        for(int i = 0 ; i < words.length ; i++){
            if(flag[i])
                continue;
            count += (words[i].length() + 1);
        }
        return count;
    }
}
