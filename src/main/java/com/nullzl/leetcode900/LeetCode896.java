package com.nullzl.leetcode900;

public class LeetCode896 {

    public boolean isMonotonic(int[] A) {
        if(1 == A.length)
            return true;
        int s,e,step;
        int last = A.length - 1;
        if(A[0] <= A[last]){
            s = 1;
            e = last;
            step = 1;
        }else{
            s = last - 1;
            e = 0;
            step = -1;
        }

        for( ; s != e ; s += step){
            if(A[s] < A[s - step])
                return false;
        }

        return A[s] >= A[s - step];

    }
}
