package com.nullzl.leetcode100;

import java.util.*;

public class LeetCode49 {
    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> rs = new ArrayList<List<String>>();
        if(null == strs)
            return rs;
        int size = 'z' - 'a' + 1;
        int[][] count = new int[strs.length][size];
        for(int i= 0 ; i < strs.length;i++){
            String str = strs[i];
            for(int j = 0 ; j < str.length() ; j++){
                count[i][str.charAt(j) - 'a']++;
            }
        }

        HashMap<String,Integer> map = new HashMap<String, Integer>();
        for(int i = 0 ;i < strs.length ;i++){
            StringBuilder temp = new StringBuilder();
            for(int j = 0 ; j <size ; j++){
                if(0 != count[i][j]) {
                    temp.append(((char) ('a' + j)));
                    temp.append(count[i][j]);
                }
            }
            String key = temp.toString();
            if(map.containsKey(key)){
                int index = map.get(key);
                rs.get(index).add(strs[i]);
            }else{
                List<String> list = new LinkedList<String>();
                list.add(strs[i]);
                map.put(key,rs.size());
                rs.add(list);
            }
        }
        return rs;
    }
}
