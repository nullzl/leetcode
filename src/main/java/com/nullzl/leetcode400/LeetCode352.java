package com.nullzl.leetcode400;

import java.util.Iterator;
import java.util.TreeSet;

    class Pair{
        public int lower;
        public int upper;

        public Pair(int l ,int u){
            this.lower = l;
            this.upper = u;
        }
    }

    class SummaryRanges {

        TreeSet<Pair> set ;

        public SummaryRanges() {
            set = new TreeSet<Pair>((p1,p2) ->{
                return p1.lower - p2.lower;
            });
        }

        public void addNum(int val) {
            Pair key = new Pair(val,val+1);
            if(set.contains(key))
                return ;
            Pair lower = set.lower(key);
            Pair upper = set.higher(key);

            if(null == lower && null == upper)
                set.add(key);
            else if(null == lower){
                if(val == upper.lower - 1)
                    upper.lower--;
                else
                    set.add(key);
            }
            else if(null == upper){
                if(val == lower.upper)
                    lower.upper++;
                else if(val > lower.upper)
                    set.add(key);
            }else{
                if(val == lower.upper){
                    if(val == upper.lower - 1){
                        lower.upper = upper.upper;
                        set.remove(upper);
                    }else{
                        lower.upper++;
                    }
                }else if(val > lower.upper){
                    if(val == upper.lower - 1)
                        upper.lower--;
                    else
                        set.add(key);
                }
            }
        }

        public int[][] getIntervals() {
            int[][] rs = new int[set.size()][2];
            Iterator<Pair> iterator = this.set.iterator();
            int i = 0;
            while(iterator.hasNext()){
                Pair p = iterator.next();
                rs[i][0] = p.lower;
                rs[i++][1] = p.upper - 1;
            }
            return rs;
        }
    }

public class LeetCode352 {

    public static void main(String[] args){
        SummaryRanges sr = new SummaryRanges();
        int[][] rs = null;
        rs = sr.getIntervals();
        for(int i = 0; i < rs.length ; i++){
            System.out.println(rs[i][0] + "\t" + rs[i][1]);
        }
        System.out.println("---------------");


        sr.addNum(1);
        rs = sr.getIntervals();
        for(int i = 0; i < rs.length ; i++){
            System.out.println(rs[i][0] + "\t" + rs[i][1]);
        }
        System.out.println("---------------");

        sr.addNum(0);
        rs = sr.getIntervals();
        for(int i = 0; i < rs.length ; i++){
            System.out.println(rs[i][0] + "\t" + rs[i][1]);
        }
        System.out.println("---------------");

        sr.addNum(5);
        rs = sr.getIntervals();
        for(int i = 0; i < rs.length ; i++){
            System.out.println(rs[i][0] + "\t" + rs[i][1]);
        }
        System.out.println("---------------");

    }


}
