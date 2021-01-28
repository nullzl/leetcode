package main.java.com.nullzl.leetcode100;

public class LeetCode37 {
    boolean[][] rows = new boolean[9][9];
    boolean[][] columns = new boolean[9][9];
    boolean[][] boxes = new boolean[9][9];

    public boolean solve(char[][] board,int k){
        int i = k / 9;
        int j = k % 9;
        if(81 == k)
            return true;
        if('.' != board[i][j])
            return solve(board,k + 1);
        int b = (i / 3) * 3 + j / 3;
        for(int x = 0 ; x <= 8; x++ ){
            if(!rows[i][x] && !columns[j][x] && !boxes[b][x]){
                board[i][j] = (char)(x + '1');
                rows[i][x] = true;
                columns[j][x] = true;
                boxes[b][x] = true;
                if(solve(board,k + 1)){
                    return true;
                }else{
                    board[i][j] = '.';
                    rows[i][x] = false;
                    columns[j][x] = false;
                    boxes[b][x] = false;
                }
            }
        }
        return false;
    }


    public void solveSudoku(char[][] board) {

        for(int i = 0 ; i < 9 ; i++){
            for(int j = 0 ; j < 9 ; j++){
                if('.' == board[i][j])
                    continue;
                int index = board[i][j] - '1' ;
                if(!rows[i][index])
                    rows[i][index] = true;
                if(!columns[j][index])
                    columns[j][index] = true;
                int m = ((i / 3) *  3  + j / 3);
                if(!boxes[m][index])
                    boxes[m][index] = true;
            }
        }
        solve(board,0);
    }
}
