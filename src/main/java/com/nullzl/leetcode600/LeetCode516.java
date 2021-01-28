package main.java.com.nullzl.leetcode600;

public class LeetCode516 {

    /**
     * dp[i][j] = {
     *     i = j : 1
     *     j = i + 1 : s[i] == s[j] ? 2 : 1;
     *     其他：
     *     s[i] == s[j] : dp[i+1][j-1]
     *     否则：max{dp[i][j-1],dp[i+1][j]}
     * }
     */

    public int longestPalindromeSubseq(String s) {

        if(null == s)
            throw new IllegalArgumentException();
        if(0 == s.length() || 1 == s.length())
            return s.length();

        int[][] dp = new int[s.length()][s.length()];
        for(int i = 0 ; i < s.length() - 1; i++){
            dp[i][i] = 1;
            dp[i][i+1] = (s.charAt(i) == s.charAt(i+1)) ? 2 : 1;
        }
        dp[s.length()- 1][s.length()-1] = 1;
        int temp;
        for(int step = 2 ; step < s.length(); step++){
            for(int i = 0 ; i + step < s.length() ; i++){
                if(s.charAt(i) == s.charAt(i + step)){
                    dp[i][i + step] = dp[i+1][i + step - 1] + 2;
                }else{
                    dp[i][i+step] = Math.max(dp[i+1][i+step],dp[i][i+step-1]);
                }
            }
        }
        return dp[0][s.length() - 1];
    }

    public static void main(String[] args){
        System.out.println(new LeetCode516().longestPalindromeSubseq("hiagkblncydzewfuxfzejdmcobpaq"));
    }
}
