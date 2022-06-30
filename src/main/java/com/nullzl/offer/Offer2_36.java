package com.nullzl.offer;

import java.util.LinkedList;

public class Offer2_36 {

    public int evalRPN(String[] tokens) {
        LinkedList<Integer> stk = new LinkedList<>();
        for(String s : tokens){
            if("+".equals(s)){
                stk.push(stk.pop() + stk.pop());
            }else if("-".equals(s)){
                stk.push(- stk.pop() + stk.pop());
            }else if("*".equals(s)){
                stk.push(stk.pop() * stk.pop());
            }else if("/".equals(s)){
                int num1 = stk.pop();
                stk.push(stk.pop() / num1);
            }else{
                stk.push(Integer.parseInt(s));
            }
        }
        return stk.pop();
    }
}
