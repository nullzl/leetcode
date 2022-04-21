package com.nullzl.offer;

import java.util.HashSet;

public class Offer48 {

    public int lengthOfLongestSubstring(String s) {

        if(null == s || 0 == s.length())
            return 0;

        HashSet<Character> set = new HashSet<>();
        set.add(s.charAt(0));
        int rs = 1;
        int i = 0 ,j = 1;
        for(; j < s.length() ; j++){
            char ch1 = s.charAt(j);
            if(set.contains(ch1)){
                while(i < j && s.charAt(i) != ch1)
                    set.remove(s.charAt(i++));
                i++;
            }else{
                set.add(ch1);
            }
            rs = Math.max(rs, j - i  + 1);
        }
        return rs;

    }
}
