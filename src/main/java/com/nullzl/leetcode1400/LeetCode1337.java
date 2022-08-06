package com.nullzl.leetcode1400;

import java.util.Arrays;
import java.util.Random;

public class LeetCode1337 {

    public int[] kWeakestRows(int[][] mat, int k) {
        int[] count = new int[mat.length * (mat[0].length + 1)];
        Arrays.fill(count,-1);
        for (int i = 0; i < mat.length; i++) {
            for (int j = 1; j < mat[i].length; j++) {
                if (1 == mat[i][j])
                    mat[i][0]++;
                else
                    break;
            }
            count[mat[i][0] * mat.length + i] = i;
        }
        int[] rs = new int[k];
        int i = 0;
        for(int j = 0 ; j < count.length && i < k ; j++){
            if(-1 == count[j])
                continue;
            rs[i++] = count[j];
        }
        return rs;
    }

    public static void main(String[] args){
        Random r = new Random();
        LeetCode1337 l = new LeetCode1337();
        outer:
        for(int i = 0 ; i < 10000 ; i++){
            int m = r.nextInt(100) + 2;
            int n = r.nextInt(100) + 2;
            int[][] arr = new int[m][n];
            int[] tmp = new int[m];
            for(int x = 0 ;  x < m ; x++){
                int k = r.nextInt(n + 1);
                for(int y = 0 ; y < k ; y++){
                    arr[x][y] = 1;
                }
                tmp[x] = k;
            }
            int a = r.nextInt(m) + 1;
            int[] rs = l.kWeakestRows(arr,a);

            Pair[] ps = new Pair[m];
            for(int x = 0; x < m ; x++){
                ps[x] = new Pair(x);
            }
            Arrays.sort(ps,(p1,p2) ->{
                if(tmp[p1.index] == tmp[p2.index])
                    return p1.index - p2.index;
                return tmp[p1.index] - tmp[p2.index];
            });

            for(int x = 0 ; x < a ; x++){
                if(rs[x] != ps[x].index){
                    System.out.println(i + "\terror");
                    break outer;
                }
            }
            System.out.println(i + "\tok");
        }
    }
}

class Pair{
    int index;
    public Pair(int i){
        index = i;
    }
}
