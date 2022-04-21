package com.nullzl.interview;

public class Interview0814 {

    public int countEval(String s, int result) {
        if(null == s || 0 == s.length())
            return 0;

        char[] arr = s.toCharArray();
        int[][][] dp = new int[s.length()][s.length()][2];
        for(int i = 0 ; i < s.length() ; i++){
            if(arr[i] == '0' || arr[i] == '1'){
                dp[i][i][arr[i] - '0'] = 1;
            }
        }
        for(int k = 1 ; k < s.length() ; k++){
            for(int i = 0 ; i < s.length() - k ; i+=2){
                int j = i + k;
                for(int x = i + 1; x < j ; x+=2){
                    if(arr[x] == '0' || arr[x] == '1')
                        continue;
                    if('|' == arr[x]){
                        dp[i][j][0] += dp[i][x-1][0] * dp[x + 1][j][0];
                        dp[i][j][1] += (dp[i][x-1][0] * dp[x + 1][j][1]
                                + dp[i][x-1][1] * dp[x + 1][j][0]
                                + dp[i][x-1][1] * dp[x+1][j][1]);
                    }else if('&' == arr[x]){
                        dp[i][j][0] += (dp[i][x-1][0] * dp[x + 1][j][1]
                                + dp[i][x-1][1] * dp[x + 1][j][0]
                                + dp[i][x-1][0] * dp[x + 1][j][0]);
                        dp[i][j][1] += dp[i][x-1][1] * dp[x + 1][j][1];
                    }else{
                        dp[i][j][0] += (dp[i][x-1][0] * dp[x + 1][j][0]
                                    + dp[i][x-1][1] * dp[x + 1][j][1]);
                        dp[i][j][1] += (dp[i][x-1][0] * dp[x + 1][j][1]
                                + dp[i][x-1][1] * dp[x + 1][j][0]);
                    }
                }
            }
        }
        return dp[0][s.length() - 1][result];
    }
}
