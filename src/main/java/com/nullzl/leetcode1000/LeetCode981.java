package com.nullzl.leetcode1000;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class LeetCode981 {

    HashMap<String, TreeMap<Integer,String>> map;

    public LeetCode981() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        TreeMap<Integer,String> tree ;
        if(null == (tree = map.get(key))){
            tree = new TreeMap<>();
            map.put(key,tree);
        }
        tree.put(timestamp,value);
    }

    public String get(String key, int timestamp) {
        TreeMap<Integer,String> tree = map.get(key);
        if(null == tree)
            return "";

        Map.Entry<Integer,String> rs = tree.floorEntry(timestamp);
        return null == rs ? "" : rs.getValue();

    }
}
