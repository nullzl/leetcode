package com.nullzl.leetcode800;

import java.util.PriorityQueue;
import java.util.Random;

public class LeetCode786 {


    //如果使用堆，相当于多路归并的过程，时间复杂度为Klgn, n2lgn
    //使用二分法，可以线性时间内找出小于等于mid的数量，所以时间复杂度为nlg（值域），为数组长度*取值范围
    //二分法的取值范围不好确定
    private int compare(int[] p1,int[] p2){
        long t1 = (long)p1[0] * p2[1];
        long t2 = (long)p2[0] * p1[1];
        if(t1 == t2)
            return 0;
        if(t1 < t2)
            return -1;
        return 1;
    }



    public int[] kthSmallestPrimeFraction1(int[] A, int K) {

        int size = A.length - 1;
        int[] s = new int[2];
        int[] e = new int[2];
        int[] mid = new int[2];
        int[] p = new int[2];
        int[] min = new int[2];
        int[] max = new int[2];
        e[0] = A[0];
        e[1] = A[1];
        s[0] = A[0];
        s[1] = A[size];
        for(int i = 2 ; i <= size ; i++){
            p[0] = A[i-1];
            p[1] = A[i];
            if(compare(p,e) > 0){
                int[] tmp = p;
                p = e;
                e = p;
            }
        }

        while(compare(s,e) < 0){
            mid[0] = s[0] * e[1] + s[1] * e[0];
            mid[1] = (s[1] * e[1]) << 1;
            max[0] = s[0];
            max[1] = s[1];
            min[0] = e[0];
            min[1] = e[1];
            int count = 0;
            int k = 0;
            for(int i = 1 ; i <= size ; i++){
                while(k < i){
                    p[0] = A[k];
                    p[1] = A[i];
                    if(compare(p,mid) <= 0)
                        k++;
                    else
                        break;
                }
                if(k-1 >= 0 && compare(new int[]{A[k-1],A[i]},max) > 0){
                    max[0] = A[k-1];
                    max[1] = A[i];
                }
                if(k < i && compare(new int[]{A[k],A[i]},min) < 0){
                    min[0] = A[k];
                    min[1] = A[i];
                }
                count += k;
            }

            if(count == k)
                return max;
            if(count < k){
                s[0] = min[0];
                s[1] = min[1];
            }else{
                e[0] = max[0];
                e[1] = max[1];
            }
        }
        return s;
    }



    public int[] kthSmallestPrimeFraction(int[] A, int K) {
        PriorityQueue<int[]> heap = new PriorityQueue<int[]>((p1,p2) ->{
            return A[p1[0]] * A[p2[1]] - A[p2[0]] * A[p1[1]];
        });
        for(int i = 1 ; i < A.length ; i++)
            heap.offer(new int[]{0,i});

        while(!heap.isEmpty()){
            int[] low = heap.poll();
            int[] top = heap.isEmpty() ? null : heap.peek();
            if(null == top){
                return new int[]{A[low[0] + K - 1],A[low[1]]};
            }
            low[0]++;K--;
            while(low[0] < low[1] && 0 != K && A[low[0]] * A[top[1]] <= A[top[0]] * A[low[0]]){
                low[0]++;
                K--;
            }
            if(0 == K){
                return new int[]{A[low[0] - 1],A[low[1]]};
            }
            if(low[0] < low[1])
                heap.offer(low);
        }
        return new int[2];
    }


    private boolean isN(int k){
        for(int i = 2 ; i <= k / 2 ; i++){
            if(0 == k % i)
                return false;
        }
        return true;
    }

    public static void main(String[] args){
        int[] a = new int[30000];
        Random r = new Random();
        LeetCode786 l = new LeetCode786();
        a[0] = 1;
        a[1] = 2;
        int size = 2;
        for(int i = 3 ; i <= 30000 ; i+=2){
            if(l.isN(i))
                a[size++] = i;
        }
        for(int i = 0 ; i < 10000 ; i++){
            int len = r.nextInt(size - 1) + 2;
            int[] A = new int[len];
            A[0] = 1;
            int pre = 0;
            for(int k = 1 ; k < len ; k++){
                int left = len - k - 1;
                int t = r.nextInt(size - left - pre - 1 )  + pre + 1;
                A[k] = a[t];
                pre = t;
            }

            int m = r.nextInt((len * (len - 1)) / 2) + 1;
            int[] rs1 = l.kthSmallestPrimeFraction(A,m);
            int[] rs2 = l.kthSmallestPrimeFraction1(A,m);
            if(rs1[0] == rs2[0] && rs1[1] == rs2[1]){
                System.out.println(i + "\t" + len + "\t" + m + "\t" + rs1[0] + "\t" + rs1[1] + "\t" + rs2[0] + "\t" + rs2[0] + "\tok");
            }else{
                System.out.println(i + "\t" + len + "\t" + m + "\t" + rs1[0] + "\t" + rs1[1] + "\t" + rs2[0] + "\t" + rs2[0] + "\terror");
                break;
            }
        }
    }
}
