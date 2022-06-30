package com.nullzl.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Offer2_80 {

    private int init(int k){
        return (1 << k) - 1;
    }


    private List<Integer> generate(int n, int set){
        List<Integer> list = new ArrayList<>(n);
        for(int i = 1 ; i <= n && 0 != set; i++){
            if(0 != (1 & set))
                list.add(i);
            set >>= 1;
        }
        return list;
    }

    private int next(int set,int len){
        int prev = set & 1;
        int cur = 2;
        int i = 1;
        int count = (prev == 0 ? 0 : 1);
        for(; i < len ; i++){
            int temp = cur & set;
            if(0 == temp && 0 != prev)
                break;
            if(0 != temp)
                count++;
            prev = temp;
            cur <<= 1;
        }
        if(i == len)
            return -1;
        return ((~((1 << (i + 1)) - 1)) | set) & (1 << i) | ((1 << (count - 1)) - 1);
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> lists = new LinkedList<>();
        int set = init(k);
        while(-1 != set){
            lists.add(generate(n,set));
            set = next(set,n);
        }
        return lists;
    }
}
