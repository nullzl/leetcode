package com.nullzl.leetcode200;

public class LeetCode132 {

    public int minCut(String s) {

        if(null == s || 0 == s.length() || 1 == s.length())
            return 0;

        boolean[][] flag = new boolean[s.length()][s.length()];
        for(int i = 0 ; i < s.length() - 1; i++){
            flag[i][i] = true;
            flag[i][i+1] = (s.charAt(i) == s.charAt(i + 1) ? true : false);
        }
        flag[s.length() - 1][s.length() - 1] = true;

        for(int step = 2 ; step < s.length() ; step++){
            for(int i = 0 ; i + step < s.length() ; i++){
                flag[i][i+step] = (s.charAt(i) == s.charAt(i + step)) && flag[i+1][i+step - 1];
            }
        }

        int[][] minCuts = new int[s.length()][s.length()];
        for(int i = 0 ; i < s.length() ; i++)
            minCuts[i][i] = 0;
        for(int step = 1; step < s.length() ; step++){
            for(int i = 0 ; i + step < s.length() ; i++){
                if(flag[i][i + step])
                    minCuts[i][i+step] = 0;
                else{
                    minCuts[i][i + step] = minCuts[i][i + step - 1] + 1;
                    for(int j = i + step - 2 ; j >= i ; j--){
                        minCuts[i][i + step] = Math.min(minCuts[i][i+step],
                                minCuts[i][j] + minCuts[j+1][i+step] + 1);
                    }
                }
            }
        }
        return minCuts[0][s.length() - 1];
    }

    public static void main(String[] args){
        System.out.println(new LeetCode132().minCut("aab"));
    }
}
