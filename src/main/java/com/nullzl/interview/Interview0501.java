package com.nullzl.interview;

public class Interview0501 {

    public int insertBits(int N, int M, int i, int j) {

        int tmp = (int)((1L << (j + 1)) - (1L << i));
        return N & (~tmp) | M;
    }

    public static void main(String[] args){
         System.out.println(4 << -30   );
    }
}
