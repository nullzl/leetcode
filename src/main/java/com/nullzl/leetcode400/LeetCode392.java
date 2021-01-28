package com.nullzl.leetcode400;

import java.util.Arrays;

public class LeetCode392 {

    private boolean isSub(String s,int i,String t,int j,int[][] pos){
        if(i == s.length())
            return true;

        if(s.length() - i > t.length() - j)
            return false;

        int p = s.charAt(i) - 'a';
        int k = Arrays.binarySearch(pos[p],j);
        if(k < 0){
            k = -k - 1;
        }

        while(k < pos[p].length){
            j = pos[p][k++] + 1;
            if(isSub(s,i+1,t,j,pos))
                return true;
        }
        return false;
    }


    public boolean isSubsequence(String s, String t) {
        if(t.length() < s.length())
            return false;

        if(0 == s.length())
            return true;

        int count = 'z' - 'a' + 1;
        int[] len = new int[count];
        int[][] pos = new int[count][];
        for(int i = 0 ; i < t.length() ; i++)
            len[t.charAt(i) - 'a']++;
        for(int i = 0 ; i < len.length ; i++){
            pos[i] = new int[len[i]];
        }
        Arrays.fill(len,0);
        for(int i = 0 ; i < t.length() ; i++){
            int p = t.charAt(i) - 'a';
            pos[p][len[p]++] = i;
        }

        return isSub(s,0,t,0,pos);
    }



    public boolean isSubsequence1(String s, String t) {

        if(t.length() < s.length())
            return false;

        if(0 == s.length())
            return true;

        boolean[] dp = new boolean[t.length()];
        dp[0] = s.charAt(0) == t.charAt(0);
        for(int i = 1 ; i < t.length() ; i++)
            dp[i] = (dp[i-1] || s.charAt(0) == t.charAt(i));

        for(int i = 1 ; i < s.length() ; i++){
            boolean pre = dp[i];
            dp[i] = (s.charAt(i) == t.charAt(i)) && dp[i-1];
            for(int j = i + 1 ; j < t.length() ; j++){
                boolean tmp = dp[j];
                dp[j] = dp[j-1] || ((s.charAt(i) == t.charAt(j)) && pre);
                pre = tmp;
            }
        }

        return dp[t.length() - 1];
    }
}
