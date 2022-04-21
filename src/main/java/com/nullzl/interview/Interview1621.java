package com.nullzl.interview;

import java.util.Arrays;
import java.util.HashSet;

public class Interview1621 {

    public int[] findSwapValues1(int[] array1, int[] array2) {

        if(null == array1 || 0 == array1.length || null == array2 || 0 == array2.length)
            return new int[0];

        long delta = 0;
        int i = 0;
        for(; i < array1.length && i < array2.length; i++){
            delta += ((long)array1[i] - array2[i]);
        }
        for(;i < array1.length ; i++)
            delta += array1[i];
        for(;i < array2.length ; i++)
            delta -= array2[i];

        if(0 != (delta & 1))
            return new int[0];
        Arrays.sort(array1);
        Arrays.sort(array2);
        delta >>= 1;

        i = array1.length - 1;
        int j = array2.length - 1;
        while(i >= 0 && j >= 0){
            long tmp = (long)array1[i] - array2[j];
            if(tmp == delta)
                return new int[]{array1[i],array2[j]};
            else if(tmp > delta)
                i--;
            else
                j--;
        }
        return new int[]{};
    }

    public int[] findSwapValues(int[] array1, int[] array2) {
        if(null == array1 || 0 == array1.length || null == array2 || 0 == array2.length)
            return new int[0];

        if(array1.length < array2.length)
            return findSwapValues1(array2,array2);

        long delta = 0;
        int i = 0;
        for(; i < array1.length && i < array2.length; i++){
            delta += ((long)array1[i] - array2[i]);
        }
        for(;i < array1.length ; i++)
            delta += array1[i];
        for(;i < array2.length ; i++)
            delta -= array2[i];

        if(0 != (delta & 1))
            return new int[0];
        delta >>= 1;
        HashSet<Long> set = new HashSet<>();
        for(int num : array2){
            if(!set.contains(num))
                set.add((long)num);
        }
        for(int num : array1){
            if(set.contains(num - delta))
                return new int[]{num,(int)(num-delta)};
        }
        return new int[]{};
    }

    public static void main(String[] args){
        System.out.println(Integer.MAX_VALUE);
    }
}
