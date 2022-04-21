package com.nullzl.offer;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Offer38 {

    List<String> list = new LinkedList<>();

    public void traverse(char[] str,int k,char[] chs,int[] count,int size){
        if(k == str.length){
            list.add(new String(str));
            return ;
        }
        for(int i = 0 ; i < size ; i++){
            if(0 == count[i])
                continue;
            str[k] = chs[i];
            count[i]--;
            traverse(str,k + 1,chs,count,size);
            count[i]++;
        }
    }

    public String[] permutation(String s) {
        if(null == s)
            return new String[0];

        char[] chs = new char[s.length()];
        int[] count = new int[s.length()];
        int size = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0 ; i < s.length() ; i++){
            int index = map.getOrDefault(s.charAt(i),-1);
            if(-1 == index){
                index = size++;
                chs[index] = s.charAt(i);
                map.put(s.charAt(i),index);
            }
            count[index]++;
        }
        char[] str = new char[s.length()];
        traverse(str,0,chs,count,size);
        return list.toArray(new String[0]);
    }
}
