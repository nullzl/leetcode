package com.nullzl.leetcode100;

import java.util.LinkedList;

public class LeetCode87 {

    private boolean isSubString(String s,String t){
        int[] lastMatch= new int[t.length()];
        lastMatch[0] = -1;
        for(int i = 1 ; i < t.length() ; i++){
            int pos = lastMatch[i-1];
            while(-1 != pos){
                if(t.charAt(pos) == t.charAt(i-1)){
                    lastMatch[i] = pos + 1;
                    break;
                }
                pos = lastMatch[pos];
            }
        }

        for(int i = 0 ,j = 0 ; i + t.length() -1 -j < s.length() ; ){
            if(s.charAt(i) != t.charAt(j)){
                j = lastMatch[j];
                while(-1 != j){
                    if(s.charAt(i) == t.charAt(j))
                        break;
                    j = lastMatch[j];
                }

            }
            i++;
            j++;
            if(j == t.length())
                return true;

        }
        return false;
    }

    public boolean isScramble(String s1, String s2) {

        if(null == s1 || null == s2)
            return false;
        if(s1.length() != s2.length())
            return false;

        int i,j;
        for(i = 0 ; i < s1.length() ; i++){
            if(s1.charAt(i) != s2.charAt(i))
                break;
        }
        if(i == s1.length())
            return true;

        i = 0 ;
        j = s1.length() - 1;

        int size1 = 0;
        int size2 = 0;

//        HashMap<Integer,Integer> map1 = new HashMap<Integer,Integer>();
//        HashMap<Integer,Integer> map2 = new HashMap<Integer,Integer>();
//        HashMap<Integer,Integer> map3 = new HashMap<Integer,Integer>();
        int mapSize = 'z' - 'a' + 1;
        int[] map1 = new int[mapSize];
        int[] map2 = new int[mapSize];
        int[] map3 = new int[mapSize];
        LinkedList<Integer> stk1 = new LinkedList<Integer>();
        LinkedList<Integer> stk2 = new LinkedList<Integer>();
        for(int x = i,y = j ;  x <= j && y >= 0 ; x++,y--){
            int num1 = s1.charAt(x) - 'a';
            int num2 = s2.charAt(y) - 'a';
            int num3 = s2.charAt(x) - 'a';
            int count1 = ++map1[num1];
            int count2 = ++map2[num2];
            int count5 = ++map3[num3];
            if(num1 != num2){
                int count3 = map2[num1];
                int count4 = map1[num2];
                if(count3 == count1 - 1)
                    size1++;
                else if(count3 != count1 -1 && count3 == count1)
                    size1--;
                if(count4 == count2-1)
                    size1++;
                else if(count4 != count2 -1 && count4 == count2)
                    size1--;

            }
            if(num1 != num3){
                int count6 = map1[num3];
                int count7 = map3[num1];
                if(count5 -1 == count6)
                    size2++;
                else if(count5-1 != count6 && count5 == count6)
                    size2--;
                if(count1-1 == count7)
                    size2++;
                else if(count1-1 != count7 && count7 == count1)
                    size2--;
            }
            if(0 == size1){
                stk1.push(x);
            }
            if(0 == size2)
                stk2.push(x);
        }
        if(stk1.isEmpty() || j != stk1.pop())
            return false;
        boolean rs = false;
        while(!rs && !stk1.isEmpty()){
            int x = stk1.pop();
            String str1 = s1.substring(i,x + 1);
            String str2 = s2.substring(j-x+i,j+1);
            String str3 = s1.substring(x+1,j+1);
            String str4 = s2.substring(i,j-x+i);
            rs = (isScramble(str1,str2) && isScramble(str3,str4));
        }
        stk2.pop();
        while(!rs && !stk2.isEmpty()){
            int x = stk2.pop();
            String str1 = s1.substring(i,x + 1);
            String str2 = s2.substring(i,x + 1);
            String str3 = s1.substring(x+1,j+1);
            String str4 = s2.substring(x+1,j+1);
            rs = (isScramble(str1,str2) && isScramble(str3,str4));
        }
        return rs;
    }

    //使用hash表保存中间结果
    public boolean isScramble2(String s1, String s2) {
        if(null == s1 || null == s2)
            return false;
        if(s1.length() != s2.length())
            return false;
        if(s1.equals(s2))
            return true;
        boolean rs = false;
        for(int i = 1 ; i < s1.length() && !rs ; i++){
            String str1 = s1.substring(0,i);
            String str2 = s1.substring(i,s1.length());
            String str3 = s2.substring(0,i);
            String str4 = s2.substring(i,s2.length());
            rs = isScramble(str1,str3) && isScramble(str2,str4);
            if(!rs){
                String str5 = s2.substring(s1.length() - i,s1.length());
                String str6 = s2.substring(0,s1.length() - i);
                rs = isScramble(str1,str5) && isScramble(str2,str6);
            }
        }
        return rs;
    }

    public static void main(String[] args){


        System.out.println(new LeetCode87().isScramble("abcdefghijklmnopq"
                ,"efghijklmnopqcadb"));
    }
}
