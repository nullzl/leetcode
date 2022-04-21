package com.nullzl.interview;

public class Interview0301 {

    class TripleInOne {

        private int[] arr;
        private int size;
        private int[] tops;


        public TripleInOne(int stackSize) {
            arr = new int[3 * stackSize];
            tops = new int[]{0,stackSize,stackSize << 1};
            size = stackSize;
        }

        public void push(int stackNum, int value) {
            if(tops[stackNum] < (stackNum + 1) * size){
                arr[tops[stackNum]++] = value;
            }
        }

        public int pop(int stackNum) {
            if(tops[stackNum] > stackNum * size){
                return arr[--tops[stackNum]];
            }
            return -1;
        }

        public int peek(int stackNum) {
            if(tops[stackNum] > stackNum * size){
                return arr[tops[stackNum] - 1];
            }
            return -1;
        }

        public boolean isEmpty(int stackNum) {
            return tops[stackNum] == stackNum * size;
        }
    }
}
