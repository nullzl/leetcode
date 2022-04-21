package com.nullzl.interview;

import java.util.LinkedList;

public class Interview0306  {

    class AnimalShelf {

        LinkedList<int[]> queue = new LinkedList<>();

        public AnimalShelf() {

        }

        public void enqueue(int[] animal) {
            queue.add(animal);
        }

        public int[] dequeueAny() {
            if(queue.isEmpty())
                return new int[]{-1,-1};
            return queue.removeFirst();
        }

        public int[] dequeueDog() {
            int index = -1;
            for(int i = 0 ;i < queue.size() ; i++){
                if(1 == queue.get(i)[1]) {
                    index = i;
                    break;
                }
            }
            return -1 == index ? new int[]{-1,-1} : queue.remove(index);
        }

        public int[] dequeueCat() {
            int index = -1;
            for(int i = 0 ;i < queue.size() ; i++){
                if(0 == queue.get(i)[1]) {
                    index = i;
                    break;
                }
            }
            return -1 == index ? new int[]{-1,-1} : queue.remove(index);
        }
    }
}
