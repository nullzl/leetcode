package com.nullzl.leetcode1700;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

public class LeetCode1601 {

    public boolean check(int set,int[][] requests,int[] count){
        Arrays.fill(count,0);
        for(int i = 0 ; i < requests.length ; i++){
            if(0 != ((1 << i) & set)){
                count[requests[i][0]]--;
                count[requests[i][1]]++;
            }
        }
        for(int cnt : count){
            if(cnt != 0)
                return false;
        }
        return true;
    }

    public int maximumRequests(int n, int[][] requests) {
        int[] count = new int[n];
        int k = requests.length;
        int max = (1 << k) - 1;
        int[] bits = new int[max + 1];
        for(int i = 0 ; i < (max >> 1) ; i++){
            bits[i << 1] = bits[i];
            bits[(i << 1)  + 1] = bits[i] + 1;
        }
        bits[(max >> 1) << 1] = bits[(max >> 1)];
        if(0 != (max & 1)){
            bits[max] = bits[(max >> 1)] + 1;
        }
        LinkedList<Integer>[] list =new LinkedList[k + 1];
        for(int i = 0 ; i < list.length; i++){
            list[i] = new LinkedList<>();
        }
        for(int i = 0 ; i < bits.length; i++){
            list[bits[i]].add(i);
        }

        for(int i = list.length - 1 ; i >= 0 ; i--){
            LinkedList<Integer> item = list[i];
            Iterator<Integer> iterator = item.iterator();
            while(iterator.hasNext()){
                int set = iterator.next();
                if(check(set,requests,count))
                    return i;
            }
        }
        return 0;
    }

    public static void main(String[] args){
        Random r = new Random();
        int n = 20;
        System.out.println(n);
        System.out.print("[");
        int k = 16;
        int[][] data = new int[k][2];
        for(int i = 0 ; i < k ; i++){
            data[i][0] = r.nextInt(n);
            data[i][1] = r.nextInt(n);
            System.out.print("[" + data[i][0] + "," + data[i][1] + "],");
        }
        System.out.println("]");
    }
}
