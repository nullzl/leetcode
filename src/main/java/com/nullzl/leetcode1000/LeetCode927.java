package com.nullzl.leetcode1000;


import java.util.Arrays;
import java.util.Random;

public class LeetCode927 {

    public int[] threeEqualParts(int[] A) {

        int[] count = new int[A.length + 1];
        int size = 0;
        for(int i = 0 ; i < A.length ; i++){
            if(1 == A[i])
                count[++size] = i;
        }

        if(0 != size % 3)
            return new int[]{-1,-1};

        if(0 == size)
            return new int[]{0,2};

        int i = 1;
        int j = size / 3 + 1;
        int k = (size / 3) * 2 + 1;

        for(int x = 1 ; x < size / 3 ; x++ ){
            int y = count[i + x] - count[i + x - 1];
            if(y != count[j + x] - count[j + x - 1] || y != count[k + x] - count[k + x - 1])
                return new int[]{-1,-1};
        }
        int zeros = A.length - count[size] - 1;
        if(count[size / 3 + 1] - count[size/3] - 1 < zeros  ||
            count[(size / 3) * 2 + 1] - count[(size / 3) * 2] - 1 < zeros)
            return new int[]{-1,-1};

        return new int[]{count[size / 3] + zeros , count[(size / 3) * 2] + zeros + 1};

    }

    public static  void main(String[] args){
        Random r = new Random();
        LeetCode927 l = new LeetCode927();
        Arrays.stream(l.threeEqualParts(new int[]{1, 0, 1, 1, 0})).forEach(System.out::println);
    }

}
