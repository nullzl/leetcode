package com.nullzl.leetcode500;

import java.util.HashMap;
import java.util.Random;

public class LeetCode446 {

    class Pair{
        int count;
        int candidate;
    }

    public int numberOfArithmeticSlices(int[] A) {
        if(A.length < 3)
            return 0;

        HashMap<Long,Pair>[] maps = new HashMap[A.length];
        maps[0] = new HashMap<>();
        int total = 0;
        for(int i = 1; i < A.length ; i++){
            maps[i] = new HashMap<>();
            for(int j = 0 ; j < i ; j++){
                long diff = A[i] - A[j];
                Pair p = maps[i].getOrDefault(diff,new Pair());
                Pair count = maps[j].getOrDefault(diff,null);
                if(null != count){
                    p.count += (count.count + count.candidate );
                    total += (count.count + count.candidate );
                }
                p.candidate++;
                maps[i].put(diff,p);
            }
        }
        return total;
    }

    public static void main(String[] args){
        Random r = new Random();
        for(int i = 0 ; i < 500 ; i++){
            System.out.print(r.nextInt()+",");
        }
    }
}
