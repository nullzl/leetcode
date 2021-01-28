package main.java.com.nullzl.leetcode200;

public class LeetCode171 {

    public int titleToNumber(String s) {

        int num = 0 ;
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            num = num * 26 + (ch - 'A' + 1);
        }
        return num;

    }
}
