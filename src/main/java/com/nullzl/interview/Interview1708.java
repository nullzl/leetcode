package com.nullzl.interview;

import java.util.Arrays;

public class Interview1708 {

    class Item{
        private int idx;
        public Item(int i){
            idx = i;
        }
    }

    public int bestSeqAtIndex(int[] height, int[] weight) {
        if(null == height || null == weight
                || 0 == height.length || 0 == weight.length || height.length != weight.length)
            return 0;
    Item[] items = new Item[height.length];
        for(int i = 0 ; i < items.length ; i++){
        items[i] = new Item(i);
    }

        Arrays.sort(items,(op1,op2) ->{
        return height[op1.idx] == height[op2.idx]
                ? weight[op2.idx] - weight[op1.idx]
                : height[op1.idx] - height[op2.idx];
    });

    int[] w = new int[weight.length];
    int size = 1;
    w[0] = weight[items[0].idx];
        for(int i = 1; i < items.length ; i++){
        int t = weight[items[i].idx];
        int s = 0, e = size - 1;
        while(s <= e){
            int mid = s + ((e - s) >> 1);
            if(w[mid] >= t)
                e = mid - 1;
            else
                s = mid + 1;
        }
        if(s == size){
            w[size++] = t;
        }else if(t < w[s])
            w[s] = t;
    }
        return size;
}
}
