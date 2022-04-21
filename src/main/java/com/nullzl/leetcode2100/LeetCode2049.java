package com.nullzl.leetcode2100;

public class LeetCode2049 {

    long max = 0;
    int count = 0;

    private int dfs(int node,int[][] children){
        int left = children.length;
        long rate = 1;
        int nodes = 1;
        for(int i = 1 ; i <= children[node][0] ; i++){
            int c = dfs(children[node][i],children);
            nodes += c;
            rate *= c;
        }
        left -= nodes;
        rate = left != 0 ? left * rate : rate;
        if(rate > max){
            max = rate;
            count = 1;
        }else if(rate == max){
            count++;
        }
        return nodes;
    }

    public int countHighestScoreNodes(int[] parents) {

        assert (null != parents && 0 != parents.length);
        int[][] children = new int[parents.length][3];

        for(int i = 1 ; i < parents.length ; i++){
            children[parents[i]][++children[parents[i]][0]] = i;
        }
        dfs(0,children);
        return count;
    }
}
