package com.nullzl.leetcode1000;

import java.util.Arrays;

class Person{
    public int count = 0 ;
    int index;
    int pos;

    public Person(int i,int p){
        index = i;
        pos = p;
    }
}

public class LeetCode911 {

    int[] time;
    int[] person;
    int size;

    private void swap(Person[] heap,int i, int j){
        heap[i].pos = j;
        heap[j].pos = i;
        Person tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
    }

    public LeetCode911(int[] persons, int[] times) {

        time = new int[times.length + 1];
        person = new int[times.length + 1];
        time[0] = -1;
        person[0] = -1;
        size = 1;

        Person[] ps = new Person[times.length + 1];
        Person[] heap = new Person[times.length + 1];
        for(int i = 0 ; i < ps.length ; i++){
            ps[i] = new Person(i,i);
            heap[i] = ps[i];
        }

        for(int i = 0 ; i < times.length ; i++){
            Person p = ps[persons[i]];
            p.count++;

            while(p.pos > 0){
                int root = (p.pos - 1) / 2;
                if(p.count >= heap[root].count){
                    swap(heap,p.pos,root);
                }else{
                    break;
                }
            }

            if(times[i] == time[size - 1])
                person[size - 1] = heap[0].index;
            else{
                time[size] = times[i];
                person[size++] = heap[0].index;
            }
        }
    }

    public int q(int t) {
        int k = Arrays.binarySearch(time,0,size,t);
        if(k < 0)
            return person[-k-2];
        return person[k];
    }

    public static void main(String[] args){
        LeetCode911 l = new LeetCode911(new int[] {0,1,1,0,0,1,0}, new int[]{0,5,10,15,20,25,30});
        for(int i = 0 ; i < l.size; i++){
            System.out.println(l.time[i] +"\t" + l.person[i]);
        }
    }


}
