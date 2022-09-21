package com.nullzl.leetcode400;
import java.util.*;

public class LeetCode332 {

    private void dfs(List<String> ans,HashMap<String,PriorityQueue<String>> edges,String city){
        PriorityQueue<String> heap = edges.get(city);
        while(null != heap && !heap.isEmpty()){
            dfs(ans,edges,heap.poll());
        }
        ans.add(city);
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String, PriorityQueue<String>> edges = new HashMap<>();
        for(List<String> t : tickets){
            String start = t.get(0);
            String end = t.get(1);
            PriorityQueue<String> cities = edges.get(start);
            if(null == cities){
                cities = new PriorityQueue<>();
                edges.put(start,cities);
            }
            cities.offer(end);
        }
        List<String> ans = new ArrayList<>();
        dfs(ans,edges,"JFK");
        Collections.reverse(ans);
        return ans;
    }
}
