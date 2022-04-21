package com.nullzl.leetcode1000;

public class LeetCode954 {

    int total = 0;
    int delta = 100000;

    private int dfs(int val,int[] count,boolean[] visited){
        if(-1 == total)
            return -1;
        int key =  val + delta;
        if(visited[key])
            return count[key];
        visited[key] = true;
        if(0 == val){
            total = (0 != (count[key] & 1)) ? -1 : total + count[key];
            count[key] = 0;
            return 0;
        }
        if(0 != (val & 1))
            return count[key];
        int half = val >> 1;
        int need = dfs(half,count,visited);
        if(-1 == need || need > count[key]){
            total = -1;
            return -1;
        }
        count[half + delta] = 0;
        count[key] -= need;
        total += (need << 1);
        return count[key];
    }

    public boolean canReorderDoubled(int[] arr) {

        int len = (delta << 1) + 2;
        int[] count = new int[len];
        boolean[] visited = new boolean[len];
        for(int n : arr){
            count[delta + n]++;
        }
        for(int i = 0 ; i < arr.length && -1 != total ; i++){
            int val = arr[i];
            dfs(val,count,visited);
        }
        return total == arr.length;
    }
}
