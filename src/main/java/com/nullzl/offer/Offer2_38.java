package com.nullzl.offer;

import com.nullzl.util.Util;

import java.util.LinkedList;

public class Offer2_38 {

    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        LinkedList<Integer> stk = new LinkedList<>();
        for(int i = 0 ; i < temperatures.length ; i++){
            while(!stk.isEmpty() && temperatures[stk.peek()] < temperatures[i]){
                int j = stk.pop();
                ans[j] = i - j;
            }
            stk.push(i);
        }
        return ans;
    }
    public  static void main(String[] args){
        System.out.println(Util.generateRandomArray(10000,30,100));
    }
}
