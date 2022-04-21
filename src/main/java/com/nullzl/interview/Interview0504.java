package com.nullzl.interview;

public class Interview0504 {

    public int[] findClosedNumbers(int num) {

        int big = -1 , small = -1;
        int n = num;
        int m = ~num;
        int count = 0;
        while(0 != n){
            int lowbit = n & (-n);
            n = n & (n - 1);
            count++;
            if(-1 == small && 1 != lowbit && 0 != ((lowbit >> 1) & m)){
                int tmp = lowbit;
                small = n;
                for(int i = 0 ;i < count ; i++){
                    tmp >>>= 1;
                    small |= tmp;
                }
            }

            if(-1 == big && (1 << 30) != lowbit && 0 != ((lowbit << 1) & m)){
                big = n | (lowbit << 1);
                int tmp = 1;
                for(int i = 1 ; i < count ; i++){
                    big |= tmp;
                    tmp <<= 1;
                }
            }

            if(-1 != small && -1 != big)
                break;
        }
        return new int[]{big,small};
    }
}
