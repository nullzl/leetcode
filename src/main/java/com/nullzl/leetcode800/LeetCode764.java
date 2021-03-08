package com.nullzl.leetcode800;

import java.util.Arrays;

public class LeetCode764 {

    public int orderOfLargestPlusSign(int N, int[][] mines) {

        if(null == mines || 0 == mines.length)
            return (N - 1) / 2 + 1;

        boolean[] flag = new boolean[N * N];
        for(int i = 0 ; i < mines.length ; i++){
            flag[mines[i][0] * N + mines[i][1]] = true;
        }

        int preRow;
        int[] preColumn = new int[N];
        int max = 0;
        int row,column;
        for(int i = 0 ; i < N ; i++){
            preRow = 0;
            for(int j = 0 ; j < N ; j++){
                if(flag[i * N + j]){
                    preRow = 0;
                    preColumn[j] = 0;
                }else{
                    if(0 == preRow)
                        row = 1;
                    else if(1 == preRow)
                        row = (j + 1 < N && !flag[(i * N + j + 1)]) ? 2 : 1;
                    else{
                        row = preRow - 1;
                        if(j + preRow - 1 < N && !flag[i * N + j + preRow - 1]) {
                            row++;
                            if (j + preRow < N && !flag[i * N + j + preRow])
                                row++;
                        }
                    }
                    if(0 == preColumn[j])
                        column = 1;
                    else if(1 == preColumn[j])
                        column = i + 1 < N && !flag[(i + 1) * N + j] ? 2 : 1;
                    else{
                        column = preColumn[j] - 1;
                        if(i + preColumn[j] - 1 < N && !flag[(i + preColumn[j] - 1) * N + j]) {
                            column++;
                            if (i + preColumn[j] < N && !flag[(i + preColumn[j]) * N + j])
                                column++;
                        }
                    }
                    int radius = Math.min(row,column);
                    if(radius > max)
                        max = radius;
                    preColumn[j] = column;
                    preRow = row;
                }
            }
        }
        return  max;
    }
}
