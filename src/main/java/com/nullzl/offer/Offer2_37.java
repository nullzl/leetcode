package com.nullzl.offer;

import java.util.Arrays;

public class Offer2_37 {

    public int[] asteroidCollision(int[] asteroids) {

        int i = 0 , j = 0;
        for(; j  < asteroids.length ;){
            if(0 == i
            || asteroids[j] > 0
            || asteroids[i-1] < 0 ){
                asteroids[i++] = asteroids[j++];
            }else if(0 == asteroids[i-1] + asteroids[j]){
                i--;j++;
            }else if(0 > asteroids[i-1] + asteroids[j])
                i--;
            else
                j++;
        }
        return Arrays.copyOf(asteroids,i);
    }
}
