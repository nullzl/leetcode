package com.nullzl.leetcode200;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode119 {

    public List<Integer> getRow(int rowIndex) {

        ArrayList<Integer> rs = new ArrayList<Integer>();

        if(rowIndex <= 0)
            return rs;

        rs.add(1);
        for(int i = 2 ; i <= rowIndex ; i++){
            int preVal = rs.get(0);
            for(int j = 1 ; j < i - 1 ; j++){
                int temp = rs.get(j);
                rs.set(j,preVal + rs.get(j));
                preVal = temp;
            }
            rs.add(1);
        }
        return rs;

    }
}
