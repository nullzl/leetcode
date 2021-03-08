package com.nullzl.leetcode300;

public class LeetCode201 {

    public int rangeBitwiseAnd1(int m, int n) {

        if(m < 0 || n < 0 || n < m)
            return 0;
        if(0 == m)
            return 0;
        if(m == n)
            return m;

        int rs = 0;
        int k = 30;
        int temp1,temp2;
        while( k >= 0){
            temp1 = 1 & (m >> k);
            temp2 = 1 & (n >> k);
            if(temp1 == temp2){
                k--;
                rs = rs << 1;
                rs = rs | temp1;
            }else{
                break;
            }
        }
        return rs << (k + 1);
    }

    public int rangeBitwiseAnd(int m, int n) {

        if (m < 0 || n < 0 || n < m)
            return 0;
        if (0 == m)
            return 0;
        if (m == n)
            return m;
        int k = 31;
        int num = 0x40000000;
        while(k > 0){
            if((num & m) == (num & n)) {
                k--;
                num = num >> 1;
            }
            else
                break;
        }
        return (m >> k) << k;
    }
    public static void main(String[] args){
        System.out.println(new LeetCode201().rangeBitwiseAnd(2147483600,2147483647));
    }
}
