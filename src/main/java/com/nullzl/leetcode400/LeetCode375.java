package com.nullzl.leetcode400;

public class LeetCode375 {

    private int getAmount(int[][] amount,int i,int j){
        if(i >= j)
            return 0;
        if(0 != amount[i][j])
            return amount[i][j];

        int k = i + ((j - i) >> 1);
        int min = Integer.MAX_VALUE;
        int tmp;
        while(k <= j){
            tmp = k + Math.max(getAmount(amount,i,k-1),getAmount(amount,k + 1,j));
            min = Math.min(min,tmp);
            k++;
        }
        amount[i][j] = min;
        return min;
    }


    public int getMoneyAmount(int n) {


        int[][] amount = new int[n + 1][n + 1];
        return getAmount(amount,1,n);

    }
}
