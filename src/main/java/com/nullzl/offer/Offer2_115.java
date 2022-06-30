package com.nullzl.offer;

import java.util.*;

public class Offer2_115 {

    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {

        int n = org.length;
        int[] count = new int[n + 1];

        HashSet<Integer>[] edges = new HashSet[n + 1];
        for(int i = 1 ; i <= n ; i++)
            edges[i] = new HashSet<>();
        if(null == seqs || 0 == seqs.size())
            return false;

        for(List<Integer> list : seqs){
            if(null == list || 0 == list.size())
                continue;

            Iterator<Integer> iterator = list.iterator();
            int prev = iterator.next();
            if(prev > n || prev <= 0)
                return false;
            while(iterator.hasNext()){
                int cur = iterator.next();
                if(cur > n || cur <= 0)
                    return false;
                if(!edges[prev].contains(cur)){
                    count[cur]++;
                    edges[prev].add(cur);
                }
                prev = cur;
            }
        }
        int next = 0;
        for(int i = 1 ; i <= n ; i++){
            if(0 != count[i])
                continue;
            if(next != 0)
                return false;
            next = i;
        }

        int idx = 0;
        while(0 != next && idx < org.length){
            int cur = next;
            if(cur != org[idx++])
                return false;
            next = 0;
            Iterator<Integer> iterator = edges[cur].iterator();
            while(iterator.hasNext()){
                int t = iterator.next();
                count[t]--;

                if(0 == count[t]){
                    if(next != 0)
                        return false;
                    next = t;
                }
            }
        }
        return idx == org.length;
    }
}
