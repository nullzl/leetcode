package com.nullzl.offer;

import java.util.*;

public class Offer2_33 {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();

        for(String s : strs){
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String temp = new String(arr);
            List<String> list = map.get(temp);
            if(null == list){
                list = new LinkedList<>();
                map.put(temp,list);
            }
            list.add(s);
        }

        return new ArrayList<List<String>>(map.values());
    }
}
