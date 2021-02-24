package com.nullzl.leetcode1100;

import com.nullzl.util.Util;

import java.util.Random;

public class LeetCode1052 {

    public int maxSatisfied(int[] customers, int[] grumpy, int X) {

        int sum = 0;
        int notSatisfiedSum = 0;
        int[] prefixSum = new int[customers.length];
        int i = 0;
        for(; i < X ; i++){
            sum += customers[i];
            if(1 == grumpy[i])
                notSatisfiedSum += customers[i];
            prefixSum[i] = notSatisfiedSum;
        }
        int max = prefixSum[X - 1];

        for(; i < customers.length ; i++){
            sum += customers[i];
            if(1 == grumpy[i])
                notSatisfiedSum += customers[i];
            prefixSum[i] = notSatisfiedSum;
            int temp = prefixSum[i] - prefixSum[i - X];
            if(temp > max)
                max = temp;
        }

        return sum - notSatisfiedSum + max;
    }

    public static void main(String[] args){
        Random r = new Random();
        int len = r.nextInt(20000) + 1;
        String s = Util.generateRandomArray(len , 0 , 1001);
        String s2 = Util.generateRandomArray(len,0,2);
        System.out.println(s + s2 + r.nextInt(len + 1));
    }
}
