package com.nullzl.leetcode100;

import java.util.Arrays;

public class LeetCode03 {

    private int test = 2;
    private static LeetCode4 test1 = null;
    private static LeetCode4 test2 = null;
    private static int test3 = 2;
    private static String test4 = "sdfas";

    public int lengthOfLongestSubstring1(String s) {
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


    public int lengthOfLongestSubstring(String s) {
        if(null == s || 0 == s.length())
            return 0;
        int[] map = new int[1 << 8];
        Arrays.fill(map,-1);
        int max = 0;
        int left = 0, right = 0;
        char[] arr = s.toCharArray();
        for(; right < arr.length ; right++){
            if(-1 != map[arr[right]] && map[arr[right]] >= left)
                left = map[arr[right]] + 1;
            if(right - left + 1 > max)
                max = right - left + 1;
            map[arr[right]] = right;
        }
        return max;
    }

    public static void main(String[] args) throws InterruptedException {
        String str = "pwwkew";
        System.out.println(new LeetCode03().lengthOfLongestSubstring(str));
        System.out.println(Thread.currentThread().getId());
        while(true){
            Thread.sleep(1000);
        }
    }
}
