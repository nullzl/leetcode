package com.nullzl.offer;

public class Offer2_107 {

    private int visit(int[][] mat,int[] stk,int e,int[][] rs,int i , int j,int k){
        if(i < 0 || i >= mat.length || j < 0 || j >= mat[i].length || 0 == mat[i][j])
            return e;
        mat[i][j] = 0;
        stk[e++] = i * mat[i].length + j;
        rs[i][j] = k;
        return e;
    }



    public int[][] updateMatrix(int[][] mat) {

        int m = mat.length;
        int n = mat[0].length;

        int[][] rs = new int[m][n];
        int[] stk = new int[m * n];
        int s = 0 , e = 0;
        for(int i = 0 ; i < mat.length; i++){
            for(int j = 0 ; j < mat[i].length ; j++){
                if(0 == mat[i][j])
                    stk[e++] = i * mat[i].length + j;
            }
        }

        while(s < e){
            int i = stk[s] / n;
            int j = stk[s++] % n;
            int k = rs[i][j] + 1;
            e = visit(mat,stk,e,rs,i+1,j,k);
            e = visit(mat,stk,e,rs,i-1,j,k);
            e = visit(mat,stk,e,rs,i,j+1,k);
            e = visit(mat,stk,e,rs,i,j-1,k);
        }
        return rs;
    }
}
