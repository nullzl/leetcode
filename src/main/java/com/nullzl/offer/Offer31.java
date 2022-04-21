package com.nullzl.offer;

public class Offer31 {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if(null == pushed && null == popped)
            return true;
        if(null == pushed || null == popped || pushed.length != popped.length)
            return false;

        boolean[] map = new boolean[1000];
        int[] stk = new int[1000];
        int i = 0 , j = 0,top = -1;

        while(j < popped.length){
            if(-1 != top && stk[top] == popped[j]) {
                j++;top--;
            }
            else if(map[popped[j]])
                return false;
            else if(i < pushed.length)
                stk[++top] = pushed[i++];
            else
                return false;
        }
        return true;
    }
}
