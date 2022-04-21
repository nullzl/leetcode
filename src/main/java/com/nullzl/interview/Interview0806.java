package com.nullzl.interview;

import java.util.List;

public class Interview0806 {

    public void move(List<Integer> A, List<Integer> B, List<Integer> C,int k){
        if(0 == k)
            return ;
        if(1 == k){
            int v = A.remove(A.size() - 1);
            C.add(v);
            return ;
        }
        move(A,C,B,k-1);
        int v = A.remove(A.size() - 1);
        C.add(v);
        move(B,A,C,k-1);
    }

    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {

        if(null == A || 0 == A.size())
            return ;
        move(A,B,C,A.size());
    }
}
