package com.nullzl.leetcode600;

public class LeetCode567 {

    public boolean checkInclusion(String s1, String s2) {
        if(s2.length() < s1.length())
            return false;
        int[] map = new int[256];
        for(int i = 0 ; i < s1.length() ; i++){
            map[s1.charAt(i)]++;
            map[s2.charAt(i)]--;
        }
        int count = 0;
        for(int i = 0 ; i < 256 ; i++)
            count += (map[i] > 0 ? 1 : 0);
        char[] arr = s2.toCharArray();
        int i = s1.length() ;
        for( ; count > 0 && i < arr.length ; i++){
            count += (--map[arr[i]] == 0 ? -1 : 0);
            count += (++map[arr[i - s1.length()]] == 1 ? 1 : 0);
        }
        return 0 == count;
    }
}
