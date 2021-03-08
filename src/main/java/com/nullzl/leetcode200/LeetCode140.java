package com.nullzl.leetcode200;

import java.util.*;

public class LeetCode140 {

    private List<String> findWord(String s, int index, HashSet<String> set, int maxLen,HashMap<Integer,List<String>> cache){
        List<String> list = cache.get(index);
        if(null != list)
            return list;

        LinkedList<String> rs = new LinkedList<>();
        for(int i = index + 1; i <= s.length() ; i++){
            if(i - index > maxLen) {
                break;
            }
            String str = s.substring(index,i);
            if(set.contains(str)){

                if(i == s.length()){
                    rs.add(str);
                }else{
                    list = findWord(s,i,set,maxLen,cache);
                    if(0 != list.size()){
                        Iterator<String> iterator = list.iterator();
                        while(iterator.hasNext()){
                            rs.add(str + " " + iterator.next());
                        }
                    }
                }
            }
        }
        cache.put(index,rs);
        return rs;

    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        Iterator<String> iterator = wordDict.iterator();
        HashSet<String> set = new HashSet<>();
        int maxLen = 0;
        while(iterator.hasNext()){
            String str = iterator.next();
            if(str.length() > maxLen)
                maxLen = str.length();
            set.add(str);
        }

        HashMap<Integer,List<String>> cache = new HashMap<>();

        return findWord(s,0,set,maxLen,cache);

    }
}
