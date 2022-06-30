package com.nullzl.offer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Offer2_30 {


    class RandomizedSet {

        HashMap<Integer,Integer> map;
        List<Integer> list;
        Random random = new Random();


        /** Initialize your data structure here. */
        public RandomizedSet() {
            map = new HashMap<>();
            list = new ArrayList<>();
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            if(-1 == map.getOrDefault(val,-1)){
                list.add(val);
                map.put(val,list.size() - 1);
                return true;
            }
            return false;
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            int idx = map.getOrDefault(val,-1);
            if(-1 == idx)
                return false;
            if(idx != list.size() - 1){
                int num = list.get(list.size() - 1);
                list.set(idx,num);
                map.put(num,idx);
            }
            map.remove(val);
            list.remove(list.size() - 1);
            return true;
        }

        /** Get a random element from the set. */
        public int getRandom() {
            int idx = random.nextInt(list.size());
            return list.get(idx);
        }
    }

}
