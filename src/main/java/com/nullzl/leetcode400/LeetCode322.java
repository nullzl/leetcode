package main.java.com.nullzl.leetcode400;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class LeetCode322 {


    /**
     * 递归算法
     * f(n,amount) = min{f(n-1,amount*i)  i from 0 to k}
     * 优化：剪纸，记录最小数量，已达最小数量的不继续求解
     */
    private int coin(int[] coins,int k,int amount){
        if(k < 0 && amount != 0)
            return -1;
        if(0 == amount)
            return 0;
        int rs = -1;
        int count = 0;
        int temp;
        while(amount >= 0 ){
            temp = coin(coins,k - 1,amount);
            if(-1 != temp){
                rs = Math.min(
                        (-1 == rs ? Integer.MAX_VALUE : rs),
                        temp + count
                );
            }
            count++;
            amount -= coins[k];
        }
        return rs;
    }

    public int coinChange1(int[] coins, int amount) {
        return coin(coins,coins.length - 1,amount);
    }

    /**
     * 动态规划
     * f(amount) = f(amount - coins[i]) i from 0 to k
     * 使用hashmap记录中间过程
     */
    public int coinChange(int[] coins, int amount) {
        int count = 0;
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> tempSet;
        set.add(0);
        Iterator<Integer> iterator = set.iterator();
        while(!set.isEmpty()){
            if(set.contains(amount))
                return count;
            tempSet = new HashSet<>();
            while (iterator.hasNext()){
                int sum = iterator.next();
                iterator.remove();
                for(int i = 0 ; i < coins.length ; i++){
                    if(sum + coins[i] <= amount)
                        tempSet.add(sum + coins[i]);

                }
            }
            count++;
            iterator = tempSet.iterator();
            set = tempSet;
        }
        return -1;
    }
}
