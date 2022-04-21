package com.nullzl.offer;

public class Offer61 {

    public boolean isStraight(int[] nums) {
        boolean[] map = new boolean[14];
        for (int num : nums) {
            if (0 != num && map[num])
                return false;
            map[num] = true;
        }

        int i = 1, j = map.length - 1;
        for(; i < map.length && ! map[i] ; i++);
        for(; j > 0 && !map[j] ; j--);
        if(i <= j && j - i + 1 > nums.length)
            return false;
        return true;
    }
}
