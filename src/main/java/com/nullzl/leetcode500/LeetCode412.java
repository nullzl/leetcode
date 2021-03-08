package com.nullzl.leetcode500;

import java.util.ArrayList;
import java.util.List;

public class LeetCode412 {

    public List<String> fizzBuzz(int n) {

        ArrayList<String> list = new ArrayList<>(n);

        for(int i = 1; i <= n ; i++){
            if(0 == i % 15){
                list.add("FizzBuzz");
            }else if(0 == i % 5){
                list.add("Buzz");
            }else if(0 == i % 3){
                list.add("Fizz");
            }else{
                list.add(String.valueOf(i));
            }
        }
        return list;
    }
}
