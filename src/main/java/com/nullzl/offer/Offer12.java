package com.nullzl.offer;

public class Offer12 {

    public boolean findWord(boolean[][] used,char[][] board,int i,int j,char[] arr,int k){
        if(i < 0 || i >= used.length || j < 0 || j >= used[0].length)
            return false;
        if(used[i][j])
            return false;
        if(board[i][j] != arr[k])
            return false;
        if(k == arr.length - 1)
            return true;
        used[i][j] = true;
        boolean rs = findWord(used,board,i-1,j,arr,k + 1)
                || findWord(used,board,i+1,j,arr,k + 1)
                || findWord(used,board,i,j-1,arr,k + 1)
                || findWord(used,board,i,j + 1,arr,k + 1);
        used[i][j] = false;
        return rs;
    }

    public boolean exist(char[][] board, String word) {

        if(null == board || null == word || 0 == word.length())
            return false;
        char[] arr = word.toCharArray();
        boolean[][] used = new boolean[board.length][board[0].length];
        for(int i = 0 ; i < board.length ; i++){
            for(int j = 0 ; j < board[i].length ; j++){
                if(findWord(used,board,i,j,arr,0))
                    return true;
            }
        }
        return false;
    }
}
