package com.nullzl.leetcode700;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class LeetCode638 {

    private boolean canUse(List<Integer> needs,Integer[] arr){
        Iterator<Integer> iterator = needs.iterator();
        int i = 0;
        while(iterator.hasNext()){
            if(iterator.next() < arr[i++])
                return false;
        }
        return true;
    }

    private int minus(int[] nums,int op1,int op2){
        int left = 0;
        for(int i = 1; i < nums.length;i++){
            int o1 = op1 / nums[i];
            op1 = op1 % nums[i];
            int o2 = op2 / nums[i];
            op2 = op2 % nums[i];
            if(o1 < o2)
                return -1;
            left += (o1 - o2) * nums[i];
        }
        return left;
    }

    //完全背包问题 多维约束转一维约束
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {

        if(null == needs || 0 == needs.size() || null == price || 0 == price.size() || needs.size() != price.size())
            return 0;


        int[] nums = new int[needs.size() + 1];
        Iterator<Integer> iterator = needs.iterator();
        int i = 0 ;
        while(iterator.hasNext())
            nums[i++] = (iterator.next() + 1);
        nums[i] = 1;
        for(i = nums.length - 3 ; i >= 0 ; i--){
            nums[i] *= nums[i + 1];
        }
        //转换目标
        int target = nums[0];

        int[] costs = new int[price.size() + ((null == special) ? 0 : special.size())];
        int[] ps = new int[costs.length];
        int size = 0;
        //转换物品
        i = 1;
        iterator = price.iterator();
        while(iterator.hasNext()){
            int p = iterator.next();
            if(needs.get(i-1) < 1){
                i++;
                continue;
            }
            costs[size] = nums[i++];
            ps[size++] = p;
        }
        if(null != special){
            Iterator<List<Integer>> listIterator = special.iterator();
            while(listIterator.hasNext()){
                Integer[] arr = listIterator.next().toArray(new Integer[0]);
                if(!canUse(needs,arr))
                    continue;
                int cost = 0;
                for(i = 0 ; i < arr.length - 1; i++){
                    cost += (arr[i] * nums[i + 1]);
                }
                costs[size] = cost;
                ps[size++] = arr[arr.length - 1];
            }
        }
        //target表示目标空间   costs每个物品所占空间   ps表示每个物品的价值
        int[] dp = new int[target];
        Arrays.fill(dp,-1);
        dp[0] = 0;

        for(i = 0 ; i < size ; i++){

            for(int j = costs[i] ; j < target ; j++){
                int left = minus(nums,j,costs[i]);
                if(-1 == left || -1 == dp[left])
                    continue;
                int tmp = dp[left] + ps[i];
                if(-1 == dp[j] || dp[j] > tmp)
                    dp[j] = tmp;
            }
        }
        return dp[target - 1];
    }

    public  static void main(String[] args){
        Random r = new Random();
        int len = r.nextInt(6) + 1;
        int[] prices = new int[len];
        for(int i = 0 ; i < len ; i++){
            prices[i] = r.nextInt(100) + 1;
        }

        int len2 = r.nextInt(100) + 1;
        int[][] spec = new int[len2][len + 1];
        for(int i = 0 ; i < len2; i++){
            int ps = 0;
            for(int j = 0 ; j < len ; j++){
                spec[i][j] = r.nextInt(3);
                ps += spec[i][j] * prices[j];
            }
            ps -= r.nextInt(ps + 1);
            spec[i][len] = ps;
        }

        int[] needs = new int[len];
        for(int i = 0 ;i < len ; i++)
            needs[i] = r.nextInt(4) + 3;

        System.out.print("[" + prices[0]);
        for(int i = 1; i < len ; i++)
            System.out.print("," + prices[i]);
        System.out.println("]");
        System.out.print("[[" + spec[0][0]);
        for(int i = 1; i <= len ; i++)
            System.out.print("," + spec[0][i]);
        System.out.print("]");
        for(int i = 1; i < len2 ; i++){
            System.out.print(",[" + spec[i][0]);
            for(int j = 1; j <= len ; j++)
                System.out.print("," + spec[i][j]);
            System.out.print("]");
        }
        System.out.println("]");

        System.out.print("[" + needs[0]);
        for(int i = 1; i < len ; i++)
            System.out.print("," + needs[i]);
        System.out.println("]");

    }


}
