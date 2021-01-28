package main.java.com.nullzl.leetcode200;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LeetCode131 {

    HashMap<Integer,LinkedList<List<String>>> cache;

    private List<List<String>> getPartitionList(String s,int start,boolean[][] flag){
        LinkedList<List<String>> rs = new LinkedList<List<String>>();
        if(start >= s.length())
            return rs;

        LinkedList<List<String>> list = this.cache.get(start);
        if(null != list)
            return list;

        for(int i = start ; i < s.length() ; i++){
            if(flag[start][i]){
                String str = s.substring(start,i+1);
                List<List<String>> items = getPartitionList(s,i+1,flag);
                if(0 == items.size()){
                    LinkedList<String> item = new LinkedList<String>();
                    item.add(str);
                    rs.add(item);
                }else{
                    Iterator<List<String>> iterator = items.iterator();
                    while(iterator.hasNext()){
                        LinkedList<String> item = new LinkedList<String>();
                        item.add(str);
                        item.addAll(iterator.next());
                        rs.add(item);
                    }
                }
            }
        }
        this.cache.put(start,rs);
        return rs;
    }

    public List<List<String>> partition(String s) {

        LinkedList<List<String>> rs = new LinkedList<List<String>>();
        if(null == s || 0 == s.length()){
            return rs;
        }

        boolean[][] flag = new boolean[s.length()][s.length()];
        for(int i = 0 ; i < s.length() - 1 ; i++) {
            flag[i][i] = true;
            flag[i][i+1] = (s.charAt(i) == s.charAt(i+1));
        }
        flag[s.length()-1][s.length() -1] = true;

        for(int step = 2; step < s.length() ; step++){
            for(int i = 0 , j = i + step ; j < s.length() ; i++,j++){
                flag[i][j] = (s.charAt(i) == s.charAt(j)) && flag[i+1][j-1];
            }
        }

        this.cache = new HashMap<Integer,LinkedList<List<String>>>();

        return getPartitionList(s,0,flag);
    }

    public static void main(String[] args){
        List<List<String>> lists = new LeetCode131().partition("aaaaaa");
        Iterator<List<String>> iterator = lists.iterator();
        while(iterator.hasNext()){
            List<String> strs = iterator.next();
            Iterator ite = strs.iterator();
            while(ite.hasNext()){
                System.out.print(ite.next() + "\t");
            }
            System.out.println();
        }
    }

}
