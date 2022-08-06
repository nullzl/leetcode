package com.nullzl.leetcode1100;

import com.nullzl.util.Util;

import java.util.Random;

public class LeetCode1052 {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int[] sum = new int[customers.length];
        sum[0] = customers[0] * grumpy[0];
        int total = customers[0];
        for(int i = 1 ;i < customers.length ; i++){
            sum[i] = sum[i-1] + grumpy[i] * customers[i];
            total += customers[i];
        }

        int max = sum[minutes - 1];
        for(int i = minutes ; i < sum.length ; i++){
            max = Math.max(max,sum[i] - sum[i - minutes]);
        }
        return total - (sum[sum.length - 1] - max);
    }

    public int maxSatisfied1(int[] customers, int[] grumpy, int X) {

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
        System.out.println(s + "\n" +  s2 + "\n" + r.nextInt(len + 1));
    }
}
