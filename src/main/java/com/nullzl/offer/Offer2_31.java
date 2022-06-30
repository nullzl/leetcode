package com.nullzl.offer;

import java.util.LinkedHashMap;
import java.util.Map;

public class Offer2_31 {

    class Cache extends LinkedHashMap<Integer,Integer>{

        private int capacity;

        public Cache(int c){
            super(c,0.75F,true);
            this.capacity = c;
        }

        protected boolean removeEldestEntry(Map.Entry eldest){
            return this.size() > this.capacity;
        }
    }


    class LRUCache {

        private Cache cache;


        public LRUCache(int capacity) {
            cache = new Cache(capacity);
        }

        public int get(int key) {
            return cache.getOrDefault(key,-1);
        }

        public void put(int key, int value) {
            cache.put(key,value);
        }
    }
}
