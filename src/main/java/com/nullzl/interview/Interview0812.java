package com.nullzl.interview;

import java.util.ArrayList;
import java.util.List;

public class Interview0812 {



    private void dfs(List<List<String>> lists,String[] lines,int[] rs,boolean[] column ,
                     boolean[] side1,boolean[] side2,int s){
        if(s == column.length){
            List<String> list = new ArrayList<>(column.length);
            for(int num : rs){
                list.add(lines[num]);
            }
            lists.add(list);
            return ;
        }
        for(int i = 0 ; i < column.length ; i++){
            int s1 = s + i;
            int s2 = column.length - 1 + s - i;
            if(column[i] || side1[s1] || side2[s2])
                continue;
            column[i] = true;side1[s1] = true; side2[s2] = true;
            rs[s] = i;
            dfs(lists,lines,rs,column,side1,side2,s + 1);
            column[i] = false;side1[s1] = false; side2[s2] = false;
        }
    }

    public List<List<String>> solveNQueens(int n) {

        List<List<String>> lists = new ArrayList<>();
        if(n == 0){
            lists.add(new ArrayList<>());
            return lists;
        }
        String[] lines = new String[n];
        char[] arr = new char[n];
        for(int i = 0 ; i < n ; i++)
            arr[i] = '.';
        for(int i = 0 ;i < n ; i++){
            arr[i] = 'Q';
            lines[i] = new String(arr);
            arr[i] = '.';
        }
        int[] rs = new int[n];

        boolean[] column = new boolean[n];
        boolean[] side1 = new boolean[(n << 1)  - 1];
        boolean[] side2 = new boolean[(n << 1)  - 1];
        dfs(lists,lines,rs,column,side1,side2,0);
        return lists;
    }
}
