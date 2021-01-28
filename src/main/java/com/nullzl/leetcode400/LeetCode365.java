package com.nullzl.leetcode400;

public class LeetCode365 {

    public boolean canMeasureWater(int x, int y, int z) {

        if(z > x + y)
            return  false;
        if(0 == z || z == x || z == y || z == x + y)
            return true;
        if(0 == x || 0 == y )
            return false;

        if(x > y)
            return canMeasureWater(y,x,z);
        if(0 == z % x)
            return true;
        int a = z % x;
        int b = y % x;
        int c = b;
        while(0 != c){
            if(a == c)
                return true;
            c = (c + b) % x;
        }
        return false;
    }
    public static void main(String[] args){
        System.out.print(new LeetCode365().canMeasureWater(13,11,1));
    }
}
