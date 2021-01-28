package com.nullzl.leetcode300;

import java.util.HashMap;

public class LeetCode290 {

    public boolean wordPattern(String pattern, String str) {
        if(null == pattern || null == str)
            throw new IllegalArgumentException();

        String[] strs = str.split("[ ]+");
        if(pattern.length() != strs.length)
            return false;
        HashMap<String,Character> map1 = new HashMap<>();
        String[] map2 = new String['z' - 'a' + 1];
        for(int i = 0 ; i < pattern.length(); i++){
            char ch = pattern.charAt(i);
            if(null == map2[ch - 'a'] && null == map1.get(strs[i])){
                map2[ch - 'a'] = strs[i];
                map1.put(strs[i],ch);
            }else if(!strs[i].equals(map2[ch - 'a']) || map1.get(strs[i]) != ch){
                return false;
            }
        }
        return true;
    }

    public static void main(String[]args){
        System.out.print(new LeetCode290().wordPattern("abba","dog cat cat dog"));
    }
}
