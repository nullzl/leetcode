package com.nullzl.leetcode1400;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class LeetCode1353 {

    public int maxEvents(int[][] events) {
        int MAX = 100001;
        List<Integer>[] map = new List[MAX];
        int day = Integer.MAX_VALUE;
        int max = 0;
        for(int i = 0 ; i < events.length ; i++){
            int[] event = events[i];
            day = Math.min(day,event[0]);
            max = Math.max(max,event[1]);
            List<Integer> list = map[event[0]];
            if(null == list){
                list = new ArrayList<>();
                map[event[0]] = list;
            }
            list.add(i);
        }
        PriorityQueue<int[]> heap = new PriorityQueue<>((o1,o2) ->{
            return Integer.compare(o1[1],o2[1]);
        });
        int count = 0;
        while(day <= max){
            //加入到期的会议
            if(null != map[day]){
                for(int i : map[day])
                    heap.offer(events[i]);
            }
            //选取结束时间最早的会议
            if(!heap.isEmpty()){
                count++;
                heap.poll();
            }
            day++;
            //移除已过期的会议
            while(!heap.isEmpty() && heap.peek()[1] < day)
                heap.poll();
        }
        return count;
    }
}
