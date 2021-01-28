package main.java.com.nullzl.leetcode300;

public class LeetCode242 {

    public boolean isAnagram(String s, String t) {

        if(null == s || null == t)
            return false;

        if(s.length() != t.length())
            return false;

        int[] amount = new int['z' - 'a' + 1];
        for(int i = 0 ; i < s.length() ; i++){
            amount[s.charAt(i) - 'a']++;
        }

        for(int i = 0 ; i < t.length() ; i++){
            if(--amount[t.charAt(i) - 'a'] < 0)
                return false;
        }
        return true;
    }
}
