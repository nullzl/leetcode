package com.nullzl.interview;

import java.util.*;

public class Interview0401 {

    public boolean findWhetherExistsPath1(int n, int[][] graph, int start, int target) {
        if(0 == n)
            return false;
        if(start == target)
            return true;

        Arrays.sort(graph,(p1,p2) -> {
            return p1[0] - p2[0];
        });

        int[] nodes = new int[n];
        int[] count = new int[n];
        boolean[] map = new boolean[n];
        for(int i = graph.length - 1 ; i >= 0 ; i--){
            nodes[graph[i][0]] = i;
            count[graph[i][0]]++;
        }

        LinkedList<Integer> queue = new LinkedList<>();
        queue.offer(start);
        map[start] = true;

        while(!queue.isEmpty()){
            int node = queue.poll();
            for(int i = 0 ; i < count[node] ; i++){
                int to = graph[i + nodes[node]][1];
                if(to == target)
                    return true;
                if(!map[to]){
                    queue.offer(to);
                }
            }
        }

        return false;
    }

    public boolean dfs(boolean[] visited, int n, HashMap<Integer,List<int[]>> edges, int start, int target){
        if(start == target)
            return true;
        List<int[]> list = edges.getOrDefault(start,null);
        if(null == list)
            return false;
        for (int[] edge : list) {
            if (visited[edge[1]])
                continue;
            visited[edge[1]] = true;
            if (dfs(visited, n, edges, edge[1], target))
                return true;
        }
        return false;
    }

    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        if(0 == n)
            return false;
        if(start == target)
            return true;
        boolean[] visited = new boolean[n];
        visited[start] = true;
        HashMap<Integer,List<int[]>> edges = new HashMap<>();
        for (int[] edge : graph) {
            List<int[]> list = edges.getOrDefault(edge[0], null);
            if(null == list){
                list = new LinkedList<int[]>();
                edges.put(edge[0],list);
            }
            list.add(edge);
        }
        return dfs(visited,n,edges,start,target);
    }
}
