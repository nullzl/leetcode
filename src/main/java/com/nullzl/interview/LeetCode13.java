package com.nullzl.interview;

import javafx.util.Pair;

import java.sql.Driver;
import java.sql.DriverManager;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

public class LeetCode13 {

    private int sum(int i){
        int sum  = 0;
        while(0 != i){
            sum += (i % 10);
            i /= 10;
        }
        return sum;
    }

    public int movingCount(int m, int n, int k) {
        if(0 == m || 0 == n)
            return 0;
        boolean[][] flag = new boolean[m][n];
        flag[0][0] = true;
        LinkedList<Pair<Integer,Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<Integer,Integer>(0,0));
        int count = 0;
        int[][] bounds = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        while(!queue.isEmpty()){
            Pair<Integer,Integer> p = queue.poll();
            count++;
            for(int i = 0; i < bounds.length ; i++){
                int x = p.getKey() + bounds[i][0];
                int y = p.getValue() + bounds[i][1];
                if(x >= 0 && x < m && y >= 0 && y < n && !flag[x][y]){
                    int sum = sum(x) + sum(y);
                    if(sum <= k){
                        queue.offer(new Pair<>(x,y));
                    }
                    flag[x][y] = true;
                }
            }
        }
        return count;
    }

    public static void main(String[] args){
    }
}
