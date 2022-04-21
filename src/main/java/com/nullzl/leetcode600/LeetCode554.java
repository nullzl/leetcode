package com.nullzl.leetcode600;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class LeetCode554 {

    public int leastBricks(List<List<Integer>> wall) {
        long sum = wall.get(0).stream().mapToLong(v -> v).sum();
        HashMap<Long,Integer> map = new HashMap<>();
        Iterator<List<Integer>> listIterator = wall.iterator();
        int count = 0;
        while(listIterator.hasNext()){
            Iterator<Integer> iterator = listIterator.next().iterator();
            long tmp = 0;
            while(iterator.hasNext()){
                tmp += iterator.next();
                int c = map.getOrDefault(tmp,0) + 1;
                map.put(tmp,c);
                count = tmp != sum ? Math.max(count,c) : count;
            }
        }
        return wall.size() - count;


    }
}
