package com.nullzl.leetcode600;

import java.util.Arrays;
import java.util.Random;

public class LeetCode546 {

    int[][][] count;

    class Pair{
        int key;
        int count;

        public Pair(int k){
            key = k;
            count = 1;
        }
    }

    private int next(Pair[] ps,int s,int e,int k){
        for(int i = s ; i < e ; i++){
            if(ps[i].key == ps[k].key)
                return i;
        }
        return -1;
    }

    private int get(int[][][] count , int i , int j , int k){
        if(i > j)
            return 0;
        return count[i][j][k];
    }

    public int removeBoxes(int[] boxes) {
        Pair[] ps = new Pair[boxes.length];
        ps[0] = new Pair(boxes[0]);
        int size = 0;
        for(int i = 1; i < boxes.length ; i++){
            if(boxes[i] == ps[size].key)
                ps[size].count++;
            else{
                ps[++size] = new Pair(boxes[i]);
            }
        }
        ++size;
        count = new int[size][size][boxes.length + 1];
        for(int s = 0 ; s < size ; s++){
            for(int i = size - s - 1 ; i >= 0 ; i--){
                int j = i + s;
                Arrays.fill(count[i][j],-1);
                count[i][j][0] = get(count,i,j-1,0) + ps[j].count * ps[j].count;
                count[i][j][ps[j].count] = get(count,i,j-1,0);
                for(int k = next(ps,i,j,j) ; k != -1 ; k = next(ps,k + 1 ,j,j)){
                    for(int x = 1 ; x < count[i][k].length ; x++){
                        if(-1 == count[i][k][x])
                            continue;
                        count[i][j][0] = Math.max(count[i][j][0],
                                count[i][k][x] + get(count,k + 1,j-1,0) + (x + ps[j].count) * (x + ps[j].count));
                        count[i][j][x + ps[j].count] = Math.max(count[i][j][x + ps[j].count],
                                count[i][k][x] + get(count,k + 1,j-1,0));
                    }
                }
            }
        }
        return count[0][size-1][0];
    }

    public static void main(String[] args){
        Random r = new Random();
        int[] nums = new int[]{1,3,2,2,2,3,4,3,1};

        System.out.println("\r\n" + new LeetCode546().removeBoxes(nums));
    }
}
