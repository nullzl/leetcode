package com.nullzl.leetcode800;

import java.util.Arrays;

public class LeetCode785 {

    private boolean dfs(int[] visited,int[][] edges,int set,int i){
        set = (set + 1) % 2;
        if(2 != visited[i])
            return visited[i] == set;
        visited[i] = set;
        for(int j : edges[i]){
            if(!dfs(visited,edges,set,j))
                return false;
        }
        return true;
    }

    public boolean isBipartite(int[][] graph) {
        int[] visited = new int[graph.length];
        Arrays.fill(visited,2);
        for(int i = 0 ; i < graph.length ; i++){
            if(2 == visited[i] && !dfs(visited,graph,0,i))
                return false;
        }
        return true;
    }
}
