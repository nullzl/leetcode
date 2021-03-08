package com.nullzl.leetcode100;

import java.util.LinkedList;

public class LeetCode32 {

    //超时
    public int longestValidParentheses2(String s) {

        if(null == s || 0 == s.length())
            return 0;
        int maxLen = 0;
        boolean[][] len = new boolean[s.length()][s.length()];
        for(int i = 1 ; i < s.length()  ; i++) {
            if('(' == s.charAt(i-1) && ')' == s.charAt(i)) {
                len[i - 1][i] = true;
                maxLen = 2;
            }
        }
        for(int i = s.length() - 3 ; i >=0 ; i--){
            for(int j = i + 2 ; j < s.length() ; j++){
                if((j - i + 1) % 2 == 0){
                    if('(' == s.charAt(i) && ')' == s.charAt(j))
                        len[i][j] = len[i+1][j-1];
                    for(int k = i + 1 ; k < j && !len[i][j] ; k++){
                        len[i][j] = len[i][k] && len[k][j];
                    }
                }
                if(len[i][j] && maxLen < (j - i + 1)){
                    maxLen = j - i + 1;
                }
            }
        }
        return maxLen;
    }

    public int longestValidParentheses(String s) {
        if(null == s || 0 == s.length())
            return 0;
        int maxLen = 0 ;
        LinkedList<Integer> stk = new LinkedList<Integer>();
        int index = 0;
        int end = s.length();
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            if('(' == ch){
                stk.offerLast(i);
            }else{
                if(!stk.isEmpty()){
                    stk.pollLast();
                }else{
                    int len = i - index;
                    index = i + 1;
                    if(maxLen < len)
                        maxLen = len;
                }
            }
        }
        while(!stk.isEmpty()){
            int temp = stk.pollLast();
            int len = end - temp - 1;
            end = temp;
            if(len > maxLen)
                maxLen = len;
        }
        if(end - index > maxLen)
            maxLen = end - index;
        return maxLen;
    }
    public static void main(String[] args){
        System.out.println(new LeetCode32().longestValidParentheses(")()())"));
    }

}
