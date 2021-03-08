package com.nullzl.leetcode100;

public class LeetCode36 {

    public boolean isValidSudoku(char[][] board) {

        if(null == board)
            return false;

        boolean[][] rows = new boolean[9][9];
        boolean[][] columns = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        for(int i = 0 ; i < 9 ; i++){
            for(int j = 0 ; j < 9 ; j++){
                if('.' == board[i][j])
                    continue;
                int index = board[i][j] - '1' ;
                if(!rows[i][index])
                    rows[i][index] = true;
                else
                    return false;
                if(!columns[j][index])
                    columns[j][index] = true;
                else
                    return false;
                int m = ((i / 3) *  3  + j / 3);
                if(!boxes[m][index])
                    boxes[m][index] = true;
                else
                    return false;
            }
        }
        return true;
    }
}
