package main.java.com.nullzl.leetcode300;

import java.util.*;

public class LeetCode207 {

    private boolean dfs(int v,HashMap<Integer,List<Integer>> edges,
                        HashSet<Integer> viewed,HashSet<Integer> finished){
        if(viewed.contains(v))
            return false;
        if(finished.contains(v))
            return true;

        viewed.add(v);
        List<Integer> list = edges.get(v);
        if(null == list){
            viewed.remove(v);
            finished.add(v);
            return true;
        }
        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()){
            if(!dfs(iterator.next(),edges,viewed,finished))
                return false;
        }
        viewed.remove(v);
        finished.add(v);
        return true;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        if(0 == numCourses)
            return true;

        HashMap<Integer, List<Integer>> edges = new HashMap<>();
        HashSet<Integer> viewed = new HashSet<>();
        HashSet<Integer> finished = new HashSet<>();

        for(int i = 0 ; i < prerequisites.length ; i++){
            List<Integer> list = edges.get(prerequisites[i][0]);
            if(null == list){
                list = new LinkedList<>();
                edges.put(prerequisites[i][0],list);
            }
            list.add(prerequisites[i][1]);
        }

        for(int i = 0 ; i < numCourses ; i++){
            if(!dfs(i,edges,viewed,finished))
                return false;
        }
        return true;
    }
}
