package com.nullzl.offer;

public class Offer2_116 {

    private int get(int idx,int[] set){
        int r = idx;
        while(r != set[r])
            r = set[r];
        set[idx] = r;
        return r;
    }
    private void merge(int r1,int r2,int[] set){
        set[r1] = r2;
    }

    public int findCircleNum(int[][] isConnected) {

        int[] set = new int[isConnected.length];
        for(int i = 0 ; i < set.length ; i++)
            set[i] = i;

        for(int i = 0 ; i < isConnected.length ; i++){
            for(int j = i + 1 ; j < isConnected[i].length ; j++){
                if(1 == isConnected[i][j]){
                    int r1 = get(i,set);
                    int r2 = get(j,set);
                    merge(r1,r2,set);
                }
            }
        }
        int count = 0;
        for(int i = 0 ; i < set.length ; i++){
            if(i == set[i])
                count++;
        }
        return count;
    }
}
