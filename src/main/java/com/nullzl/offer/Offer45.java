package com.nullzl.offer;

import java.util.Arrays;
import java.util.Comparator;

public class Offer45 {


    public static class Num{
        public String s;
        public Num(int i){
            s = String.valueOf(i);
        }
    }

    public String minNumber(int[] nums) {

        if(null == nums || 0 == nums.length)
            return "";
        Num[] ns = new Num[nums.length];
        for(int i = 0 ; i < nums.length ; i++)
            ns[i] = new Num(nums[i]);

        Arrays.sort(ns, new Comparator<Num>() {
            @Override
            public int compare(Num o1, Num o2) {
                return (o1.s + o2.s).compareTo(o2.s + o1.s);
            }
        });
        StringBuilder rs = new StringBuilder();
        for(int i = 0 ; i < ns.length ; i++)
            rs.append(ns[i].s);

        return rs.toString();
    }
}
