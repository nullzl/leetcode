package com.nullzl.leetcode1600;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Random;

public class LeetCode1505   {

    int[] count;

    public void add(int n , int v){
        n++;
        while(n < count.length){
            count[n] += v;
            n += (n & (-n));
        }
    }
    public int get(int n){
        n++;
        int sum = -1;
        while(0 != n){
            sum += count[n];
            n = n & (n - 1);
        }
        return sum;
    }


    public String minInteger(String num, int k) {
        count = new int[num.length()  + 1];
        for(int i = 0 ; i < num.length() ; i++)
            add(i,1);
        int i = 0;
        char[] arr = num.toCharArray();
        PriorityQueue<int[]> heap = new PriorityQueue<>((op1,op2) ->{
            if(op1[0] == op2[0])
                return Integer.compare(op1[1],op2[1]);
            return Integer.compare(op1[0],op2[0]);
        });
        int j = 0;
        for(;i < arr.length && i <= j + k;i++)
            heap.offer(new int[]{arr[i] - '0',i});
        char[] ans = new char[arr.length];
        PriorityQueue<int[]> set = new PriorityQueue<>((op1,op2) ->{
            return Integer.compare(op1[1],op2[1]);
        });
        while(k > 0 && (!heap.isEmpty() || !set.isEmpty())){
            int[] t;
            int idx;
            if(!set.isEmpty() && get(set.peek()[1]) <= k){
                t = set.poll();
                idx = get(t[1]);
            }else{
                while(!heap.isEmpty() && get(heap.peek()[1]) > k){
                    set.offer(heap.poll());
                }
                t = heap.poll();
                idx = get(t[1]);
            }

            ans[j++] = arr[t[1]];
            add(t[1],-1);
            k -= idx;

            for(;i < arr.length && get(i) <= k;i++)
                heap.offer(new int[]{arr[i] - '0',i});

        }

        Iterator<int[]> iterator = heap.iterator();
        while(iterator.hasNext()){
            int[] t = iterator.next();
            ans[j + get(t[1])] = arr[t[1]];
        }
        iterator = set.iterator();
        while(iterator.hasNext()){
            int[] t = iterator.next();
            ans[j + get(t[1])] = arr[t[1]];
        }
        for(;i < arr.length ; i++){
            ans[i] = arr[i];
        }

        return new String(ans);
    }

    public static void main(String[] args){
        Random r = new Random();
        int len = 20000 + r.nextInt(5000);
        System.out.print("\"");
        char[] arr = new char[len];
        for(int i = 0 ;i < len ; i++){
            arr[i] = (char)('0' + r.nextInt(10));
        }
        System.out.println(new String(arr) + "\"");
        System.out.println(r.nextInt(1000000));
    }

}
