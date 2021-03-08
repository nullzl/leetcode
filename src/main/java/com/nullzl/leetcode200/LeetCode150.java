package com.nullzl.leetcode200;

import java.util.LinkedList;

public class LeetCode150 {

    private int getNum(LinkedList<String> stk){
        String str = stk.pop();
        if(str.equals("+")){
            int op2 = getNum(stk);
            int op1 = getNum(stk);
            return op1 + op2;
        }else if(str.equals("-")){
            int op2 = getNum(stk);
            int op1 = getNum(stk);
            return op1 - op2;
        }else if(str.equals("*")){
            int op2 = getNum(stk);
            int op1 = getNum(stk);
            return op1 * op2;
        }else if(str.equals("/")){
            int op2 = getNum(stk);
            int op1 = getNum(stk);
            return op1 / op2;
        }else {
            return Integer.parseInt(str);
        }
    }

    public int evalRPN(String[] tokens) {
        LinkedList<String> stk = new LinkedList<String>();
        for(int i = 0  ; i < tokens.length ; i++){
            stk.push(tokens[i]);
        }

        return getNum(stk);

    }
}
