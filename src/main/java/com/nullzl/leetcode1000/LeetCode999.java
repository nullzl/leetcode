package com.nullzl.leetcode1000;

import java.util.Arrays;

public class LeetCode999 {

    public int numRookCaptures(char[][] board) {
        int count = 0;
        int i = 0,j = 0;
        outer : for (i = 0 ; i < board.length ; i++){
            for(j = 0 ; j < board[i].length ; j++){
                if('R' == board[i][j])
                    break outer;
            }
        }
        if(i >= 8 || j >= 8)
            throw new IllegalArgumentException();
        for(int k = i - 1 ; k >= 0 ; k--){
            if('.' == board[k][j])
                continue;
            else if('p' == board[k][j]){
                count++;
                break;
            }else
                break;
        }
        for(int k = i + 1 ; k < board.length ; k++){
            if('.' == board[k][j])
                continue;
            else if('p' == board[k][j]){
                count++;
                break;
            }else
                break;
        }
        for(int k = j - 1 ; k >= 0 ; k--){
            if('.' == board[i][k])
                continue;
            else if('p' == board[i][k]){
                count++;
                break;
            }else
                break;
        }
        for(int k = j + 1 ; k < board.length ; k++){
            if('.' == board[i][k])
                continue;
            else if('p' == board[i][k]){
                count++;
                break;
            }else
                break;
        }
        return count;
    }

    public static void main(String[] args){
        System.out.println(new LeetCode999().numRookCaptures(
                new char[][]{{'.','.','.','.','.','.','.','.'},{'.','.','.','p','.','.','.','.'},{'.','.','.','R','.','.','.','p'},{'.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.'},{'.','.','.','p','.','.','.','.'},{'.','.','.','.','.','.','.','.'},{'.','.','.','p','.','.','.','.'}}

        ));
    }
}
