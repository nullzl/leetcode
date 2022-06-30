package com.nullzl.offer;

import java.util.Map;
import java.util.TreeMap;

public class Offer2_58 {
}


class MyCalendar {

    TreeMap<Integer,Integer> map;
    public MyCalendar() {
        map = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        Map.Entry<Integer,Integer> entry = map.floorEntry(start);
        if(null != entry && start >= entry.getKey() && start < entry.getValue())
            return false;
        entry = map.ceilingEntry(start);
        if(null != entry && entry.getKey() < end)
            return false;
        map.put(start,end);
        return true;
    }
}