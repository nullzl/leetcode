package com.nullzl.offer;

import java.util.LinkedList;
import java.util.List;

public class Offer2_85 {

    List<String> ans = new LinkedList<>();

    private void dfs(int n, int left, int right,char[] arr, int size){
        if(right > left || left > n || right > n)
            return ;
        if(size ==  (n << 1)) {
            ans.add(new String(arr));
            return ;
        }

        arr[size] = '(';
        dfs(n,left + 1,right,arr,size + 1);
        arr[size] = ')';
        dfs(n,left,right + 1,arr,size + 1);
    }

    public List<String> generateParenthesis(int n) {
        char[] arr = new char[n << 1];
        dfs(n,0,0,arr,0);
        return ans;
    }
}
