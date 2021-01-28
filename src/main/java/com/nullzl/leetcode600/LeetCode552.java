package com.nullzl.leetcode600;

import java.util.Arrays;

public class LeetCode552 {



    public int checkRecord(int n) {
        if(1 == n)
            return 3;
        if(2 == n)
            return 8;

        long[] dp0 = new long[]{0,1,1,1,1,1};
        long[] dp1 = new long[]{0,2,2,3,2,3};
        long[] tmp = new long[6];
        long mod = 1000000007;
        //0 A0 | 1 A1 | 2 L0 | 3 L1 | 4 P0 | 5 P1
        //dp[i][A0] = 0
        //dp[i][A1] = dp[i-1][P0] + dp[i-1][L0]
        //dp[i][L0] = dp[i-1][P0] + dp[i-2][P0]
        //dp[i][L1] = dp[i-1][P1] + dp[i-1][A1] + dp[i-2][P1] + dp[i-2][A1]
        //dp[i][P0] = dp[i-1][P0] + dp[i-1][L0]
        //dp[i][p1] = dp[i-1][P1] + dp[i-1][L1] + dp[i-1][A1]
        for(int i = 3; i <= n ; i++){
            Arrays.fill(tmp,0);
            tmp[1] = (dp1[4] + dp1[2]) % mod;
            tmp[2] = (dp1[4] + dp0[4]) % mod;
            tmp[3] = (dp1[5] + dp1[1]  + dp0[5] + dp0[1]) % mod;
            tmp[4] = (dp1[4] + dp1[2]) % mod;
            tmp[5] = (dp1[5] + dp1[3] + dp1[1]) % mod;

            System.arraycopy(dp1,0,dp0,0,dp1.length);
            System.arraycopy(tmp,0,dp1,0,dp1.length);
        }
        return (int)((dp1[1] + dp1[3]+ dp1[5]) % mod);
    }

    public static void main(String[] args){
        System.out.print(new LeetCode552().checkRecord(10));
    }
}
