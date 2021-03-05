package com.nullzl.leetcode800;

import com.nullzl.util.Util;

import java.util.Random;

public class LeetCode717 {


    public boolean isOneBitCharacter(int[] bits) {
        int last = bits.length - 1;
        if(last == 0 || 0 == bits[last - 1])
            return true;
        int i;
        for(i = last - 2 ; i >= 0 && 1 == bits[i] ; i--);

        return 0 == ((last - 1 - i) & 1);
    }

    public static void main(String[] args){
        Random r = new Random();
        int len  = r.nextInt(1000) + 1;
        System.out.println(Util.generateRandomArray(1000,0,2));

    }
}
