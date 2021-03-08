package com.nullzl.leetcode200;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class LeetCode139 {

    private boolean findWord(String s, int index, HashSet<String> set,int maxLen,HashMap<Integer,Boolean> cache){

        if(cache.keySet().contains(index))
            return cache.get(index);

        if(index == s.length()) {
            cache.put(index,true);
            return true;
        }

        for(int i = index + 1 ; i <= s.length() ; i++){
            if(i - index > maxLen) {
                cache.put(index,false);
                return false;
            }
            String str = s.substring(index,i);
            if(set.contains(str)){
                if(findWord(s,i,set,maxLen,cache)) {
                    cache.put(index,true);
                    return true;
                }
            }
        }
        cache.put(index,false);
        return false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {

        Iterator<String> iterator = wordDict.iterator();
        HashSet<String> set = new HashSet<>();
        int maxLen = 0;
        while(iterator.hasNext()){
            String str = iterator.next();
            if(str.length() > maxLen)
                maxLen = str.length();
            set.add(str);
        }

        HashMap<Integer,Boolean> cache = new HashMap<>();

        return findWord(s,0,set,maxLen,cache);

    }
}
