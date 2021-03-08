package com.nullzl.leetcode200;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LeetCode118 {

    public List<List<Integer>> generate(int numRows) {

        LinkedList<List<Integer>> rs = new LinkedList<List<Integer>>();
        if(numRows <= 0)
            return rs;

        LinkedList<Integer> preList = new LinkedList<Integer>();
        preList.add(1);
        rs.add(preList);

        for(int i = 2 ; i <= numRows ; i++){
            int preVal = 0;
            LinkedList<Integer> list = new LinkedList<Integer>();
            Iterator<Integer> iterator = preList.iterator();
            while(iterator.hasNext()){
                int cur = iterator.next();
                list.add(cur+preVal);
                preVal = cur;
            }
            list.add(preVal);
            rs.add(list);
            preList = list;
        }
        return rs;

    }
}
