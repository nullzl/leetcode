package com.nullzl.leetcode600;

public class LeetCode600 {

    /**
     * 从0开始，上一个不连续出现11到下一个不连续出现11的规律：
     * 1. 从最低开始找，两个连续的00
     * 2. 把低位的0变为1，比0更低位的数全变为0
     * 结果：超时
     */
    public int findIntegers1(int num) {

        if(num < 1)
            throw new IllegalArgumentException();

        int count = 1;
        int n = 1;
        int val,cur,pre,i,temp;
        while(n <= num){
            count++;
            val = 0xFFFFFFFE;
            cur = 1;
            pre = 2;
            i = 1;
            while(i <= 31){
                temp = ~n;
                if((0 != (temp & cur)) && (0 != (temp & pre)))
                    break;
                cur = cur << 1;
                pre = pre << 1;
                val = val << 1;
                i++;
            }
            if(32 == i)
                break;
            n = (val & n) | cur;
        }
        return count;
    }

    /**
     * f(n)表示，从低位开始数，第n位为1，比n位高的都为0，不连续1的个数
     * f(0) = f(1) = f(2) = 1， f(n) = f(0) + f(1) + ... + f(n-2) = f(n-1) + f(n-2)
     *      n为1，n-1位0，其他位不连续1的个数
     * 给定一个数num，从高位开始找这个数最高为1的位置k
     * f(0)+f(1)+...+f(k),其中包含了一部分大于num的数，需要找出大于num的数量
     * 找出方法，初始count=0
     *     从高到低，从高位为1的位置的下一个位置开始
     *     如果当前位置为1，前一个位置为1，则结束
     *     如果当前位置为1，前一个位置为0，则继续找下一个位置
     *     如果当前位置为0，前一个位置为1，继续找下一个位置
     *     如果当前位置为0，前一个位置为0，当前位置在第m个，则count+=f(m),继续下一个位置
     */
    public int findIntegers(int num) {

        if(num < 1)
            throw new IllegalArgumentException();

        int val = 0x40000000;
        int size = 31;
        int minusCount = 0;
        int preBit = 1;
        int curBit = 0;
        int[] count = new int[32];
        count[0] = 1;
        count[1] = 1;
        count[2] = 1;
        while(size >= 1){
            if(0 != (val & num))
                break;
            val = val >> 1;
            size--;
        }
        for(int j = 3 ; j <= size ; j++){
            count[j] = count[j-1] + count[j-2];
        }
        val = val >> 1;
        for(int j = size - 1; j >= 1 ;j--){
            curBit = (val & num) == 0 ? 0 : 1;
            if(1 == curBit && 1 == preBit)
                break;
            else if(0 == curBit && 0 == preBit){
                minusCount += count[j];
            }
            preBit = curBit;
            val = val >> 1;
        }
        int totalCount = 0;
        for(int j = 0 ; j <= size ; j++)
            totalCount += count[j];
        return totalCount - minusCount;

    }

    public static void main(String[] args){
        System.out.println(Integer.toBinaryString(0x7FFFFFFF));
        System.out.println(new LeetCode600().findIntegers(0x40000000));
        System.out.println(new LeetCode600().findIntegers1(0x40000000));
    }
}
