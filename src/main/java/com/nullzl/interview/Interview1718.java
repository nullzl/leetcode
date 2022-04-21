package com.nullzl.interview;

import java.util.HashMap;

public class Interview1718 {

    public int[] shortestSeq(int[] big, int[] small) {

        if(null == big || 0 == big.length || big.length < small.length)
            return new int[0];

        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num : small)
            map.put(num,0);
        int count = 0;
        int slow = 0, fast = 0;
        int s = -1;
        int min = big.length + 1;
        for(; fast < big.length; fast++){
            int v = map.getOrDefault(big[fast],-1);
            if(-1 != v){
                count += (0 == v ? 1 : 0);
                v++;
                map.put(big[fast],v);
            }
            while(slow <= fast){
                v = map.getOrDefault(big[slow],-1);
                if(-1 == v)
                    slow++;
                else if(v > 1){
                    v--;
                    map.put(big[slow++],v);
                }else
                    break;
            }
            if(small.length == count){
                if(fast - slow + 1 < min){
                    min = fast - slow + 1;
                    s = slow;
                }
                count--;
                map.put(big[slow++],0);
            }
        }
        return -1 == s ? new int[0] : new int[]{s,s + min - 1};
    }
}
