package main.java.com.nullzl.leetcode300;

import java.util.LinkedList;

public class LeetCode239 {

    /**
     * 使用双端队列入
     * 1. 增加的数，从队尾入队，并且从队尾弹出所有小于等于入队数的数
     * 2. 活动窗口需要去掉的数，如果发现与队首相同，则队首删除
     * 3. 队首时刻保持了窗口最大值
     */
    public int[] maxSlidingWindow1(int[] nums, int k) {

        if(null == nums || 0 == nums.length)
            return new int[0];

        k = Math.min(k,nums.length);
        int[] rs = new int[nums.length - k + 1];
        LinkedList<Integer> queue = new LinkedList<>();
        int i,j,t = 0;
        for(i = 0 ; i < nums.length ; i++){
            j = i - k;
            if(j >= 0){
                if(j == queue.peekFirst()){
                    queue.pollFirst();
                }
            }
            while(!queue.isEmpty() && nums[queue.peekLast()] <= nums[i])
                queue.pollLast();
            queue.addLast(i);

            if(j + 1 >= 0){
                rs[t++] = nums[queue.peekFirst()];
            }
        }
        return rs;
    }


    /**
     * 其他解法
     * 1. 将数组分为每k个一组，对于任意个窗口(i,j)，都有两种情况，正好位于一个分组，或者位于两个相邻分组
     * 2. 定义left[i],假设i所在的分组为(x,y),那么left[i]表示x到i的最大数
     * 3. 定义right[i]，假设i所在的分组为(x,y),那么right[i]表示y到i的最大数
     * 4. 对于正好位于一个分组的情况，窗口最大值为left[j]或者right[i]
     * 5. 对于位于两个分组中的情况，假设情况为(i,x)(y,j)，那么最大值为i到x的最大值即right[i]
     *      或者y到j的最大值即left[j]，所以为max{right[i],left[j]}
     */
    public int[] maxSlidingWindow(int[] nums, int k){
        if(null == nums || 0 == nums.length)
            return new int[0];
        k = Math.min(k,nums.length);
        int[] rs = new int[nums.length - k + 1];
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        int i,j=0;
        for(i = 0; i < nums.length ; i++){
            if(i % k == 0){
                left[i] = nums[i];
            }else{
                left[i] = Math.max(left[i - 1],nums[i]);
            }
        }
        right[nums.length - 1] = nums[nums.length - 1];
        for(i = nums.length - 2; i >= 0 ; i--){
            if(k - 1 == i % k)
                right[i] = nums[i];
            else
                right[i] = Math.max(right[i+1],nums[i]);
        }
        for(i = 0 ; i + k - 1 < nums.length ; i++){
            rs[j++] = Math.max(right[i],left[i + k - 1]);
        }
        return rs;

    }
}
