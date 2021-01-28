package main.java.com.nullzl.leetcode400;

public class LeetCode387 {

    public int firstUniqChar(String s) {

        if(null == s || 0 == s.length())
            return -1;

        int[] amount = new int['z' - 'a' + 1];
        for(int i = 0 ; i < s.length() ; i++){
            amount[s.charAt(i) - 'a']++;
        }
        for(int i = 0 ; i < s.length() ; i++){
            if(1 == amount[s.charAt(i) - 'a'])
                return i;
        }
        return -1;
    }
}
