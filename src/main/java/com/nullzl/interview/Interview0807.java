package com.nullzl.interview;

import java.util.ArrayList;
import java.util.List;

public class Interview0807 {
    List<String> lists = new ArrayList<>();
    private void dfs(boolean[] visited,char[] str,char[] arr,int s){
        if(s == arr.length){
            lists.add(new String(str));
            return ;
        }
        for(int i = 0 ; i < arr.length ; i++){
            if(visited[i])
                continue;
            visited[i] = true;
            str[s] = arr[i];
            dfs(visited,str,arr,s + 1);
            visited[i] = false;
        }
    }

    public String[] permutation(String S) {
        if(null == S || 0 == S.length())
            return lists.toArray(new String[0]);
        boolean[] visited = new boolean[S.length()];
        char[] arr = S.toCharArray();
        char[] str = new char[arr.length];
        dfs(visited,str,arr,0);
        return lists.toArray(new String[0]);
    }
}
