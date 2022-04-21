package com.nullzl.interview;

public class Interview1723 {

    public int[] findSquare(int[][] matrix) {
        if(null == matrix || 0 == matrix.length)
            return new int[0];

        int[][] len1 = new int[matrix.length][matrix.length];
        int[][] len2 = new int[matrix.length][matrix.length];

        for(int i = 0 ; i < matrix.length ; i++){
            int j = 0;
            while(j < matrix.length){
                if(1 == matrix[i][j]){
                    len1[i][j] = 0;
                    len2[i][j] = 0;
                    j++;
                    continue;
                }
                int k = j + 1;
                while (k < matrix.length && 0 == matrix[i][k]) k++;
                int m = j;
                while (j < k){
                    len1[i][j] = k - j;
                    len2[i][j] = j - m + 1;
                    j++;
                }
            }
        }
        int max = 0;
        for(int j = 0 ; j < matrix.length ; j++){
            int i = 0;
            while(i < matrix.length){
                if(1 == matrix[i][j]) {
                    i++;
                    continue;
                }
                int k = i + 1;
                while(k < matrix.length && 0 == matrix[k][j]) k++;
                int m = i;
                while(i < k){
                    len1[i][j] = Math.min(len1[i][j],k - i);
                    len2[i][j] = Math.min(len2[i][j],i - m + 1);
                    max = Math.max(max,Math.max(len1[i][j],len2[i][j]));
                    i++;
                }
            }
        }

        for(int k = max ; k >= 1 ; k--){
            for(int i = 0 ; i + k - 1 < matrix.length ; i++){
                for(int j = 0 ; j + k - 1 < matrix.length ; j++){
                    if(len1[i][j] >= k && len2[i + k - 1][j + k - 1] >= k)
                        return new int[]{i,j,k};
                }
            }
        }
        return new int[0];
    }
}
