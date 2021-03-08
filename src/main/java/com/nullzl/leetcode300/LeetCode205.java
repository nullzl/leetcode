package com.nullzl.leetcode300;

import java.util.HashMap;

public class LeetCode205 {

    public boolean isIsomorphic(String s, String t) {
        if(null == s || null == t || s.length() != t.length())
            return false;

        HashMap<Character,Character> map1 = new HashMap<>();
        HashMap<Character,Character> map2 = new HashMap<>();
        char ch1,ch2;
        Character ct1,ct2;
        for(int i = 0 ; i < s.length() ; i++){
            ch1 = s.charAt(i);
            ch2 = t.charAt(i);
            ct1 = map1.get(ch1);
            ct2 = map2.get(ch2);
            if(null == ct1 && null == ct2){
                map1.put(ch1,ch2);
                map2.put(ch2,ch1);
            }else if(null == ct1 || null == ct2){
                return false;
            }else if(ct1 != ch2 || ct2 != ch1){
                return false;
            }
        }
        return true;
    }

}
