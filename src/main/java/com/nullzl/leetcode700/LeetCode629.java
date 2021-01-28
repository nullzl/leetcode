package com.nullzl.leetcode700;

public class LeetCode629 {

    //i个数，k个逆序对的数量可由i-1个数，k个逆序对，k-1个逆序对,...,k-i+1个逆序对的排列产生
    //dp[i][k] = dp[i-1][k] + dp[i-1][k-1]+...+dp[i-1][k-i+1]
    //dp[i][k-1] = dp[i-1][k-1]+dp[i-1][k-2]+...dp[i-1][k-i]
    //可得dp[i][k] = dp[i-1][k] + dp[i][k-1] - dp[i-1][k-i],
    public int kInversePairs(int n, int k) {
        int[] count= new int[k + 1];
        int[] tmp = new int[k + 1];
        count[0] = 1;
        for(int i = 2 ; i <= n ; i++){
            tmp[0] = 1;
            for(int j = 1 ; j <= k ; j++){
                tmp[j] = (count[j] + tmp[j-1] - (j - i < 0 ? 0 : count[j - i])) % 1000000007;
                tmp[j] = (tmp[j] < 0) ? tmp[j] + 1000000007 : tmp[j];
            }
            int[] t = count;
            count = tmp;
            tmp = t;
        }
        return count[k];
    }


    //对于每个数，其逆序对可由n-1的逆序对推出
    //对于n-1的k个逆序对的每个排列，可分别产生k个、k+1、...k+n-1逆序对的排列各一个
    public int kInversePairs1(int n, int k) {
        int len = k;
        int[] count = new int[len + 1];
        count[0] = 1;
        for(int i = 2 ; i <= n ; i++){
            int[] tmp = new int[len + 1];
            for(int j = 0 ; j < count.length ; j++){
                if(0 == count[j])
                    continue;

                for(int x = 0 ; x < i && x + j <= len ;x++){
                    tmp[x + j] = (tmp[x + j] + count[j]) % 1000000007;
                }
            }
            count = tmp;
        }
        return count[k];
    }
}
