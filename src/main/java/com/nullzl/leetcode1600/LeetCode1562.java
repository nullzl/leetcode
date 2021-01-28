package com.nullzl.leetcode1600;

import java.util.TreeSet;

public class LeetCode1562 {

    class Interval{
        public int left;
        public int right;

        public Interval(int l, int r){
            this.left = l;
            this.right = r;
        }
    }

    public int findLatestStep(int[] arr, int m) {

        int count = 0;
        int step = -1;
        TreeSet<Interval> set = new TreeSet<Interval>((p1,p2) ->{
            return p1.left - p2.left;
        });

        for(int i = 0 ; i < arr.length ; i++){
            Interval tmp = new Interval(arr[i],arr[i]);
            Interval lower = set.lower(tmp);
            Interval upper = set.higher(tmp);

            if(null == lower && null == upper){
                set.add(tmp);
                if(1 == m)
                    count++;
            }else if(null == lower){
                if(upper.left-1 == arr[i]){
                    int len = upper.right - upper.left + 1;
                    if(m == len && --count == 0){
                        step = i;
                    }
                    upper.left--;
                    if(len + 1 == m){
                        count++;
                    }
                }else{
                    set.add(tmp);
                    if(1 == m)
                        count++;
                }
            }else if(null == upper){
                if(lower.right + 1 == arr[i]){
                    int len = lower.right - lower.left + 1;
                    if(m == len && --count == 0){
                        step = i;
                    }
                    lower.right++;
                    if(len + 1 == m){
                        count++;
                    }
                }else{
                    set.add(tmp);
                    if(1 == m)
                        count++;
                }
            }else{
                if(arr[i] != lower.right + 1 && arr[i] != upper.left - 1){
                    set.add(tmp);
                    if(1 == m)
                        count++;
                }else if(arr[i] == lower.right + 1 && arr[i] == upper.left - 1){
                    int len = lower.right - lower.left + 1;
                    if(m == len && --count == 0)
                        step = i;
                    len = upper.right - upper.left + 1;
                    if(m == len && --count == 0)
                        step = i;
                    set.remove(upper);
                    lower.right = upper.right;
                    if(lower.right - lower.left + 1 == m)
                        count++;
                }else if(arr[i] == lower.right + 1){
                    int len = lower.right - lower.left + 1;
                    if(m == len && --count == 0){
                        step = i;
                    }
                    lower.right++;
                    if(len + 1 == m){
                        count++;
                    }
                }else{
                    int len = upper.right - upper.left + 1;
                    if(m == len && --count == 0){
                        step = i;
                    }
                    upper.left--;
                    if(len + 1 == m){
                        count++;
                    }
                }
            }
        }
        if(0 != count)
            return arr.length;
        return step;
    }
}
