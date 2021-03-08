package com.nullzl.leetcode100;

import java.util.*;

public class LeetCode30 {

    private void clearMap(HashMap<String,Integer> map){
        Iterator<String> iterator = map.keySet().iterator();
        while(iterator.hasNext()){
            String key = iterator.next();
            map.put(key,0);
        }
    }


    public List<Integer> findSubstring(String s, String[] words) {
        LinkedList<Integer> rs = new LinkedList<Integer>();
        if(null == s || null == words || 0 == words.length || 0 == s.length() || 0 == words[0].length())
            return rs;

        int wordLen = words[0].length();
        int targetLen = wordLen * words.length;
        if(s.length() < targetLen  )
            return rs;
        HashMap<String,Integer> map = new HashMap<String, Integer>();
        HashMap<String,Integer> countMap = new HashMap<String,Integer>();
        for(int i = 0 ; i < words.length ; i++){
            map.put(words[i],map.getOrDefault(words[i],0) + 1);
            countMap.put(words[i],0);
        }

        for(int i = 0 ; i < wordLen && i + targetLen <= s.length() ;i++){
            int j = i;
            int k = 0;
            while(j + targetLen <= s.length()){
                int begin = j + k * wordLen;
                while(k < words.length){
                    String str = s.substring(begin,begin + wordLen);
                    if(countMap.containsKey(str)){
                        int count = countMap.get(str) + 1;
                        int sum = map.get(str);
                        if(count > sum){
                            String temp = "";
                            for(; j < begin && !temp.equals(str); j += wordLen){
                                temp = s.substring(j,j + wordLen);
                                if(temp.equals(str)){
                                    j = j + wordLen;
                                    k = (begin - j ) / wordLen + 1;
                                    break;
                                }else{
                                    countMap.put(temp,countMap.get(temp) - 1);
                                }
                            }
                            break;
                        }else{
                            countMap.put(str,count);
                            k++;
                            begin += wordLen;
                        }
                    }else{
                        clearMap(countMap);
                        j = begin + wordLen;
                        k = 0;
                        break;
                    }
                }
                if(k == words.length){
                    rs.add(j);
                    String temp = s.substring(j,j+wordLen);
                    j += wordLen;
                    k--;
                    countMap.put(temp,countMap.get(temp) -1);
                }
            }
            clearMap(countMap);
        }

        return rs;
    }

    public static void main(String[] args){
        String[] words = {"word","good","best","word"};

        new LeetCode30().findSubstring("wordgoodgoodgoodbestword",
                words);
    }
}
