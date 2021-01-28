package main.java.com.nullzl.leetcode200;

import java.util.*;

public class LeetCode126 {

    private void buildEdges(HashMap<String,List<String>> map,String str){
        StringBuilder builder = new StringBuilder(str);
        for(int i = 0 ; i < builder.length(); i++){
            builder.setCharAt(i,'*');
            List<String> list = map.get(builder.toString());
            if(null == list){
                list = new LinkedList<String>();
                map.put(builder.toString(),list);
            }
            list.add(str);
            builder.setCharAt(i,str.charAt(i));
        }
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        HashMap<String,List<String>> edges = new HashMap<>();
        List<List<String>> rs = new LinkedList<List<String>>();
        boolean exist = false;
        buildEdges(edges,beginWord);
        Iterator<String> iterator = wordList.iterator();
        while(iterator.hasNext()){
            String str = iterator.next();
            buildEdges(edges,str);
            if(!exist && str.equals(endWord))
                exist = true;
        }
        if(!exist){
            return rs;
        }

        LinkedList<LinkedList<String>> stk = new LinkedList<LinkedList<String>>();
        LinkedList<HashSet<String>> sets = new LinkedList<HashSet<String>>();
        LinkedList<LinkedList<String>> nextStk = new LinkedList<LinkedList<String>>();
        LinkedList<HashSet<String>> nextSets = new LinkedList<HashSet<String>>();
        LinkedList<String> path = new LinkedList<>();
        HashSet<String> set = new HashSet<>();
        path.add(beginWord);
        set.add(beginWord);
        stk.push(path);
        sets.push(set);
        exist = false;

        while(!stk.isEmpty()){
            path = stk.pop();
            set = sets.pop();
            String str = path.peekLast();
            StringBuilder builder = new StringBuilder(str);
            for(int i = 0 ; i < builder.length();i++){
                builder.setCharAt(i,'*');
                List<String> nextStrList = edges.get(builder.toString());
                if(null != nextStrList){
                    iterator = nextStrList.iterator();
                    while(iterator.hasNext()){
                        String nextStr = iterator.next();
                        if(!nextStr.equals(str) && !set.contains(nextStr)){
                            LinkedList<String> nextPath = new LinkedList<>();
                            HashSet<String> nextSet = new HashSet<>();
                            nextPath.addAll(path);
                            nextSet.addAll(set);
                            nextPath.add(nextStr);
                            nextSet.add(nextStr);

                            nextStk.add(nextPath);
                            nextSets.add(nextSet);

                            if(nextStr.equals(endWord)){
                                rs.add(nextPath);
                                exist = true;
                            }
                        }
                    }
                }
                builder.setCharAt(i,str.charAt(i));
            }
            if(stk.isEmpty()){
                if(exist)
                    break;
                stk = nextStk;
                sets = nextSets;
                nextStk = new LinkedList<LinkedList<String>>();
                nextSets = new LinkedList<HashSet<String>>();
            }
        }

        return rs;
    }

    public static void main(String[] args){
        LinkedList<String> words = new LinkedList<String>();
        words.add("ted");
        words.add("tex");
        words.add("red");
        words.add("tax");
        words.add("tad");
        words.add("den");
        words.add("rex");
        words.add("pee");
//        words.add("hot");
//        words.add("dot");
//        words.add("dog");
//        words.add("lot");
//        words.add("log");
//        words.add("cog");


        System.out.println(new LeetCode126().findLadders("red","tex",words).size());

    }

}
