package com.nullzl.leetcode100;

public class LeetCode14 {

    public String longestCommonPrefix(String[] strs) {

        StringBuilder rs = new StringBuilder();
        int i,j;
        char ch;
        if(null == strs || 0 == strs.length)
            return rs.toString();
        for(i = 0 ; i < strs[0].length() ; i++){
            ch = strs[0].charAt(i);
            for(j = 1; j < strs.length ; j++){
                if(i >= strs[j].length() || ch != strs[j].charAt(i))
                    return rs.toString();
            }
            rs.append(ch);
        }
        return rs.toString();
    }
}
