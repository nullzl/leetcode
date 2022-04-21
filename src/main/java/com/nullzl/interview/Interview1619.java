package com.nullzl.interview;

import java.util.Arrays;

public class Interview1619 {

    private void dfs(int i,int j,int[][] land,int[] count,int index){
        if(i < 0 || i >= land.length || j < 0 || j >= land[0].length)
            return ;

        if(0 != land[i][j])
            return ;

        land[i][j] = 1;
        count[index]++;
        dfs(i + 1,j,land,count,index);
        dfs(i-1,j,land,count,index);
        dfs(i,j-1,land,count,index);
        dfs(i,j+1,land,count,index);
        dfs(i+1,j+1,land,count,index);
        dfs(i-1,j-1,land,count,index);
        dfs(i+1,j-1,land,count,index);
        dfs(i-1,j+1,land,count,index);
    }

    public int[] pondSizes(int[][] land) {

        int[] count = new int[land.length * land[0].length];
        int size = 0;
        for(int i = 0 ; i < land.length ; i++){
            for(int j= 0 ; j < land[i].length ; j++){
                if(0 == land[i][j])
                    dfs(i,j,land,count,size++);
            }
        }
        count = Arrays.copyOf(count,size);
        Arrays.sort(count);
        return count;
    }
}
