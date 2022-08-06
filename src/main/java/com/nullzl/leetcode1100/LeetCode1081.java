package com.nullzl.leetcode1100;

public class LeetCode1081 {

    public String smallestSubsequence(String s) {
        int[] counter = new int[26];
        boolean[] added = new boolean[26];
        char[] arr = s.toCharArray();
        for(int i = 0 ; i < arr.length ; i++){
            counter[arr[i] - 'a']++;
        }

        char[] ans = new char[arr.length];
        int size = 0;
        for(int i = 0 ;i < arr.length ; i++){
            int idx = arr[i] - 'a';
            if(!added[idx]){
                while(size > 0 && counter[ans[size-1] - 'a'] > 0 && arr[i] < ans[size - 1]) {
                    added[ans[size-1] - 'a'] = false;
                    size--;
                }
                ans[size++] = arr[i];
                added[idx] = true;
            }
            counter[idx]--;
        }
        return new String(ans,0,size);
    }
}
