package com.nullzl.leetcode700;

import java.util.Arrays;
import java.util.Random;

public class LeetCode664 {

    public int strangePrinter(String s) {
        if(null == s || 0 == s.length())
            return 0;

        int[] pre = new int['z' - 'a' + 1];
        Arrays.fill(pre,-1);
        int[] next = new int[s.length()];
        Arrays.fill(next,-1);
        char[] chs = new char[s.length()];
        chs[0] = s.charAt(0);
        pre[chs[0] - 'a'] = 0;
        int size = 1;
        for(int i = 1; i < s.length() ; i++){
            if(s.charAt(i) == s.charAt(i-1))
                continue;
            chs[size] = s.charAt(i);
            if(-1 != pre[chs[size] - 'a'])
                next[pre[chs[size] - 'a']] = size;
            pre[chs[size] - 'a'] = size;
            size++;
        }
        int[][] count = new int[size][size];
        for(int i = size - 1 ; i >= 0 ; i--){
            Arrays.fill(count[i],Integer.MAX_VALUE);
            for(int j = i ; j < size ; j++){
                count[i][j] = Math.min(count[i][j],
                        i < j ? count[i][j-1] + 1 : 1);
                for(int k = next[j] ; k != -1 ; k = next[k]){
                    count[i][k] = Math.min(count[i][k],
                            count[i][j] + count[j+1][k-1]);
                }
            }
        }
        return count[0][size-1];
    }



    public static void main(String[] args){
        Random r = new Random();
        int len = r.nextInt(81) + 1;
        for(int i = 0 ; i < len ; i++){
            System.out.print((char)(r.nextInt('f' - 'a' + 1) + 'a'));
        }
    }
}
