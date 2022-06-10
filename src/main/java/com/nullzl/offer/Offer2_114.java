package com.nullzl.offer;

public class Offer2_114 {

    public String alienOrder(String[] words) {

        if(null == words || 0 == words.length)
            return "";

        int i = 0;
        int len = 'z' - 'a' + 1;
        boolean[] set = new boolean[len];
        int[] count = new int[len];
        boolean[][] edges = new boolean[len][len];
        for(i = 0 ; i < len ; i++){
            edges[i] = new boolean[len];
        }
        char[][] wds = new char[words.length][];
        i = 0;
        for(String w : words){
            wds[i++] = w.toCharArray();
            for(char ch : wds[i-1]){
                set[ch - 'a'] = true;
            }
        }

        for(i = 0 ; i < wds.length - 1 ; i++){
            int j ;
            for(j = 0 ; j < wds[i].length && j < wds[i+1].length ; j++){
                if(wds[i][j] != wds[i+1][j]){
                    if(!edges[wds[i][j] - 'a'][wds[i+ 1][j] - 'a']) {
                        count[wds[i + 1][j] - 'a']++;
                        edges[wds[i][j] - 'a'][wds[i + 1][j] - 'a'] = true;
                    }
                    break;
                }
            }
            if(wds[i].length > wds[i+1].length && j == wds[i+1].length)
                return "";
        }

        StringBuilder str = new StringBuilder();
        while(true){
            for(i = 0 ; i < len  ; i++)
                if(set[i] && 0 == count[i])
                    break;
            if(i == len)
                break;
            str.append((char)('a' + i));
            set[i] = false;
            for(int j = 0 ; j < len ; j++){
                if(edges[i][j])
                    count[j]--;
            }
        }
        for(i = 0 ; i < len ; i++){
            if(set[i])
                return "";
        }
        return str.toString();
    }
}
