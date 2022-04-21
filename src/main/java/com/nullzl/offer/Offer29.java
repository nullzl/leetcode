package com.nullzl.offer;

public class Offer29 {

    public int[] spiralOrder(int[][] matrix) {

        if(null == matrix || 0 == matrix.length || null == matrix[0] || 0 == matrix[0].length)
            return new int[0];
        int x1,x2,y1,y2;
        x1 = y1 = 0;
        x2 = matrix.length;
        y2 = matrix[0].length;
        int[] rs = new int[x2 * y2];
        x2--;y2--;
        int j = 0;

        while(x1 < x2 && y1 < y2){

            for(int i = y1 ; i < y2 ; i++)
                rs[j++] = matrix[x1][i];
            for(int i = x1  ; i < x2 ; i++)
                rs[j++] = matrix[i][y2];
            for(int i = y2; i > y1 ; i--)
                rs[j++] = matrix[x2][i];
            for(int i = x2 ; i > x1 ; i--)
                rs[j++] = matrix[i][y1];
            x1++;y1++;x2--;y2--;
        }
        if(x1 == x2 && y1 <= y2){
            while(y1 <= y2) rs[j++] = matrix[x1][y1++];
        }else if(x1 < x2 && y1 == y2){
            while(x1 <= x2) rs[j++] = matrix[x1++][y1];
        }

        return rs;
        

    }
}
