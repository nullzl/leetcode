package main.java.com.nullzl.leetcode200;

import sun.jvm.hotspot.utilities.Bits;

import java.util.*;

public class LeetCode127 {

    private BitSet code(String str){
        if(null == str || 0 == str.length())
            return  new BitSet();

        int len = ('z' - 'a' + 1);
        BitSet rs = new BitSet(str.length() * len );
        for(int i = 0 ; i < str.length() ; i++){
            rs.set(i * len + (str.charAt(i) - 'a'),true);
        }
        return rs;
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        if(null == wordList || 0 == wordList.size() ||  null == beginWord
                || 0 == beginWord.length() || null == endWord || 0 == endWord.length()
                || beginWord.length() != endWord.length())
            return 0;

        HashMap<String,BitSet> map = new HashMap<>();
        Iterator<String> iterator = wordList.iterator();
        LinkedList<BitSet> words = new LinkedList<>();
        int size = 0;
        BitSet startCode = code(beginWord);
        BitSet endCode = code(endWord);
        boolean exist = false;
        while(iterator.hasNext()){
            String str = iterator.next();
            BitSet bits = code(str);
            words.add(bits);
            if(!exist){
                BitSet copy = (BitSet)bits.clone();
                copy.xor(endCode);
                if(copy.isEmpty()) {
                    exist = true;
                    endCode = bits;
                }
            }
        }
        if(!exist)
            return 0;

        LinkedList<BitSet> list = new LinkedList<>();
        LinkedList<BitSet> next = new LinkedList<>();
        list.add(startCode);
        int step = 2;

        while(!list.isEmpty() && !words.isEmpty()){

            BitSet code = list.pop();
            ListIterator<BitSet> listIterator = words.listIterator();
            while(listIterator.hasNext()){
                BitSet nextCode = listIterator.next();
                BitSet copyCode = (BitSet)code.clone();
                copyCode.xor(nextCode);
                if(2 == copyCode.cardinality()){
                    next.add(nextCode);
                    listIterator.remove();
                    if(endCode == nextCode)
                        return step;
                }else if( 0 == copyCode.cardinality()){
                    listIterator.remove();
                }
            }

            if(list.isEmpty()){
                list = next;
                next = new LinkedList<>();
                step++;
            }
        }

        return 0;

    }

    public static void main(String[] args){

        LinkedList<String> strs = new LinkedList<>();
        strs.add("ted");
        strs.add("tex");
        strs.add("red");
        strs.add("tax");
        strs.add("tad");
        strs.add("den");
        strs.add("rex");
        strs.add("pee");
        System.out.println(new LeetCode127().ladderLength("red","tax",strs));
    }
}
