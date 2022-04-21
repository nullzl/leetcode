package com.nullzl.offer;

import java.util.LinkedList;

public class Offer09 {

    class CQueue {
        private LinkedList<Integer> append;
        private LinkedList<Integer> delete;

        public CQueue() {
            this.append = new LinkedList<>();
            this.delete = new LinkedList<>();
        }

        public void appendTail(int value) {
            append.push(value);
        }

        public int deleteHead() {
            if(delete.isEmpty()){
                while(!append.isEmpty()){
                    delete.push(append.pop());
                }
            }
            if(delete.isEmpty())
                return -1;
            return delete.pop();
        }
    }
}
