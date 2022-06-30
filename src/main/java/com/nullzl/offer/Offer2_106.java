package com.nullzl.offer;

import java.util.LinkedList;

public class Offer2_106 {

    private boolean visit(boolean[] visited,int[] set,int s,int v,LinkedList<Integer> queue ){
        if(visited[v])
            return set[v] != s;
        queue.offer(v);
        set[v] = (s + 1) % 2;
        visited[v] = true;
        return true;
    }

    public boolean isBipartite(int[][] graph) {

        boolean[] visited = new boolean[graph.length];
        int[] set = new int[graph.length];
        boolean rs = true;
        for(int i = 0 ; i < graph.length && rs ; i++){
            LinkedList<Integer> queue = new LinkedList<>();
            visited[i] = true;
            queue.offer(i);
            while(!queue.isEmpty() && rs){
                int v = queue.poll();
                int s = set[v];
                for(int j = 0 ; j < graph[v].length && rs ; j++)
                    rs = visit(visited,set,s,graph[v][j],queue);
            }
        }
        return rs;
    }
}
