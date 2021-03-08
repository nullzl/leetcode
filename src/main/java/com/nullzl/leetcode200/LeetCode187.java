package com.nullzl.leetcode200;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LeetCode187 {

    public List<String> findRepeatedDnaSequences(String s) {

        List<String> list = new LinkedList<>();
        if(null == s || s.length() < 10)
            return list;

        HashMap<String,Integer> map = new HashMap<>();
        for(int i = 0 ; i <= s.length() - 10 ; i++){
            String str = s.substring(i,i + 10);
            map.put(str,map.getOrDefault(str,0) + 1);
        }
        Iterator<String> iterator = map.keySet().iterator();
        while(iterator.hasNext()){
            String str = iterator.next();
            if(map.get(str) > 1)
                list.add(str);

        }
        return list;
    }
}
