package com.nullzl.LeetCode1300;

import java.util.Arrays;

public class LeetCode1235 {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {

        Integer[] jobs = new Integer[startTime.length];
        for(int i = 0 ; i < startTime.length ; i++)
            jobs[i] = i;
        Arrays.sort(jobs,(op1,op2) ->{
            return endTime[op1] - endTime[op2];
        });

        int[] et = new int[startTime.length + 1];
        int[] ps = new int[startTime.length + 1];
        int size = 1;
        et[0] = 0;
        ps[0] = 0;

        for(int j : jobs){
            int s = startTime[j];
            int e = endTime[j];
            int p = profit[j];

            int index = Arrays.binarySearch(et,0,size,s);
            if(index < 0)
                index = -index - 2;

            p += ps[index];
            if(p > ps[size - 1]){
                if(et[size - 1] == e){
                    ps[size - 1] = p;
                }else{
                    et[size] = e;
                    ps[size++] = p;
                }
            }
        }
        return ps[size - 1];
    }

    public static void main(String[] args){
        LeetCode1235 l = new LeetCode1235();
        l.jobScheduling(
                new int[]{1,2,3,3},
                new int[]{3,4,5,6},
                new int[]{50,10,40,70}
        );
    }
}
