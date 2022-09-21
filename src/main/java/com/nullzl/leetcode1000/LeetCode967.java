package com.nullzl.leetcode1000;

import java.util.ArrayList;
import java.util.List;

public class LeetCode967 {
    List<StringBuilder> EMPTY = new ArrayList<>();

    List<StringBuilder> product(List<StringBuilder>[] list,int prev,int idx){
        if(idx < 0 || idx > 9)
            return EMPTY;
        List<StringBuilder> ans = new ArrayList<>();
        for(StringBuilder str : list[idx]){
            StringBuilder t = new StringBuilder(str);
            t.append(String.valueOf(prev));
            ans.add(t);
        }
        return ans;
    }

    private List<StringBuilder>[] next(List<StringBuilder>[] list,int k){
        List<StringBuilder>[] ans = new List[10];
        for(int i = 0 ; i < 10 ; i++){
            ans[i] = new ArrayList<>();
            ans[i].addAll(product(list,i,i - k));
            if(i - k != i + k)
                ans[i].addAll(product(list,i , i + k));
        }
        return ans;
    }

    public int[] numsSameConsecDiff(int n, int k) {
        List<StringBuilder>[] list = new List[10];
        for(int i = 0 ; i < 10 ; i++){
            list[i] = new ArrayList<>();
            list[i].add(new StringBuilder(String.valueOf(i)));
        }

        for(int i = 2 ; i <= n ; i++){
            list = next(list,k);
        }
        int sz = 0;
        for(int i = 1 ; i < list.length ; i++){
            sz += list[i].size();
        }
        int[] ans = new int[sz];

        for(int i = 1,j = 0 ; i < list.length ; i++){
            for(StringBuilder str : list[i]){
                ans[j++] = Integer.parseInt(str.reverse().toString());
            }
        }
        return ans;
    }
}
