package com.nullzl.leetcode500;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class LeetCode403 {

    class Pair{
        public int pos;
        public int step;
        public Pair(int p,int s){
            this.pos = p;
            this.step = s;
        }
    }

    private boolean cross(HashMap<Integer,Integer> map,boolean[][] crossed,Queue<Pair> queue,int target,int pos,int step){
        if(step <= 0)
            return false;
        pos += step;
        if(pos == target)
            return true;
        if(pos > target)
            return false;
        int index = map.getOrDefault(pos,-1);
        if(-1 != index && !crossed[index][step]){
            crossed[index][step] = true;
            int maxStep = crossed.length - 1 - index;
            long tmp = (long)pos + (long)maxStep * step + ((1L + maxStep) * maxStep) / 2;
            if(target <= tmp)
                queue.offer(new Pair(pos,step));
        }
        return false;
    }

    public boolean canCross(int[] stones) {
        int target = stones[stones.length - 1];
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ; i < stones.length ; i++)
            map.put(stones[i],i);
        boolean[][] crossed = new boolean[stones.length][stones.length];
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(stones[0],0));
        crossed[0][0] = true;
        while(!queue.isEmpty()){
            Pair p = queue.poll();
            if(cross(map,crossed,queue,target,p.pos,p.step - 1)
            || cross(map,crossed,queue,target,p.pos,p.step )
            || cross(map,crossed,queue,target,p.pos,p.step + 1)){
                return true;
            }
        }
        return false;
    }

    public  static void main(String[] args){
        System.out.println(new LeetCode403().canCross(new int[]{
                0,1,2,3,4,8,9,11
        }));
    }
}
