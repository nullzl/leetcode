package com.nullzl.leetcode500;

import java.util.Arrays;
import java.util.Comparator;

public class LeetCode436 {

    class Interval{
        public int index;
        public int[] pos;

        public Interval(int i,int[] p){
            this.index = i;
            this.pos = p;
        }
    }

    public int[] findRightInterval(int[][] intervals) {

        if(null == intervals || 0 == intervals.length)
            return new int[0];

        Interval[] tmp = new Interval[intervals.length];
        int[] rs = new int[intervals.length];
        Arrays.fill(rs,-1);
        Comparator<Interval> comparator = new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.pos[0] - o2.pos[0];
            }
        };
        for(int i = 0 ;i < intervals.length ; i++){
            tmp[i] = new Interval(i,intervals[i]);
        }
        Arrays.sort(tmp,comparator);

        for(int i = 0 ; i < intervals.length ; i++){
            int v = Arrays.binarySearch(tmp,i + 1,intervals.length,
                    new Interval(-1,new int[]{tmp[i].pos[1],0}),comparator);
            v = v < 0 ? -v-1 : v;
            if(v != intervals.length){
                rs[tmp[i].index] = tmp[v].index;
            }
        }
        return rs;
    }
}
