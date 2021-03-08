package com.nullzl.leetcode500;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class LeetCode406 {

    /**
     * 最小的数，最好确定位置，假设最小的数只有一个为[h,k],那么[h,k]就应该在k的位置上
     * 1. 首先升序排序，排序有序优先级（h,k)
     * 2. 遍历排序，对于某个(h,k),假设前面有n个身高等于h，则(h,k)的最终位置为第k - n个空位置
     *      是第k-n个空位置，已放置的位置不考虑
     *
     */


    public int[][] reconstructQueue1(int[][] people) {

        if(null == people || 0 == people.length || 2 != people[0].length
        || 1 == people.length)
            return people;

        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0])
                    return Integer.compare(o1[1],o2[1]);
                else
                    return Integer.compare(o1[0],o2[0]);
            }
        });

        int[][] rs = new int[people.length][2];
        boolean[] flag = new boolean[people.length];
        int index,x,y,equalCount = 0;
        rs[people[0][1]][0] = people[0][0];
        rs[people[0][1]][1] = people[0][1];
        flag[people[0][1]] = true;

        for(int i = 1 ; i < people.length ; i++){
            if(people[i][0] == people[i-1][0])
                equalCount++;
            else
                equalCount = 0;
            index = people[i][1] - equalCount;
            y = 0;
            for(x = 0; x < rs.length ; x++){
                if(flag[x])
                    continue;
                if(y == index){
                    rs[x][0] = people[i][0];
                    rs[x][1] = people[i][1];
                    flag[x] = true;
                    break;
                }else{
                    y++;
                }

            }
        }
        return rs;
    }

    /**
     * 1. 对高个子来说，所有的矮个子都不产生影响
     * 2. 所以身高按高到低处理，在某个人前面放置了k个更高身高的人，
     *      后面处理的都是矮个子，不管插入到哪里，都不会影响这个人
     * 3. 对于相同个子的人，也是一样的
     */
    public int[][] reconstructQueue(int[][] people) {

        if(null == people || 0 == people.length || 2 != people[0].length
                || 1 == people.length)
            return people;

        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0])
                    return Integer.compare(o2[1],o1[1]);
                else
                    return Integer.compare(o1[0],o2[0]);
            }
        });

        List<int[]> list = new LinkedList<int[]>();
        for(int i = people.length - 1 ; i >= 0 ;i--){
            list.add(people[i][1],people[i]);
        }
        return list.toArray(people);

    }

    public static void main(String[] args){
        int[][] rs = new LeetCode406().reconstructQueue(
                new int[][]{
                        {7,0},
                        {4,4},
                        {7,1},
                        {5,0},
                        {6,1},
                        {5,2}
                }
        );
        for(int i = 0 ; i < rs.length  ;i++){
            System.out.println(rs[i][0] + "\t" + rs[i][1]);
        }
    }
}
