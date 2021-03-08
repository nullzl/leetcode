package com.nullzl.leetcode200;

public class LeetCode165 {

    public int next(String str,int index){
        if(index >= str.length())
            return -1;

        char ch = str.charAt(index);
        if(ch >= '1' && ch <= '9'){
            return index;
        }
        if('0' == ch && (index + 1 == str.length() || '.' == str.charAt(index + 1))){
            return index;
        }
        return next(str,index + 1);
    }
    public int nextEnd(String str,int index){
        while(index < str.length() && '.' != str.charAt(index))
            index++;
        return index - 1;
    }

    public int compareVersion(String version1, String version2) {
        int index1 = next(version1,0);
        int index2 = next(version2,0);
        int end1,end2;
        while(-1 != index1 || -1 != index2){

            if(-1 == index1 && -1 == index2)
                return 0;
            else if(-1 == index1){
                if('0' == version2.charAt(index2))
                    index2 = next(version2,index2 + 1);
                else
                    return -1;
            }else if(-1 == index2){
                if('0' == version1.charAt(index1))
                    index1 = next(version1,index1 + 1);
                else
                    return 1;
            }else{
                end1 = nextEnd(version1,index1);
                end2 = nextEnd(version2,index2);
                if(end1 - index1 == end2 - index2){
                    while(index1 <= end1 ){
                        if(version1.charAt(index1) == version2.charAt(index2)){
                            index1++;
                            index2++;
                        }else if(version1.charAt(index1) > version2.charAt(index2)){
                            return 1;
                        }else{
                            return -1;
                        }
                    }
                    index1 = next(version1,end1 + 1);
                    index2 = next(version2,end2 + 1);
                }else if(end1 - index1 > end2 - index2){
                    return 1;
                }else{
                    return -1;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args){
        System.out.println(new LeetCode165().compareVersion("1"
                ,"0"));
    }
}
