package com.nullzl.leetcode100;

import java.util.ArrayList;
import java.util.Iterator;

public class LeetCode56 {

    private int partition(int[][] intervals,int start ,int end){
        int pos = start - 1;
        for(int i = start ; i < end ; i++){
            if(intervals[i][0] <= intervals[end][0]){
                if(++pos != i){
                    int[] temp = intervals[i];
                    intervals[i] = intervals[pos];
                    intervals[pos] = temp;
                }
            }
        }
        if(++pos != end){
            int[] temp = intervals[end];
            intervals[end] = intervals[pos];
            intervals[pos] = temp;
        }
        return pos;
    }
    private void quickSort(int[][] intervals,int start,int end){
        if(start < end){
            int pos = partition(intervals,start,end);
            quickSort(intervals,start,pos - 1);
            quickSort(intervals,pos + 1,end);
        }
    }
    public int[][] merge(int[][] intervals) {
        if(null == intervals || 0 == intervals.length || null == intervals[0])
            return new int[0][0];
        quickSort(intervals,0,intervals.length - 1);
        ArrayList<int[]> list = new ArrayList<int[]>(intervals.length);
        int min = intervals[0][0];
        int max = intervals[0][1];
        for(int i = 1 ; i < intervals.length ; i++){
            if(intervals[i][0] > max){
                int[] item = new int[2];
                item[0] = min;
                item[1] = max;
                list.add(item);
                min = intervals[i][0];
                max = intervals[i][1];
            }else if(intervals[i][1] > max){
                max = intervals[i][1];
            }
        }
        int[] item = new int[2];
        item[0] = min;
        item[1] = max;
        list.add(item);
        int[][] rs = new int[list.size()][2];
        int index = 0;
        Iterator<int[]> iterator = list.iterator();
        while(iterator.hasNext()){
            rs[index++] = iterator.next();
        }
        return rs;
    }
}
