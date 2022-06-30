package com.nullzl.offer;

public class Offer2_118     {


    private int get(int idx,int[] set){
        int s = idx;
        while(s != set[s]){
            s = set[s];
        }
        set[idx] = s;
        return s;
    }

    private void merge(int r1,int r2,int[] set){
        set[r2] = r1;
    }

    public int[] findRedundantConnection(int[][] edges) {

        int n = edges.length;
        int[] set = new int[n + 1];
        for(int i = 1 ; i <= n ; i++){
            set[i] = i;
        }
        for(int[] e : edges){
            int r1 = get(e[0],set);
            int r2 = get(e[1],set);
            if(r1 == r2)
                return e;
            merge(r1,r2,set);
        }
        return null;
    }
}
