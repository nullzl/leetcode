package com.nullzl.leetcode700;

public class LeetCode650 {


    //实际是求质因子之和
    //给定n，一定是通过复制k次t，来达到n
    //质数t，只能复制之后，粘贴t-1次
    //所以质因子t，只能通过粘贴t-1次来达到，没有更简单的办法


    private int get(int[] dp,int n){
        if(0 != dp[n])
            return dp[n];
        if(1 == n)
            return 0;

        if(0 == (1 & n)) {
            dp[n] = 2 + get(dp,n >> 1);
            return dp[n];
        }

        int max = (int)Math.sqrt(n);
        for(int i = 3; i <= max ; i+= 2){
            if(n % i == 0){
                dp[n] = get(dp,i) + get(dp,n / i);
                return dp[n];
            }
        }
        dp[n] = n;
        return dp[n];
    }


    public int minSteps1(int n) {

        if(1 == n)
            return 0;

        int[] dp = new int[n + 1];
        return get(dp,n);
    }


    public int minSteps(int n){
        int count = 0;
        while(0 == (1 & n)){
            count += 2;
            n >>= 1;
        }
        int f = 3;
        while(n > 1){
            while(0 == n % f){
                count += f;
                n /= f;
            }
            f += 2;
        }
        return count;
    }

    public static void main(String[] args){
        LeetCode650 l = new LeetCode650();
        for(int i = 1 ; i <= 1500 ; i++){
            if(l.minSteps(i) == l.minSteps1(i)){
                System.out.println(i + "\tok" );
            }else{
                System.out.println(i + "\terror" );
                break;
            }
        }
    }
}
