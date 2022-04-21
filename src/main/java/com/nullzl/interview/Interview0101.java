package com.nullzl.interview;

import java.util.HashSet;

public class Interview0101 {
    public boolean isUnique(String astr) {
        if(null == astr || 0 == astr.length())
            return true;

        char[] arr = astr.toCharArray();
        HashSet<Character> set = new HashSet<>();
        for(char ch : arr){
            if(set.contains(ch))
                return false;
            set.add(ch);
        }
        return true;
    }
}
