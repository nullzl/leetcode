package com.nullzl.leetcode1000;

import java.util.Random;

public class LeetCode959 {
    static final int UP = 1;
    static final int DOWN = 8;
    static final int LEFT = 2;
    static final int RIGHT = 4;
    static final int ALL = 1 | 2 | 4 | 8;
    static final int UP_LEFT = UP | LEFT;
    static final int UP_RIGHT = UP | RIGHT;
    static final int DOWN_RIGHT = DOWN | RIGHT;
    static final int DOWN_LEFT = DOWN | LEFT;

    private int get(String[] grid,int i , int j , int k){
        String s = grid[i];
        char ch = s.charAt(j);
        if(' ' == ch)
            return ALL;
        if('/' == ch){
            if(0 != (k & UP_LEFT))
                return UP_LEFT;
            else
                return DOWN_RIGHT;
        }

        if(0 != (k & DOWN_LEFT))
            return DOWN_LEFT;
        else
            return UP_RIGHT;

    }

    private void dfs(String[] grid,int[][] state,int i , int j , int k){


        if(i < 0 || j < 0 || i >= state.length || j >= state.length)
            return ;
        if(0 != (k & state[i][j]))
            return ;

        state[i][j] |= get(grid,i,j,k);

        if(0 != (state[i][j] & UP))
            dfs(grid,state,i-1,j,DOWN);
        if(0 != (state[i][j] & DOWN))
            dfs(grid,state,i + 1,j,UP);
        if(0 != (state[i][j] & LEFT))
            dfs(grid,state,i,j-1,RIGHT);
        if(0 != (state[i][j] & RIGHT))
            dfs(grid,state,i,j+1,LEFT);


    }


    public int regionsBySlashes(String[] grid) {

        int n = grid.length;

        int[][] state = new int[n][n];

        int count = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(0 == (ALL ^ state[i][j]))
                    continue;
                if(0 == (LEFT & state[i][j])){
                    dfs(grid,state,i,j,LEFT);
                    count++;
                }
                if(0 == (RIGHT & state[i][j])){
                    dfs(grid,state,i,j,RIGHT);
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args){
        Random r = new Random();
        int len = r.nextInt(30) + 1;
        System.out.print("[");
        for(int i = 0 ; i < len ; i++){
            StringBuffer s = new StringBuffer();
            for(int j = 0 ; j < len ; j++){
                int k = r.nextInt(3);
                if(0 == k)
                    s.append(' ');
                else if(1 == k)
                    s.append('/');
                else
                    s.append("\\\\");
            }
            System.out.print("\"" + s.toString() + "\"" + ",");
        }
        System.out.print("]");
    }

}
