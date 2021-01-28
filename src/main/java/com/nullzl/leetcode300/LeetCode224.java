package main.java.com.nullzl.leetcode300;

import java.util.LinkedList;

public class LeetCode224 {

    private void calc(LinkedList<Integer> operands,LinkedList<Character> operators){
        char ch = operators.pollLast();
        int op2 = operands.pollLast();
        int op1 = operands.pollLast();
        if('+' == ch)
            operands.addLast(op1 + op2);
        else
            operands.addLast(op1 - op2);
    }

    public int calculate(String s) {

        if(null == s || 0 == s.length())
            throw new IllegalArgumentException();

        LinkedList<Integer> operands = new LinkedList<>();
        LinkedList<Character> operators = new LinkedList<>();
        s = s.replace(" ","");
        int i = -1 , j = 0;
        for(; j < s.length() ; j++){
            char ch = s.charAt(j);
            if(ch >= '0' && ch <= '9') {
                if(-1 == i)
                    i = j;
            }else{
                if(-1 != i){
                    operands.addLast(Integer.parseInt(s.substring(i,j)));
                    i = -1;
                }
                if('(' ==  ch){
                    operators.addLast(ch);
                }else if('+' == ch || '-' == ch){
                    while(!operators.isEmpty() && '(' != operators.peekLast()){
                        this.calc(operands,operators);
                    }
                    operators.addLast(ch);
                }else{
                    while('(' != operators.peekLast()){
                        this.calc(operands,operators);
                    }
                    operators.pollLast();
                }
            }
        }
        if(-1 != i){
            operands.addLast(Integer.parseInt(s.substring(i,j)));
        }
        while(!operators.isEmpty()){
            this.calc(operands,operators);
        }
        return operands.pollLast();

    }

    public static void main(String[] args){
        System.out.println(new LeetCode224().calculate("(1+(4+5+2)-3)+(6+8)"));
    }
}
