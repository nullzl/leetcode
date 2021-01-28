package com.nullzl.leetcode600;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode542 {
    public int[][] updateMatrix(int[][] matrix) {
        if(null == matrix || 0 == matrix.length
                || null == matrix[0] || 0 == matrix[0].length)
            return matrix;

        Queue<Pair<Integer,Integer>> queue = new LinkedList<Pair<Integer,Integer>>();
        Pair<Integer,Integer> p;
        int step,x,y,i,j;
        for(i = 0 ; i < matrix.length ; i++){
            for(j = 0 ; j < matrix[i].length ; j++){
                if(0 == matrix[i][j])
                    queue.offer(new Pair<>(i,j));
            }
        }
        int[][] bounds = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
        while(!queue.isEmpty()){
            p = queue.poll();
            x = p.getKey();
            y = p.getValue();
            step = matrix[x][y];
            for(int[] b : bounds){
                i = x + b[0];
                j = y + b[1];
                if(i >= 0 && i < matrix.length && j >= 0 && j < matrix[i].length && matrix[i][j] == 1){
                    matrix[i][j] = step - 1;
                    queue.offer(new Pair<>(i,j));
                }
            }
        }
        for(i = 0 ; i < matrix.length ; i++){
            for(j = 0 ; j < matrix[i].length ; j++){
                matrix[i][j] = - matrix[i][j];
            }
        }
        return matrix;

    }
}
