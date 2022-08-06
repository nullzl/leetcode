package com.nullzl.leetcode1300;

public class LeetCode1278 {

    /**
     * 递推公式：
     * dp[i][j][k] = min{dp[i][j-1][k-1] + dp[j][j][1] ... dp[i][i + k - 1][k-1] + dp[i + k][j][1]}
     * 初始：
     * dp[i][i][1] = 0
     * dp[i][i+1][1] = s[i] == s[i+1] ? 0 : 1
     * dp[i][j][1] = s[i]== s[j] ? dp[i+1][j-1][1] : dp[i+1][j-1][1] + 1
     */

    public int palindromePartition(String s, int k) {

        if(null == s || k <= 0  || 0 == s.length() || k > s.length() )
            throw new IllegalArgumentException();

        int[][][] dp = new int[s.length()][s.length()][k + 1];
        for(int i = 0 ; i < s.length() - 1 ; i++){
            dp[i][i][1] = 0;
            dp[i][i+1][1] = (s.charAt(i) == s.charAt(i + 1)) ? 0 : 1;
        }
        dp[s.length() - 1][s.length() - 1][1] = 0;

        for(int step = 2; step < s.length() ; step++){
            for(int i = 0 ; i + step < s.length() ; i++){
                dp[i][i + step][1] =
                        (s.charAt(i) == s.charAt(i + step)) ? dp[i+1][i+step-1][1] : dp[i+1][i+step-1][1] + 1;
            }
        }

        for(int z = 2 ; z < k ; z++){
            for(int i = 0 ;i < s.length() ; i++){
                for(int j = i + z - 1 ; j < s.length() ; j++){

                    dp[i][j][z] = dp[i][j-1][z-1] ;
                    for(int y = j - 2 ; y >=  i + z - 2; y--){
                        dp[i][j][z] = Math.min(dp[i][y][z-1] + dp[y+1][j][1],
                                dp[i][j][z]);
                    }

                }
            }
        }
        if(1 == k)
            return dp[0][s.length() - 1][k];
        dp[0][s.length() - 1][k] = dp[0][s.length() - 2][k-1];
        for(int i = s.length() - 2; i >= k - 2 ; i--){
            dp[0][s.length() - 1][k] = Math.min(
                    dp[0][s.length()-1][k],
                    dp[0][i][k-1] + dp[i+1][s.length() - 1][1]
            );
        }
        return dp[0][s.length() - 1][k];
    }

    public static void main(String[] args){
        System.out.println(new LeetCode1278().palindromePartition("abcdedf",1));
    }
}
