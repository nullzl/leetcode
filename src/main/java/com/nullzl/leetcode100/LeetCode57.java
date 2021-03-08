package com.nullzl.leetcode100;

public class LeetCode57 {

    private int find(int[][] intervals,int[] newInterval,int start,int end){
        if(end < start){
            return start;
        }
        int mid = ((start + end) >> 1);
        if(intervals[mid][0] == newInterval[0])
            return mid;
        else if(intervals[mid][0] > newInterval[0]){
            return find(intervals,newInterval,start,mid - 1);
        }else{
            return find(intervals,newInterval,mid + 1,end);
        }
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(null == intervals || 0 == intervals.length){
            if(null == newInterval || 2 != newInterval.length)
                return new int[0][0];
            int[][] rs = new int[1][2];
            rs[0] = newInterval;
            return rs;
        }
        int pos = find(intervals,newInterval,0,intervals.length - 1);
        int count = 0;
        int min = newInterval[0];
        int max = newInterval[1];
        if(pos -1 >= 0 && intervals[pos - 1][1] >= min){
            pos--;
            min = intervals[pos][0];
            max = intervals[pos][1] > max ? intervals[pos][1] : max;
        }
        for(int i = pos ; i < intervals.length ; i++){
            if(intervals[i][0] > max){
                break;
            }else if(intervals[i][1] > max){
                max = newInterval[1];
            }
            count++;
        }
        int[][] rs = new int[intervals.length - count + 1][2];
        int index = 0;
        for(int i = 0 ; i < pos ; i++,index++){
            rs[index][0] = intervals[i][0];
            rs[index][1] = intervals[i][1];
        }
        rs[index][0] = min;
        rs[index][1] = max;
        index++;
        for(int i = pos + count ; i < intervals.length ; i++,index++){
            rs[index][0] = intervals[i][0];
            rs[index][1] = intervals[i][1];
        }
        return rs;
    }
}
