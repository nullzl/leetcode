package com.nullzl.interview;

import java.util.Arrays;

public class Interview1604 {

    public String tictactoe(String[] board) {

        char[] columns = new char[board.length];
        Arrays.fill(columns,'N');
        char side1 = 'N';
        char side2 = 'N';
        String rs = "Draw";

        for(int i = 0 ;i < board.length ; i++){
            char[] arr = board[i].toCharArray();
            char row = 'N';
            for(int j = 0 ; j < board.length ; j++){
                if(arr[j] == ' ')
                    rs = "Pending";

                if('N' == row)
                    row = arr[j];
                else if(row != arr[j])
                    row = ' ';

                if('N' == columns[j])
                    columns[j] = arr[j];
                else if(columns[j] != arr[j])
                    columns[j] = ' ';

                if(i == j){
                    if('N' == side1)
                        side1 = arr[j];
                    else if(side1 != arr[j])
                        side1 = ' ';
                }

                if(Math.abs(i - j) == board.length - 1){
                    if('N' == side2)
                        side2 = arr[j];
                    else if(side2 != arr[j])
                        side2 = ' ';
                }
            }
            if(' ' != row)
                return String.valueOf(row);
        }
        for(char ch : columns){
            if(' ' != ch)
                return String.valueOf(ch);
        }
        if(' ' != side1)
            return String.valueOf(side1);
        if(' ' != side2)
            return String.valueOf(side2);
        return rs;
    }
}
