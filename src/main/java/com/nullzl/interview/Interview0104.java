package com.nullzl.interview;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Interview0104 {

    public boolean canPermutePalindrome(String s) {

        if(null == s || 0 == s.length())
            return true;

        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            int count = map.getOrDefault(ch,0);
            map.put(ch,count + 1);
        }

        Iterator<Map.Entry<Character,Integer>> iterator = map.entrySet().iterator();
        int count = 0;
        while(iterator.hasNext()){
            if(0 != (1 & iterator.next().getValue()))
                count++;
            if(2 == count)
                return false;
        }
        return true;
    }
}
