package com.nullzl.interview;

public class Interview0105 {


    public boolean oneEditAway(String first, String second) {
        if(first.length() < second.length())
            return oneEditAway(second,first);
        int i = 0 , j = 0;
        if(first.length() == second.length()){
            while(i < first.length() && first.charAt(i++) == second.charAt(j++));
        }else if(first.length() - second.length() > 1)
            return  false;
        else{
            while(j < second.length() && first.charAt(i++) == second.charAt(j))
                j++;
        }

        while(j < second.length()){
            if(first.charAt(i++) != second.charAt(j++)){
                return false;
            }
        }
        return true;
    }
}
