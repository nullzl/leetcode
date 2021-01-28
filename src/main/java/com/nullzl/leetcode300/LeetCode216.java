package main.java.com.nullzl.leetcode300;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LeetCode216 {

    List<List<Integer>> getSumList(int i,int n ,int k){

        LinkedList<List<Integer>> lists = new LinkedList<>();

        if(i < k || i < 1 || n < 1 || k < 1){
            return lists;
        }
        int max = (k / 2) * (i + i - k + 1) + ((1 == k % 2) ? (k / 2 + i - k + 1) : 0);
        int min = (k / 2) * (1 + k) + ((1 == k % 2) ? (k / 2 + 1) : 0);
        if(n < min || n > max){
            return lists;
        }

        List<List<Integer>> preLists = getSumList(i-1,n,k);
        lists.addAll(preLists);


        if(i == n && k == 1){
            List<Integer> list = new LinkedList<>();
            list.add(i);
            lists.add(list);
        }else{
            preLists = getSumList(i - 1, n - i , k - 1);
            Iterator<List<Integer>> listIterator = preLists.iterator();
            while(listIterator.hasNext()){
                List<Integer> list = new LinkedList<>();
                list.addAll(listIterator.next());
                list.add(i);
                lists.add(list);
            }
        }
        return lists;
    }

    public List<List<Integer>> combinationSum3(int k, int n) {

        List<List<Integer>> lists = new LinkedList<>();

        if(n < 1 || k < 1 )
            return lists;
        k = Math.min(9,k);

        int s = Math.min(9,n);

        lists = getSumList(s,n,k);
        return lists;

    }

    public static void main(String[] args){
        LeetCode216 l = new LeetCode216();
        List<List<Integer>> lists = l.combinationSum3(1,9);
        System.out.println(lists.size());
    }
}
