package com.nullzl.interview;

import java.util.ArrayList;
import java.util.List;

public class Interview0804 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> sets = new ArrayList<>();
        sets.add(new ArrayList<>());
        for (int num : nums) {
            List<List<Integer>> lists = new ArrayList<>();
            for (List<Integer> list : sets) {
                List<Integer> item = new ArrayList<>(list);
                item.add(num);
                lists.add(item);
            }
            sets.addAll(lists);
        }
        return sets;
    }
}
