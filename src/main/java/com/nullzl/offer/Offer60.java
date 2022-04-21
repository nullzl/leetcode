package com.nullzl.offer;

public class Offer60 {

    public void dfs(int[] count,int sum,int k,int n){
        if(k == n){
            count[sum]++;
            return;
        }
        for(int i = 1; i <= 6; i++){
            dfs(count,sum + i, k + 1,n);
        }
    }

    public double[] dicesProbability1(int n) {

        if(n < 1)
            return new double[]{0};

        int[] count = new int[n * 6 + 1];
        dfs(count,0,0,n);
        double sum = Math.pow(6,n);
        double[] rs = new double[5 * n + 1];
        for(int i = 0 ; i < rs.length ; i++){
            rs[i] = count[i + n] / sum;
        }
        return rs;
    }

    //动态规划
    public double[] dicesProbability(int n) {
        int[] count = new int[n * 6 + 1];
        count[0] = 1;

        for(int i = 1 ; i <= n ; i++){
            int max = i * 6;
            int min =  i;
            for(int j = max ; j >= min ; j--){
                count[j] = 0;
                for(int k = 6 ; k <= 6 && j - k >= i - 1 ; k--)
                    count[j] += count[j - k];
            }
        }
        double sum = Math.pow(6,n);
        double[] rs = new double[5 * n + 1];
        for(int i = 0 ; i < rs.length ; i++){
            rs[i] = count[i + n] / sum;
        }
        return rs;
    }
}
