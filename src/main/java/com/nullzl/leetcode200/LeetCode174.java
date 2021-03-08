package com.nullzl.leetcode200;

public class LeetCode174 {

    private int getMininumHP(int hp,int min){
        if(0 == min && hp < 1)
            min = 1 - hp;
        else{
            min = min - hp;
            min = min < 0 ? 0 : min;
        }
        return min;
    }

    public int calculateMinimumHP(int[][] dungeon) {

        if(null == dungeon || 0 == dungeon.length
                || null == dungeon[0] || 0 == dungeon[0].length)
            return 0;

        int[] p = new int[dungeon[0].length];
        int rows = dungeon.length;
        int columns = dungeon[0].length;
        p[columns - 1] = getMininumHP(dungeon[rows-1][columns-1],0);
        for(int i = columns - 2; i >= 0 ; i--){
            p[i] = getMininumHP(dungeon[rows-1][i],p[i+1]);
        }

        int temp1,temp2;
        for(int i = rows - 2; i >= 0 ; i--){
            p[columns - 1] = getMininumHP(dungeon[i][columns - 1],p[columns - 1]);
            for(int j = columns - 2; j >= 0 ; j--){
                p[j] = Math.min(getMininumHP(dungeon[i][j],p[j]),
                        getMininumHP(dungeon[i][j],p[j+1]));
            }
        }
        return p[0] == 0 ? 1 : p[0];
    }

    public static void main(String[] args){
        System.out.println(new LeetCode174().calculateMinimumHP(
                new int[][]{
                        {-2,-3,3}
                }
        ));
    }
}
