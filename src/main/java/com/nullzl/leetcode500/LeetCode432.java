package com.nullzl.leetcode500;

import java.util.HashMap;
import java.util.HashSet;

public class LeetCode432 {
}


class SNode{
    public HashSet<String> set;
    public SNode previous;
    public SNode next;
    public int idx;

    public SNode(int i,SNode p , SNode n){
        this.previous = p;
        this.next = n;
        this.idx = i;
        this.set = new HashSet<>();
    }

    public void remove(String key){
        if(0 != idx) {
            set.remove(key);
        }
    }

    public void add(String key){
        if(0 != idx) {
            set.add(key);
        }
    }

}

class AllOne {

    private HashMap<String,Integer> strs;
    private HashMap<Integer,SNode> nodes;
    private SNode dummyHeader;
    private SNode tail;

    public AllOne() {
        strs = new HashMap<>();
        nodes = new HashMap<>();
        dummyHeader = new SNode(0,null,null);
        tail = dummyHeader;
        nodes.put(0,dummyHeader);
    }

    private void addNext(SNode p, SNode n){
        nodes.put(n.idx,n);
        SNode t = p.next;
        p.next = n;
        n.previous = p;
        n.next = t;
        if(null != t){
            t.previous = n;
        }else{
            tail = n;
        }
    }

    private void addPrevious(SNode c , SNode p){
        if(0 == c.idx)
            return ;
        nodes.put(p.idx,p);
        SNode t = c.previous;
        c.previous = p;
        p.next = c;
        p.previous = t;
        t.next = p;

    }

    private void removeNode(SNode c){
        if(0 == c.idx)
            return ;
        nodes.remove(c.idx);
        SNode p = c.previous;
        SNode n = c.next;
        c.previous = null;
        c.next = null;
        p.next = n;
        if(null != n){
            n.previous = p;
        }else{
            tail = p;
        }
    }

    public void inc(String key) {
        int count = strs.getOrDefault(key,0);
        strs.put(key,count + 1);
        SNode c = nodes.get(count);
        SNode n = nodes.get(count + 1);
        if(null == n){
            n = new SNode(count + 1,null,null);
            addNext(c,n);
        }
        c.remove(key);
        n.add(key);
        if(0 == c.set.size())
            removeNode(c);
    }

    public void dec(String key) {
        int count = strs.getOrDefault(key,0);
        if(0 == count)
            return ;
        if(1 == count)
            strs.remove(key);
        else
            strs.put(key,count - 1);
        SNode c = nodes.get(count);
        SNode p = nodes.getOrDefault(count - 1,null);
        if(null == p){
            p = new SNode(count - 1,null,null);
            addPrevious(c,p);
        }
        c.remove(key);
        p.add(key);
        if(0 == c.set.size())
            removeNode(c);
    }

    public String getMaxKey() {
        if(0 == tail.idx)
            return "";
        return tail.set.iterator().next();
    }

    public String getMinKey() {
        if(null == dummyHeader.next)
            return "";
        return dummyHeader.next.set.iterator().next();
    }
}
