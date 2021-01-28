package com.nullzl.leetcode800;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

class Distance{
    public int dis;
    public int next;

    public Distance(int d,int n){
        dis = d;
        next = n;
    }
}

public class LeetCode719 {

    private void swap(int[] nums,int i,int j){
        if(i != j){
            nums[i] = nums[i] ^ nums[j];
            nums[j] = nums[i] ^ nums[j];
            nums[i] = nums[i] ^ nums[j];
        }
    }

    private int partition(int[] nums,int s,int e,int k){
        if(s == e && 1 == k)
            return nums[s];
        int i = s;
        while(i < e && nums[i] <= nums[e])
            i++;
        int p = i - 1;
        for(; i < e ; i++){
            if(nums[i] <= nums[e])
                swap(nums,++p,i);
        }
        swap(nums,++p,e);
        int index = p - s + 1;
        if(index == k)
            return nums[p];
        if(index > k)
            return partition(nums,s,p - 1,k);
        else
            return partition(nums,p + 1,e,k - index);

    }

    //存储所有差值，超过内存限制
    public int smallestDistancePair1(int[] nums, int k) {

        int[] dis = new int[(nums.length * (nums.length - 1))/2];
        int x = 0;
        for(int i = 0 ; i < nums.length - 1 ; i++){
            for(int j = i + 1 ; j < nums.length ; j++){
                dis[x++] = Math.abs(nums[i] - nums[j]);
            }
        }
        return partition(dis,0,dis.length - 1,k);

    }

    //耗时长，不超时
    public int smallestDistancePair2(int[] nums, int k) {
        int max,min;
        max = min = nums[0];
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] > max)
                max = nums[i];
            else if(nums[i] < min)
                min = nums[i];
        }
        int[] dis = new int[max - min + 1];
        for(int i = 0 ; i < nums.length ; i++)
            for(int j = i + 1 ; j < nums.length ; j++)
                dis[Math.abs(nums[i] - nums[j])]++;
        int rs = 0;
        for(; rs < dis.length; rs++){
            k -= dis[rs];
            if(k <= 0 )
                break;
        }
        return rs;
    }



    public int smallestDistancePair3(int[] nums, int k) {
        Arrays.sort(nums);
        PriorityQueue<Distance> heap;
        heap = new PriorityQueue<Distance>((p1,p2) ->{
            return p1.dis - p2.dis;
        });
        int pre = nums[0];
        for(int i = 1 ; i < nums.length ; i++) {
            int tmp = nums[i];
            nums[i] = Math.abs(nums[i] - pre);
            pre = tmp;
            heap.add(new Distance(nums[i],i + 1));
        }
        Distance dis = heap.poll();
        for(int i = 1; i < k ; i++){
            if(dis.next == nums.length)
                dis = heap.poll();
            else if(nums[dis.next++] != 0){
                dis.dis += nums[dis.next - 1];
                heap.add(dis);
                dis = heap.poll();
            }
        }
        return dis.dis;

    }

    private int count(int[] nums,int mid,int k){
        int count = 0;
        int i = 0;
        int j = 1;
        while(i < nums.length - 1 && j < nums.length && count <= k){
            if(nums[j] - nums[i] <= mid){
                count += (j - i);
                j++;
            }else{
                i++;
                j = Math.max(j,i+1);
            }
        }
        return count;
    }

    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int s = 0;
        int e = nums[nums.length - 1] - nums[0];
        while(s < e){
            int mid = s + ((e - s) >> 1);
            int count = count(nums,mid,k);
            if(count >= k)
                e = mid;
            else
                s = mid + 1;
        }
        return s;
    }




    public static void main(String[] args){
        int[] nums = new int[10000];
        Random r = new Random();
        for(int i = 0 ; i < nums.length ; i++)
            nums[i] = r.nextInt(1000000);
        int[] dis = new int[(nums.length * (nums.length - 1))/2];
        int x = 0;
        for(int i = 0 ; i < nums.length - 1 ; i++){
            for(int j = i + 1 ; j < nums.length ; j++){
                dis[x++] = Math.abs(nums[i] - nums[j]);
            }
        }
        Arrays.sort(dis);
        System.out.println(dis[500000]);
        System.out.println(new LeetCode719().smallestDistancePair(nums,500000));

    }
}
