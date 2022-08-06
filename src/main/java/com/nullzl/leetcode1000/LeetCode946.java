package com.nullzl.leetcode1000;

public class LeetCode946 {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int[] stk = new int[pushed.length];
        int size = 0;

        int i = 0 , j = 0;
        for( ; i < pushed.length ; i++){
            stk[size++] = pushed[i];
            while(j < popped.length && size > 0 && stk[size-1] == popped[j] ){
                size--;
                j++;
            }
        }
        return size == 0;
    }
}
