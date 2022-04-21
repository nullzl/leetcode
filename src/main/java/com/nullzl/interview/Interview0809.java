package com.nullzl.interview;

import java.util.ArrayList;
import java.util.List;

public class Interview0809 {

    private void dfs(List<String> lists,char[] str,int[] count,int s){
        if(s == str.length){
            lists.add(new String(str));
            return ;
        }

        if(0 != count[0]){
            str[s] = '(';
            count[0]--;
            dfs(lists,str,count,s + 1);
            count[0]++;
        }

        if(count[0] < count[1]){
            str[s] = ')';
            count[1]--;
            dfs(lists,str,count,s + 1);
            count[1]++;
        }

    }


    public List<String> generateParenthesis(int n) {
        List<String> lists = new ArrayList<>();

        char[] str = new char[n << 1];
        dfs(lists,str,new int[]{n,n},0);
        return lists;
    }
}
