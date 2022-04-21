package com.nullzl.leetcode400;

import java.util.ArrayList;
import java.util.List;

public class LeetCode386 {

    private void traverse(int num,int n,List<Integer> ans){
        if(num > n)
            return ;
        ans.add(num);
        num *= 10;
        for(int i = 0 ; i < 10 && num <= n ; i++,num++){
            traverse(num,n,ans);
        }
    }

    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new ArrayList<>(n);
        if(n < 1)
            return ans;
        for(int i = 1 ; i < 10 ; i++)
            traverse(i,n,ans);
        return ans;
    }
}
