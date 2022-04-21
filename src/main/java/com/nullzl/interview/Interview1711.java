package com.nullzl.interview;

import java.util.ArrayList;
import java.util.HashMap;

public class Interview1711 {

    private int min(ArrayList<Integer> list1,ArrayList<Integer> list2){
        if(list1.get(0) > list2.get(0))
            return min(list2,list1);
        int s = 0 , e = list1.size() - 1;
        while(s <= e){
            int mid = s + ((e - s) >> 1);
            if(list1.get(mid) >= list2.get(0))
                e = mid - 1;
            else
                s = mid + 1;
        }
        s = e;
        int i = 0;
        int min = Integer.MAX_VALUE;
        while(s < list1.size() && i < list2.size()){
            min = Math.min(min,list2.get(i) - list1.get(s));
            i++;
            s++;
            if(s < list1.size()){
                while(i < list2.size() && list2.get(i) <= list1.get(s)) i++;
                min = Math.min(min,list1.get(s) - list2.get(i - 1));
            }
            while(s < list1.size() && i < list2.size() && list1.get(s) <= list2.get(i)) s++;
            s--;
        }
        return min;
    }

    public int findClosest(String[] words, String word1, String word2) {
        HashMap<String, ArrayList<Integer>> map = new HashMap<>();

        for(int i = 0 ; i < words.length ; i++){
            ArrayList<Integer> list = map.getOrDefault(words[i],null);
            if(null == list){
                list = new ArrayList<>();
                map.put(words[i],list);
            }
            list.add(i);
        }

        ArrayList<Integer> list1 = map.getOrDefault(word1,null);
        ArrayList<Integer> list2 = map.getOrDefault(word2,null);
        if(null == list1 || null == list2)
            throw new IllegalArgumentException();

        if(list1.get(list1.size() - 1) < list2.get(0))
            return list2.get(0) - list1.get(list1.size() - 1);
        else if(list2.get(list2.size() - 1) < list1.get(0))
            return list1.get(0) - list2.get(list2.size() - 1);
        return min(list1,list2);
    }
}
