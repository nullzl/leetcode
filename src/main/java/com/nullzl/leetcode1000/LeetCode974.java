package com.nullzl.leetcode1000;

import java.util.HashMap;
import java.util.Random;

public class LeetCode974 {

    public int subarraysDivByK(int[] A, int K) {
        A[0] %= K;
        A[0] = A[0] < 0 ? K + A[0] : A[0];
        for(int i = 1 ; i < A.length ; i++) {
            A[i] = (A[i - 1] + A[i]) % K;
            A[i] = A[i] < 0 ? K + A[i] : A[i];
        }

        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int count = 0;
        for(int i = 0 ; i < A.length ; i++){
            int tmp = map.getOrDefault(A[i],0);
            count += tmp;
            map.put(A[i],tmp + 1);
        }
        return count;
    }

    public static void main(String[] args){
        Random r = new Random();
        LeetCode974 l = new LeetCode974();
        for(int k = 0 ; k < 10000 ; k++){
            int len = r.nextInt(100) + 1;
            int[] arr = new int[len];
            for(int i = 0 ; i < len ; i++)
                arr[i] = r.nextInt(10000) - 10000;
            int K = r.nextInt(100) + 1;
            int[] b = new int[len];
            System.arraycopy(arr,0,b,0,len);
            int count = l.subarraysDivByK(b,K);
            int rs = 0;
            for(int i = 0 ; i < len ; i++){
                for(int j = i ; j < len ; j++){
                    int sum = 0;
                    for(int x = i ; x <= j; x++)
                        sum = (sum + arr[x]) % K;
                    if(0 == sum)
                        rs++;
                }
            }
            if(rs != count) {
                System.out.println(k + "\t" + len + "\t" + K + "\t" + count + "\t" + rs + "\terror");
                break;
            }else{
                System.out.println(k + "\t" + len + "\t" + K + "\t" + count + "\t" + rs + "\tok");
            }
        }
    }
}
