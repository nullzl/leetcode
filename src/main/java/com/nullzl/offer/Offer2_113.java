package com.nullzl.offer;

import java.util.HashSet;
import java.util.Iterator;

public class Offer2_113 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        int[] rs = new int[numCourses];
        int idx = 0;
        int cur = 0;

        HashSet<Integer>[] edges = new HashSet[numCourses];
        for(int i = 0 ; i < edges.length ; i++)
            edges[i] = new HashSet<>();
        int[] count = new int[numCourses];

        for(int[] edge : prerequisites){
            if(!edges[edge[1]].contains(edge[0])){
                count[edge[0]]++;
                edges[edge[1]].add(edge[0]);
            }
        }

        for(int i = 0 ; i < count.length; i++)
            if(0 == count[i])
                rs[idx++] = i;

        while(cur < idx && idx < numCourses){
            int s = rs[cur++];

            Iterator<Integer> iterator = edges[s].iterator();
            while(iterator.hasNext()){
                int e = iterator.next();
                if(0 == --count[e]){
                    rs[idx++] = e;
                }
            }
        }
        if(idx != numCourses)
            return new int[0];
        return rs;

    }
}
