package com.nullzl.leetcode700;

public class LeetCode621 {

    /**
     * 首先找出相同任务的数量，数量最多的一定要隔开，数量最大的任务可能有多个
     * 假设相同任务数量最大为max，相同的个数为k
     * 如果k > n，那么这些任务直接自然排列就可以满足，其他任务直接插入即可。时间片没有浪费，就是总任务数
     * 如果k <= n，那么排列这些数量最大的任务会留下空闲时间片，其他任务可直接放置在这些空闲时间片
     */

    public int leastInterval(char[] tasks, int n) {

        int[] count = new int['Z'- 'A' + 1];
        int max = 0;
        int maxCount = 0;

        int index;
        for(int i = 0 ; i < tasks.length ; i++){
            index = tasks[i] - 'A';
            count[index]++;
            if(count[index] > max){
                max = count[index];
                maxCount = 1;
            }else if(count[index] == max)
                maxCount++;
        }

        if(maxCount > n)
            return tasks.length;
        return Math.max(
                tasks.length,
                max * maxCount + n * (max - 1) - (max - 1) * (maxCount - 1)
        );

    }
}
