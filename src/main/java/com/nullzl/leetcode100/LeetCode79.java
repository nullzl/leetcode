package com.nullzl.leetcode100;

public class LeetCode79 {

    public boolean find(char[][] board,boolean[][] used,int i,int j,String word,int k){
        if(k == word.length())
            return true;
        if(i < 0 || i >= board.length)
            return false;
        if(j < 0 || j >= board[0].length)
            return false;
        char ch = word.charAt(k);
        boolean rs = false;
        if(ch == board[i][j] && !used[i][j]){
            used[i][j] = true;
            rs = find(board,used,i,j+1,word,k+1);
            rs = rs ? rs : find(board,used,i-1,j,word,k+1);
            rs = rs ? rs : find(board,used,i+1,j,word,k+1);
            rs = rs ? rs : find(board,used,i,j-1,word,k+1);
            used[i][j] = false;
        }
        return rs;
    }

    public boolean exist(char[][] board, String word) {

        if(null == board || 0 == board.length || null == board[0]
                || 0 == board[0].length || null == word || 0 == word.length()){
            return false;
        }

        boolean[][] used = new boolean[board.length][board[0].length];
        boolean rs = false;
        for(int i = 0 ; i < board.length && !rs ; i++){
            for(int j = 0 ; j < board[0].length && !rs ; j++)
                rs = find(board,used,i,j,word,0);
        }
        return rs;
    }
    public static void main(String[] args0){
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        System.out.println(new LeetCode79().exist(board,"ABCCED"));
    }
}
