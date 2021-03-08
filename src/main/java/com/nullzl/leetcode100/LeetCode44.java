package com.nullzl.leetcode100;

public class LeetCode44 {

    public boolean isMatch(String s, String p) {
        boolean[][] rs = new boolean[s.length() + 1][p.length() + 1];
        rs[0][0] = true;
        for(int i = 1; i <= p.length() ; i++){
            if('*' == p.charAt(i - 1)){
                rs[0][i] = rs[0][i-1];
            }
        }
        for(int i = 1 ; i <= s.length() ; i++){
            for(int j = 1 ; j <= p.length() ; j++){
                char ch1 = s.charAt(i - 1);
                char ch2 = p.charAt(j - 1);
                if('?' == ch2 || ch1 == ch2){
                    rs[i][j] = rs[i-1][j-1];
                }else if('*' == ch2){
                    rs[i][j] = (rs[i][j-1] || rs[i-1][j]);
                }
            }
        }
        return rs[s.length()][p.length()];
    }
}
