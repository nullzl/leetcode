package main.java.com.nullzl.leetcode100;

public class LeetCode03 {
    public int lengthOfLongestSubstring(String s) {
        if(null == s || 0 == s.length())
            return 0;
        StringBuilder str = new StringBuilder(s);
        boolean[] charFlag = new boolean[256];
        int maxLen = 0;
        int start = 0;
        int end = 0;
        while(end < str.length() && str.length() - start > maxLen){
            char cur = str.charAt(end);
            if(!charFlag[cur]) {
                charFlag[cur] = true;
                end++;
            }else{
                int len = end - start;
                if(len > maxLen)
                    maxLen = len;
                while(cur != str.charAt(start)){
                    charFlag[str.charAt(start)] = false;
                    start++;
                }
                start++;
                end++;
            }
        }
        if(end == str.length() && end - start > maxLen)
            maxLen = end - start;
        return maxLen;
    }

    public static void main(String[] args){
        String str = "pwwkew";
        System.out.println(new LeetCode03().lengthOfLongestSubstring(str));
    }
}
