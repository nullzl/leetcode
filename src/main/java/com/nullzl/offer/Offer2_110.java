package com.nullzl.offer;

import java.util.LinkedList;
import java.util.List;

public class Offer2_110 {

    List<List<Integer>> rs = new LinkedList<List<Integer>>();
    List<List<Integer>>[] pathes;

    private List<List<Integer>> dfs(int[][] graph,int n){
        List<List<Integer>> rs = new LinkedList<>();
        if(n == graph.length - 1){
            LinkedList<Integer> list = new LinkedList<>();
            list.add(n);
            rs.add(list);
            return rs;
        }
        if(null != pathes[n])
            return pathes[n];

        if(null == graph[n] || 0 == graph[n].length)
            return rs;
        for(int j = 0 ; j < graph[n].length ; j++){
            List<List<Integer>> lists = dfs(graph,graph[n][j]);
            for(List<Integer> list : lists){
                LinkedList<Integer> temp = new LinkedList<>();
                temp.add(n);
                temp.addAll(list);
                rs.add(temp);
            }
        }
        pathes[n] = rs;
        return pathes[n];
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        pathes = new LinkedList[graph.length];
        return dfs(graph,0);
    }
}
