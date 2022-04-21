package com.nullzl.interview;

import java.util.HashMap;

public class Interview1602 {

    class WordsFrequency {

        private HashMap<String,Integer> map;

        public WordsFrequency(String[] book) {
            map = new HashMap<>(book.length);
            if(null == book)
                return ;
            for(String s : book){
                int count = map.getOrDefault(s,0);
                count++;
                map.put(s,count);
            }
        }

        public int get(String word) {
            return map.getOrDefault(word,0);
        }
    }
}
