package com.nullzl.leetcode600;

public class LeetCode547 {

    private void dfs(int s,boolean[] visited , int[][] edges){
        if(visited[s])
            return ;
        visited[s] = true;
        for(int i = 0 ; i < edges[s].length ; i++){
            if(1 == edges[s][i]){
                dfs(i,visited,edges);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {

        boolean[] visited = new boolean[isConnected.length];
        int count = 0;
        for(int i = 0 ; i < isConnected.length ; i++){
            if(!visited[i]){
                count++;
                dfs(i,visited,isConnected);
            }
        }
        return count;
    }
}
