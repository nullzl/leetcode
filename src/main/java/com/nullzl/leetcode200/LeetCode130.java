package com.nullzl.leetcode200;

public class LeetCode130 {

    private void dfs(char[][] board,int i,int j){
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length
                || 'X' == board[i][j]
                || '1' == board[i][j])
            return ;
        board[i][j] = '1';
        dfs(board,i -1,j);
        dfs(board,i + 1, j);
        dfs(board,i,j-1);
        dfs(board,i,j+1);
    }

    public void solve(char[][] board) {
        if(1 == board.length || 1 == board[0].length)
            return ;
        for(int i = 0 ; i < board[0].length ; i++){
            dfs(board,0,i);
            dfs(board,board.length - 1,i);
        }
        for(int i = 1 ; i < board.length - 1 ; i++){
            dfs(board,i,0);
            dfs(board,i,board[i].length - 1);
        }
        for(int i = 0 ; i < board.length ; i++){
            for(int j = 0 ; j < board[i].length ; j++){
                board[i][j] = '1' == board[i][j] ? 'O' : 'X';
            }
        }
    }
}
