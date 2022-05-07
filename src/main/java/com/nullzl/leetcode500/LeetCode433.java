package com.nullzl.leetcode500;

import java.util.HashMap;
import java.util.LinkedList;

public class LeetCode433 {

    private int add(String s,HashMap<String,Integer> map,int[][] edges,int idx){
        int i,j;
        if(map.containsKey(s)){
            i = map.get(s);
        }else{
            map.put(s,idx);
            i = idx++;
        }
        StringBuilder chs = new StringBuilder(s);
        for(int k = 0; k < chs.length(); k++){
            char ch = chs.charAt(k);
            chs.setCharAt(k,'*');
            String t = chs.toString();
            if(map.containsKey(t)){
                j = map.get(t);
            }else{
                map.put(t,idx);
                j = idx++;
            }
            edges[i][j] = 1;
            edges[j][i] = 1;
            chs.setCharAt(k,ch);
        }
        return idx;
    }

    private int[][] build(String start,String[] bank,HashMap<String,Integer> map){
        int idx = 0;
        int[][] edges = new int[(bank.length + 1) * (start.length() + 1)][(bank.length + 1) * (start.length() + 1)];
        idx = add(start,map,edges,idx);
        for(String b : bank){
            idx = add(b,map,edges,idx);
        }
        return edges;
    }

    public int minMutation(String start, String end, String[] bank) {

        HashMap<String,Integer> map = new HashMap<>();
        int[][] edges = build(start,bank,map);
        if(!map.containsKey(end))
            return -1;

        boolean[] visited = new boolean[edges.length];
        int[] len = new int[edges.length];
        LinkedList<Integer> queue = new LinkedList<>();
        int idx = map.get(start);
        queue.offer(idx);
        visited[idx] = true;
        len[idx] = 0;
        int eidx = map.get(end);
        while(!queue.isEmpty()){
            idx = queue.poll();
            for(int j = 0 ; j < edges[idx].length ; j++){
                if(1 == edges[idx][j] && !visited[j]){
                    visited[j] = true;
                    len[j] = len[idx] + 1;
                    queue.offer(j);
                    if(eidx == j)
                        return len[j] >> 1;
                }
            }
        }
        return -1;
    }
}
