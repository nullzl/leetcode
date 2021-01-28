package main.java.com.nullzl.leetcode100;

public class LeetCode97 {
    public boolean isInterleave(String s1, String s2, String s3) {

        if(null == s1 || null == s2 || null == s3)
            return false;

        if(s1.length() + s2.length() != s3.length())
            return false;

        if(s2.length() > s1.length())
            return isInterleave(s2,s1,s3);

        boolean[] rs = new boolean[s2.length() + 1];
        rs[0] = true;
        for(int i = 1 ; i <= s2.length() ; i++){
            rs[i] = (rs[i-1] && (s2.charAt(i-1) == s3.charAt(i-1)));
        }

        for(int i = 1; i <= s1.length() ; i++){
            rs[0] = (rs[0] && (s1.charAt(i-1) == s3.charAt(i-1)));
            for(int j = 1; j <= s2.length() ; j++){
                rs[j] = ( (rs[j-1] && (s2.charAt(j-1) == s3.charAt(i+j-1))) ||
                        (rs[j] && (s1.charAt(i-1) == s3.charAt(i+j-1)))
                        );
            }
        }
        return rs[s2.length()];
    }
}
