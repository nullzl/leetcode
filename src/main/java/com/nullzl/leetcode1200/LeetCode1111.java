package com.nullzl.leetcode1200;

public class LeetCode1111 {
    public int[] maxDepthAfterSplit(String seq) {
        if(null == seq || 0 == seq.length())
            return new int[0];

        int[] rs = new int[seq.length()];
        int size1 = 0;
        int size2 = 0;
        char ch ;
        for(int i = 0 ; i < seq.length() ; i++){
            ch = seq.charAt(i);
            if('(' == ch){
                if(size1 < size2){
                    size1++;
                    rs[i] = 1;
                }else{
                    size2++;
                }
            }else{
                if(size2 > 0)
                    size2--;
                else{
                    rs[i] = 1;
                    size1--;
                }
            }
        }
        return rs;
    }
}
