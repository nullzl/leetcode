package com.nullzl.leetcode200;

public class LeetCode134 {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        return 0;
    }

    public int canCompleteCircuit1(int[] gas, int[] cost) {

        if(null == gas || null == cost || 0 == gas.length || 0 == cost.length ||
                gas.length != cost.length)
            return -1;

        int[] left = new int[gas.length];
        for(int i = 0 ;i < gas.length;i++){
            left[i] = gas[i] - cost[i];
        }

        int need = 0;
        int sum = 0;
        int start = 0;
        for(int i = 0 ; i < gas.length ; i++){
            sum += left[i];
            if(sum < 0){
                need -= sum;
                sum = 0;
                start = i + 1;
            }
        }
        if(start >= gas.length)
            return -1;

        if(sum < need)
            return -1;

        return start;
    }

    public static void main(String[] args){
        int[] gas = {2,3,4};
        int[] cost = {3,4,3};

        System.out.println(new LeetCode134().canCompleteCircuit(gas,cost));
    }
}
