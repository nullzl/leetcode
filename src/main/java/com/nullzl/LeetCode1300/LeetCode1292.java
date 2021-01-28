package com.nullzl.LeetCode1300;

public class LeetCode1292 {
    public int maxSideLength(int[][] mat, int threshold) {

        int r = mat.length;
        int c = mat[0].length;

        int len = Math.min(r,c);


        for(int[] m : mat){
            for(int i = 1; i < m.length ; i++)
                m[i] += m[i-1];
        }
        for(int i = 0; i < mat[0].length ; i++){
            for(int j = 1; j < mat.length ; j++){
                mat[j][i] += mat[j-1][i];
            }
        }

        int s = 1;
        int e = len;

        while(s <= e){
            int mid = s + ((e - s) >> 1);

            int x = r - mid;
            int y = c - mid;
            int min = Integer.MAX_VALUE;
            for(int i = 0 ; i <= x ;i++){
                for(int j = 0 ; j <= y ; j++){
                    int m = i + mid - 1;
                    int n = j + mid - 1;

                    int sum = mat[m][n]
                            - (i == 0 ? 0 : mat[i-1][n])
                            - (j == 0 ? 0 : mat[m][j-1])
                            + (i == 0 || j == 0 ? 0 : mat[i-1][j-1]);
                    min = Math.min(min,sum);
                }
            }
            if(min > threshold)
                e = mid - 1;
            else
                s = mid + 1;
        }
        return e;
    }

    public static  void main(String[] args){
        System.out.print(new LeetCode1292().maxSideLength(
                new int[][]{{1,1,3,2,4,3,2},{1,1,3,2,4,3,2}},4
        ));
    }
}
