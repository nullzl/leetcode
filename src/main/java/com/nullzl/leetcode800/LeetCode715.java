package com.nullzl.leetcode800;

import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;


class Range{
    public int low;
    public int high;

    public Range(int l,int h){
        this.low = l;
        this.high = h;
    }
}
class RangeModule {
    private TreeSet<Range> set;


    public RangeModule() {
        this.set = new TreeSet<Range>((r1,r2) ->{
            return r1.low - r2.low;
        }) ;
    }



    public void addRange(int left, int right) {
        if(right <= left)
            return ;
        Range r = new Range(left,right);
        if(0 == this.set.size())
            this.set.add(r);

        Range lower = this.set.lower(r);
        if(null != lower && lower.high >= left){
            left = lower.low;
        }

        SortedSet<Range> subSet = this.set.subSet(new Range(left,0),true,new Range(right,0),true);
        if(subSet.size() > 0){
            right = Math.max(right,subSet.last().high);
        }
        subSet.clear();

        this.set.add(new Range(left,right));
    }

    public boolean queryRange(int left, int right) {
        Range floor = this.set.floor(new Range(left,0));
        if(null == floor)
            return false;
        if(floor.high < right)
            return false;
        return true;

    }

    public void removeRange(int left, int right) {
        Range floor = this.set.floor(new Range(left,0));
        if(null != floor){
            if(floor.low < left && floor.high > left){
                int tmp = floor.high;
                floor.high = left;
                if(tmp > right){
                    set.add(new Range(right,tmp));
                }
            }else if(floor.low == left){
                if(right >= floor.high)
                    this.set.remove(floor);
                else
                    floor.low = right;
            }
        }
        SortedSet<Range> subSet = this.set.subSet(new Range(left,0),false,new Range(right,0),false);
        Iterator<Range> iterator = subSet.iterator();
        while(iterator.hasNext()){
            Range tmp = iterator.next();
            if (tmp.high > right)
                tmp.low = right;
            else
                iterator.remove();
        }
    }
}

public class LeetCode715 {

    public static void main(String[] args){
        String[] ops = new String[]{
                "queryRange","queryRange","addRange","addRange","queryRange","queryRange","queryRange","removeRange","addRange","removeRange","addRange","removeRange","removeRange","queryRange","queryRange","queryRange","queryRange","removeRange","addRange","removeRange","queryRange","addRange","addRange","removeRange","queryRange","removeRange","removeRange","removeRange","addRange","removeRange","addRange","queryRange","queryRange","queryRange","queryRange","queryRange","addRange","removeRange","addRange","addRange","addRange","queryRange","removeRange","addRange","queryRange","addRange","queryRange","removeRange","removeRange","addRange","addRange","queryRange","queryRange","addRange","addRange","removeRange","removeRange","removeRange","queryRange","removeRange","removeRange","addRange","queryRange","removeRange","addRange","addRange","queryRange","removeRange","queryRange","addRange","addRange","addRange","addRange","addRange","removeRange","removeRange","addRange","queryRange","queryRange","removeRange","removeRange","removeRange","addRange","queryRange","removeRange","queryRange","addRange","removeRange","removeRange","queryRange"
        };
        int[][] nums = new int[][]{{21,34},{27,87},{44,53},{69,89},{23,26},{80,84},{11,12},{86,91},{87,94},{34,52},{1,59},{62,96},{34,83},{11,59},{59,79},{1,13},{21,23},{9,61},{17,21},{4,8},{19,25},{71,98},{23,94},{58,95},{12,78},{46,47},{50,70},{84,91},{51,63},{26,64},{38,87},{41,84},{19,21},{18,56},{23,39},{29,95},{79,100},{76,82},{37,55},{30,97},{1,36},{18,96},{45,86},{74,92},{27,78},{31,35},{87,91},{37,84},{26,57},{65,87},{76,91},{37,77},{18,66},{22,97},{2,91},{82,98},{41,46},{6,78},{44,80},{90,94},{37,88},{75,90},{23,37},{18,80},{92,93},{3,80},{68,86},{68,92},{52,91},{43,53},{36,37},{60,74},{4,9},{44,80},{85,93},{56,83},{9,26},{59,64},{16,66},{29,36},{51,96},{56,80},{13,87},{42,72},{6,56},{24,53},{43,71},{36,83},{15,45},{10,48}};

        RangeModule rm = new RangeModule();

        for(int i = 0 ; i < ops.length ; i++){
            if("queryRange".equals(ops[i])){
                if(23 == nums[i][0] && 37 == nums[i][1]){
                    System.out.println();
                }
                rm.queryRange(nums[i][0],nums[i][1]);
            }else if("addRange".equals(ops[i])){
                rm.addRange(nums[i][0],nums[i][1]);
            }else{
                if(6 == nums[i][0]){
                    System.out.println();
                }
                rm.removeRange(nums[i][0],nums[i][1]);
            }
        }
    }

}
