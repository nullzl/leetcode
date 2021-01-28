package main.java.com.nullzl.leetcode300;

import java.util.LinkedList;

public class LeetCode227 {

    class Element{
        int operand;
        char operator;
        boolean number;

        public Element(int opd,char opr,boolean n){
            this.operand = opd;
            this.operator = opr;
            this.number = n;
        }

    }

    /**
     * 中缀表达式转逆波兰式
     */
    public int calculate(String s) {

        if(null == s)
            throw new IllegalArgumentException();

        LinkedList<Element> stk = new LinkedList<>();
        LinkedList<Element> expression = new LinkedList<>();
        s = s.replace(" ","");
        int i = -1,j= 0;
        for(; j < s.length() ; j++){
            char ch = s.charAt(j);
            if(ch >= '0' && ch <= '9' && -1 == i){
                i = j;
            }else if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){
                if(-1 != i){
                    String num = s.substring(i,j);
                    i = -1;
                    expression.addLast(new Element(Integer.parseInt(num),' ',true));
                }
                Element element = new Element(0,ch,false);
                if('+' == ch || '-' == ch){
                    while(!stk.isEmpty()){
                        expression.addLast(stk.pollLast());
                    }
                }else{
                    while(!stk.isEmpty() && '-' != stk.peekLast().operator
                            && '+' != stk.peekLast().operator ){
                        expression.addLast(stk.pollLast());
                    }
                }
                stk.addLast(element);
            }
        }
        if(-1 != i){
            expression.addLast(new Element(Integer.parseInt(s.substring(i,s.length())),' ',true));
        }
        while(!stk.isEmpty())
            expression.addLast(stk.pollLast());
        while(!expression.isEmpty()){
            Element element = expression.pollFirst();
            if(element.number)
                stk.addLast(element);
            else{
                int op1 = stk.pollLast().operand;
                int op2 = stk.pollLast().operand;
                switch(element.operator){
                    case '+' :
                        stk.addLast(new Element(op1 + op2,' ',true));
                        break;
                    case '-' :
                        stk.addLast(new Element(op2 - op1,' ',true));
                        break;
                    case '*' :
                        stk.addLast(new Element(op2 * op1,' ',true));
                        break;
                    case '/' :
                        stk.addLast(new Element(op2 / op1,' ',true));
                        break;
                }
            }
        }
        return stk.pollLast().operand;
    }
    public static void main(String[] args){
        System.out.print(new LeetCode227().calculate("  12 3 + 45 6 * 7 / 6 / 8 - 9"));
    }

}
