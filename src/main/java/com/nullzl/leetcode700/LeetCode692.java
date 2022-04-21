package com.nullzl.leetcode700;

import java.util.*;

public class LeetCode692 {

    class Word implements Comparable<Word>{
        private String word;
        private int count;
        public Word(String w,int c){
            word = w;
            count = c;
        }

        @Override
        public int compareTo(Word w) {
            if(count > w.count)
                return -1;
            if(count < w.count)
                return 1;
            return word.compareTo(w.word);
        }
    }



    private void partition(Word[] words,int s,int e,int k){
        if(s >= e)
            return ;
        Word tmp = words[s];
        int i = s, j = e;
        while(i < j){
            while(i < j && tmp.compareTo(words[j]) < 0) j--;
            words[i] = words[j];
            while(i < j && tmp.compareTo(words[i]) >= 0) i++;
            words[j] = words[i];
        }
        words[i] = tmp;
        if(i == k)
            return ;
        if(i < k)
            partition(words,i + 1,e,k);
        else
            partition(words,s,i-1,k);
    }

    public List<String> topKFrequent(String[] words, int k) {

        HashMap<String,Integer> map= new HashMap<>();
        for(String w : words){
            int count = map.getOrDefault(w,0);
            map.put(w,count + 1);
        }
        Word[] ws = new Word[map.size()];
        int i = 0;
        Iterator<Map.Entry<String,Integer>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<String,Integer> entry = iterator.next();
            ws[i++] = new Word(entry.getKey(),entry.getValue());
        }
        partition(ws,0,ws.length - 1,k-1);
        Arrays.sort(ws,0,k);
        List<String> ans = new ArrayList<>(k);
        for(i = 0 ; i < k ; i++)
            ans.add(ws[i].word);
        return ans;
    }
}
