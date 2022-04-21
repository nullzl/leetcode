package com.nullzl.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Interview1002 {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> lists = new ArrayList<>();
        if(null == strs || 0 == strs.length)
            return lists;

        HashMap<String,List<String>> map =new HashMap<>();
        for(String s : strs){
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String tmp = new String(arr);
            List<String> list = map.get(tmp);
            if(null == list){
                list = new ArrayList<>();
                map.put(tmp,list);
                lists.add(list);
            }
            list.add(s);
        }
        return lists;
    }
}
