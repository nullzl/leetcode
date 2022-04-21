package com.nullzl.interview;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Interview0303 {

    class StackOfPlates {
        List<LinkedList<Integer>> lists = new ArrayList<>();
        int capacity;

        public StackOfPlates(int cap) {
            this.capacity = cap;
        }

        public void push(int val) {
            if(0 == capacity)
                return ;
            if(lists.size() > 0 && lists.get(lists.size() - 1).size() < capacity){
                lists.get(lists.size() - 1).push(val);
            }else{
                LinkedList<Integer> item = new LinkedList<>();
                item.push(val);
                lists.add(item);
            }
        }

        public int pop() {
            if(0 == lists.size())
                return -1;
            int val = lists.get(lists.size() - 1).pop();
            if(lists.get(lists.size() - 1).size() == 0)
                lists.remove(lists.size() - 1);
            return val;
        }

        public int popAt(int index) {
            if(index >= lists.size())
                return -1;
            int val =  lists.get(index).pop();
            if(0 == lists.get(index).size())
                lists.remove(index);
            return val;
        }
    }
}
