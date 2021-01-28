package com.nullzl.leetcode400;

import java.util.*;

public class LeetCode315 {


    private void merger(int[] nums,int[] idxes,int[] count,int[] tmp,int s,int m,int e){
        int i,j,k;
        int len1 = m - s + 1;
        int len2 = e - m;
        System.arraycopy(idxes,s,tmp,0,len1);

        for(i = 0,j = m + 1,k = s; i < len1 && j <= e ; ){
            if(nums[idxes[j]] >= nums[tmp[i]])
                idxes[k++] = idxes[j++];
            else{
                count[tmp[i]] += (e - j + 1);
                idxes[k++] = tmp[i++];
            }
        }

        while(i < len1)
            idxes[k++] = tmp[i++];
    }

    private void mergerCount(int[] nums,int[] idxes,int[] count,int[] tmp,int s , int e){
        if(s >= e)
            return ;
        int mid = s + ((e - s) >> 1);
        mergerCount(nums,idxes,count,tmp,s,mid);
        mergerCount(nums,idxes,count,tmp,mid + 1,e);
        merger(nums,idxes,count,tmp,s,mid,e);
    }


    public List<Integer> countSmaller1(int[] nums) {

        if(null == nums || 0 == nums.length)
            return new ArrayList<>();

        ArrayList<Integer> rs = new ArrayList<>();
        if(1 == nums.length){
            rs.add(0);
            return rs;
        }

        int[] idxes = new int[nums.length];
        int[] count = new int[nums.length];
        int[] tmp = new int[(nums.length >> 1) + 1];
        for(int i = 0 ; i < nums.length ; i++)
            idxes[i] = i;

        mergerCount(nums,idxes,count,tmp,0,nums.length - 1);

        Arrays.stream(count).forEach(
                rs::add
        );

        return rs;
    }


    private void udpate(int[] sum,int i){
        while(i < sum.length){
            sum[i] += 1;
            i += (i & (-i));
        }
    }

    private int sum(int[] sum, int i){
        if(0 == i)
            return 0;
        int rs = 0;
        while(i > 0){
            rs += sum[i];
            i -= (i & (-i));
        }
        return rs;
    }


    class Pair{

        public Pair(int v){
            this.value = v;
        }
        public int value;
        public int index;
    }

    public List<Integer> countSmaller(int[] nums) {

        if(null == nums || 0 == nums.length)
            return new ArrayList<>();

        LinkedList<Integer> rs = new LinkedList<>();
        if(1 == nums.length){
            rs.add(0);
            return rs;
        }

        Pair[] ps = new Pair[nums.length];
        Pair[]copy = new Pair[nums.length];
        for(int i = 0 ; i < nums.length ; i++){
            ps[i] = new Pair(nums[i]);
            copy[i] = ps[i];
        }

        Arrays.sort(ps,(op1,op2) ->{
            return op1.value - op2.value;
        });

        int k = 1;
        ps[0].index = k;
        for(int i = 1 ; i < ps.length ; i++){
            if(ps[i].value == ps[i-1].value)
                ps[i].index = ps[i-1].index;
            else
                ps[i].index = ++k;
        }
        int[] sum = new int[k+1];
        for(int i = copy.length - 1 ; i >= 0 ; i--){
            int index = copy[i].index;
            rs.addFirst(sum(sum,index-1));
            udpate(sum,index);
        }
        return rs;

    }

    public static void main(String[] args){
        new LeetCode315().countSmaller(new int[]{5,2,6,6,2,1,8,5});
    }
}
