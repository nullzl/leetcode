package main.java.com.nullzl.leetcode1500;

import java.util.LinkedList;
import java.util.Random;

public class LeetCode1438 {

    //优化：使用数组实现双端队列
    public int longestSubarray(int[] nums, int limit) {

        if(null == nums || 0 == nums.length)
            return 0;

        //初始：范围0-0，范围内差绝对值<=limit
        int s = 0;
        int maxLen = 1;
        int[] max = new int[nums.length];
        int[] min = new int[nums.length];
        int s1 = 0,s2 = 0;
        int e1 = 0, e2 = 0;
        max[0] = 0;
        min[0] = 0;

        for(int i = 1; i < nums.length ; i++){
            if(nums[i] > nums[max[s1]])
                e1 = s1 - 1;
            else{
                while(e1 >= s1 && nums[max[e1]] <= nums[i])
                    e1--;
            }
            max[++e1] = i;

            if(nums[i] < nums[min[s2]])
                e2 = s2 - 1;
            else{
                while(e2 >= s2 && nums[min[e2]] >= nums[i])
                    e2--;
            }
            min[++e2] = i;

            if(s1 == e1){
                while(nums[max[s1]] - nums[min[s2]] > limit)
                    s = min[s2++] + 1;
            }else{
                while(nums[max[s1]] - nums[min[s2]] > limit)
                    s = max[s1++] + 1;
            }

            maxLen = Math.max(maxLen,i - s + 1);
        }
        return maxLen;

    }



    public int longestSubarray1(int[] nums, int limit) {

        if(null == nums || 0 == nums.length)
            return 0;

        //初始：范围0-0，范围内差绝对值<=limit
        int s = 0;
        int maxLen = 1;
        LinkedList<Integer> maxQueue = new LinkedList<>();
        LinkedList<Integer> minQueue = new LinkedList<>();
        maxQueue.offerLast(0);
        minQueue.offerLast(0);

        for(int i = 1; i < nums.length ; i++){

            //更新s-i范围内的，最大值队列和最小值队列
            if(nums[i] > nums[maxQueue.peekFirst()])
                maxQueue.clear();
            else{
                while(!maxQueue.isEmpty() && nums[maxQueue.peekLast()] <= nums[i])
                    maxQueue.pollLast();
            }
            maxQueue.offerLast(i);
            if(nums[i] < nums[minQueue.peekFirst()])
                minQueue.clear();
            else {
                while (!minQueue.isEmpty() && nums[minQueue.peekLast()] >= nums[i])
                    minQueue.pollLast();
            }
            minQueue.offerLast(i);

            //s-i范围内的差绝对值>limit时，一定是i位置出现了更小的值或者更大的值
            //出现了更小的值，最大值太大，需要缩小窗口，所以窗口去掉s-maxQueue.pollFirst()部分
            if(1 != maxQueue.size()){
                while(nums[maxQueue.peekFirst()] - nums[minQueue.peekFirst()] > limit)
                    s = maxQueue.pollFirst() + 1;
            }
            //出现了更大的值，最小值太小，需要缩小窗口，所以窗口去掉s-minQueue.pollFirst()部分
            if(1 != minQueue.size()){
                while(nums[maxQueue.peekFirst()] - nums[minQueue.peekFirst()] > limit)
                    s = minQueue.pollFirst() + 1;
            }
            maxLen = Math.max(maxLen,(i - s + 1));
        }
        return maxLen;
    }

    public static void main(String[] args){
        Random r = new Random();
        int len = r.nextInt(100000) + 100;
        System.out.print("[" + (r.nextInt(1000000000) + 1));
        for(int i = 0 ;i < len ; i++){
            System.out.print("," + (r.nextInt(1000000000) + 1));
        }
        System.out.println("]\r\n" + (r.nextInt(1000000000)));
    }

}
