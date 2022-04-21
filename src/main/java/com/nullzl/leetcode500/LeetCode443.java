package com.nullzl.leetcode500;

public class LeetCode443 {

    public int compress(char[] chars) {
        int j = 0;
        for(int i = 0 ; i < chars.length ; ){
            char ch = chars[i];
            int k = i + 1 , count = 0;
            while(k < chars.length && chars[k] == ch) k++;
            count = k - i;
            i = k;
            chars[j++] = ch;
            if(1 != count){
                char[] arr = String.valueOf(count).toCharArray();
                for(k = 0 ; k < arr.length ; k++)
                    chars[j++] = arr[k];
            }
        }
        return j;
    }
}
