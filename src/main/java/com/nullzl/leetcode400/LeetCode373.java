package com.nullzl.leetcode400;

import java.util.*;

public class LeetCode373 {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        if(0 == nums1.length || 0 == nums2.length || 0 == k)
            return new ArrayList<List<Integer>>();

        int[] idx = new int[nums1.length];
        k = Math.min(k,nums1.length * nums2.length);
        ArrayList<List<Integer>> list = new ArrayList<>(k);
        long s = (long)nums1[0] + nums2[0];
        long e = (long)nums1[nums1.length - 1] + nums2[nums2.length - 1];

        while(s <= e){
            long mid = s + ((e - s) >> 1);
            int count = 0;
            int j = 0;
            for(int i = nums1.length - 1 ; i >= 0 && count <= k ; i--){
                while(j < nums2.length && (long)nums1[i] + nums2[j] <= mid) j++;
                count += j;
            }
            if(count < k)
                s = mid + 1;
            else
                e = mid - 1;
        }
        int size = 0,i,j;
        for(i = 0 ; i < nums1.length ; i++){
            for(j = 0 ; j < nums2.length && (long)nums1[i] + nums2[j] < s ; j++){
                size++;
                ArrayList<Integer> tmp = new ArrayList<>();
                tmp.add(nums1[i]);
                tmp.add(nums2[j]);
                list.add(tmp);
            }
            idx[i] = j;
        }
        i = 0;
        j = idx[i];
        while(size < k){
            if(j == nums2.length || (long)nums1[i] + nums2[j] != s){
                i++;
                j = idx[i];
            }else{
                ArrayList<Integer> tmp = new ArrayList<>();
                tmp.add(nums1[i]);
                tmp.add(nums2[j]);
                list.add(tmp);
                size++;
                j++;
            }
        }
        return list;
    }

    public static void main(String[] args){

        Random r = new Random();
        outer:
        for(int k = 0 ; k < 1000 ; k++){
            int len1 = r.nextInt(1000) + 1;
            int len2 = r.nextInt(1000) + 1;
            int x = r.nextInt(len1 * len2 + 100) ;
            int[] nums1 = new int[len1];
            int[] nums2 = new int[len2];
            for(int i = 0 ; i < len1 ; i++){
                nums1[i] = r.nextInt(1000000) + 1;
            }
            for(int i = 0 ; i < len2 ; i++){
                nums2[i] = r.nextInt(1000000) + 1;
            }
            Arrays.sort(nums1);
            Arrays.sort(nums2);
            int len = len1 * len2;
            int[] tmp = new int[len];
            int t = 0;
            for(int i = 0 ; i < nums1.length ; i++){
                for(int j = 0 ; j < nums2.length ; j++)
                    tmp[t++] = nums1[i] + nums2[j];
            }
            List<List<Integer>> list = new LeetCode373().kSmallestPairs(nums1,nums2,x);
            Arrays.sort(tmp);
            HashMap<Integer,Integer> map = new HashMap<>();
            x = Math.min(x,len1 * len2);
            for(int i = 0 ; i < x ; i++)
                map.put(tmp[i],map.getOrDefault(tmp[i],0) + 1);



            Iterator<List<Integer>> iterator = list.iterator();
            while(iterator.hasNext()){
                List<Integer> l = iterator.next();
                int key = l.get(0) + l.get(1);
                if(-1 == map.getOrDefault(key,-1)){
                    System.out.println("error");
                    break outer;
                }
                map.put(key,map.get(key) - 1);
            }
            Iterator<Integer> ite = map.keySet().iterator();
            while(ite.hasNext()){
                if(map.get(ite.next()) != 0 ){
                    System.out.println("error");
                    break outer;
                }
            }
            System.out.println("ok");
        }



    }

}
