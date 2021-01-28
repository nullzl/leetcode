package com.nullzl.leetcode300;

public class LeetCode289 {

    public void gameOfLife(int[][] board) {
        int liveAmount;
        int i,j,x,y,row1,row2,col1,col2;
        for(i = 0 ; i < board.length ; i++){
            for(j = 0; j < board[i].length ; j++){
                liveAmount = 0;
                row1 = i - 1 >= 0 ? i - 1 : i;
                row2 = i + 1 < board.length ? i + 1 : i ;
                col1 = j - 1 >= 0 ? j - 1 : j;
                col2 = j + 1 < board[i].length ? j + 1 : j;
                for(x = row1 ; x < row2 ; x++)
                    for(y = col1 ; y < col2 && liveAmount < 5 ; y++){
                        if((1 & board[x][y]) > 0)
                            liveAmount++;
                    }
                System.out.print(liveAmount + "\t");
                if(0 == board[i][j] && liveAmount == 3)
                    board[i][j] = 2;
                else if(1 == board[i][j] && (liveAmount < 3 || liveAmount > 4))
                    board[i][j] = 3;
            }
            System.out.println();
        }
        for(i = 0 ; i < board.length ; i++)
            for(j = 0 ; j < board[i].length ; j++){
                if(3 == board[i][j])
                    board[i][j] = 0;
                else if(2 == board[i][j])
                    board[i][j] = 1;
            }

    }

    public static void main(String[] args){

    }
}
