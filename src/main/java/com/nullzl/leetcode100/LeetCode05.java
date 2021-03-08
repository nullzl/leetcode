package com.nullzl.leetcode100;

public class LeetCode05 {

    //马拉车
    //进一步可优化内存，不实际构造字符串
    public String longestPalindrome(String s) {

        if(null == s || 0 == s.length())
            return "";
        StringBuilder str = new StringBuilder("#");
        for(int i = 0 ; i < s.length() ; i++){
            str.append(s.charAt(i));
            str.append('#');
        }
        int[] len = new int[str.length()];
        int maxLeft = 0;
        int maxRight = 0;
        int maxLen = 1;
        int curCenter = 0;
        int curBound = 0;
        int curIndex = 1;
        int gap;
        for(;curIndex < str.length() && str.length() - curIndex > maxLen ; curIndex++){
            int leftIndex = 2 * curCenter - curIndex;
            if(curIndex < curBound && (len[leftIndex] < curBound - curIndex + 1 )){
                len[curIndex] = len[leftIndex];
                continue;
            }
            if(curIndex >= curBound){
                gap = 1;
            }else{
                gap = curBound - curIndex + 1;
            }
            for(; curIndex - gap >= 0 && curIndex + gap <= str.length()
                    && str.charAt(curIndex - gap) == str.charAt(curIndex + gap); gap++);
            len[curIndex] = gap;
            if(len[curIndex] > maxLen){
                maxLen = len[curIndex];
                maxLeft = curIndex - gap + 1;
                maxRight = curIndex + gap - 1;
            }
            if(curIndex + gap - 1 > curBound){
                curBound = curIndex + gap - 1;
                curCenter = curIndex;
            }
        }
        StringBuilder result = new StringBuilder();
        for(int i = maxLeft; i <= maxRight ; i++){
            if('#' != str.charAt(i))
                result.append(str.charAt(i));
        }
        return result.toString();

    }

    //动态规划和暴力法类似
    public String longestPalindromeDP(String s) {
        if(null == s || 0 == s.length())
            return "";
        int[][] len = new int[s.length()][s.length()];
        int maxLen = 1;
        int maxStart = 0 ;
        int maxEnd  = 0 ;
        for(int i = 0 ; i < s.length() - 1 ; i++){
            len[i][i] = 1;
            len[i][i + 1] = (s.charAt(i) == s.charAt(i + 1) ? 2 : 0);
            if(2 == len[i][i+1]){
                maxLen = 2;
                maxStart = i;
                maxEnd = i + 1;
            }
        }
        len[s.length() - 1][s.length() -1] = 1;
        for(int k = 2 ; k < s.length() ; k++){
            for(int i = 0,j = k; i < s.length() && j < s.length();i++,j++){
                len[i][j] = (0 != len[i+1][j-1] && s.charAt(i) == s.charAt(j) ? len[i+1][j-1] + 2 : 0);
                if(len[i][j] > maxLen){
                    maxLen = len[i][j];
                    maxStart = i;
                    maxEnd = j;
                }
            }
        }
        return s.substring(maxStart,maxEnd + 1);
    }

    //暴力法，遍历每个字母，以此字母为中心展开
    public String longestPalindrome2(String s) {
        if(null == s || 0 == s.length())
            return "";
        int maxStart = -1;
        int maxLen = 0;
        for(int k = 0 ; k < s.length() ; k++){
            int len = 1;
            for(int i = k - 1, j = k + 1; i >= 0 && j < s.length() ; i--,j++){
                if(s.charAt(i) == s.charAt(j))
                    len += 2;
                else break;
            }
            if(maxLen < len){
                maxLen = len;
                maxStart = k - (len - 1) / 2;
            }

            len = 0;
            for(int i = k,j = k + 1; i >= 0 && j < s.length() ; i--,j++){
                if(s.charAt(i) == s.charAt(j))
                    len += 2;
                else
                    break;
            }
            if(maxLen < len){
                maxLen = len;
                maxStart = k - len / 2 + 1;

            }
        }
        return s.substring(maxStart,maxStart + maxLen);
    }

    public static void main(String[] args){
        String str = "bb";
        System.out.println(new LeetCode05().longestPalindrome(str));
    }
}
