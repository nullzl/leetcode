package main.java.com.nullzl.leetcode400;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LeetCode347 {


    private void heapify(Integer[] heap,int root,HashMap<Integer,Integer> map){
        int left = (root << 1) + 1;
        int right = (root << 1) + 2;
        int min = root;
        if(left < heap.length
                && map.getOrDefault(heap[left],0)
                    < map.getOrDefault(heap[min],0) ) {
            min = left;
        }
        if(right < heap.length &&
                map.getOrDefault(heap[right],0)
                    < map.getOrDefault(heap[min],0)){
            min = right;
        }
        if(min != root){
            heap[root] = heap[root] ^ heap[min];
            heap[min] = heap[root] ^ heap[min];
            heap[root] = heap[root] ^ heap[min];
            heapify(heap,min,map);
        }
    }

    private void initHeap(Integer[] heap,HashMap<Integer,Integer> map){
        int i = (heap.length - 2) >> 1;
        for(; i >= 0 ; i--){
            heapify(heap,i,map);
        }
    }


    public List<Integer> topKFrequent(int[] nums, int k) {

        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ; i < nums.length ; i++){
            map.put(nums[i],map.getOrDefault(nums[i],0) + 1);
        }

        k = Math.min(k,map.keySet().size());
        Integer[] heap = map.entrySet().stream().limit(k)
                .map(entry -> entry.getKey())
                .toArray(Integer[]::new);
        initHeap(heap,map);
        map.entrySet().stream().skip(k)
                .forEach(entry -> {
                    if(map.getOrDefault(entry.getKey(),0)
                        > map.getOrDefault(heap[0],0)){
                        heap[0] = entry.getKey();
                        heapify(heap,0,map);
                    }
                });
        return Arrays.asList(heap);

    }

    public static void main(String[] args){
        List<Integer> list = new LeetCode347().topKFrequent(
                new int[]{1},
                1
        );
        list.stream().forEach(System.out::println);
    }
}
