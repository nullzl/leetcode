package com.nullzl.leetcode700;

import java.util.LinkedList;

public class LeetCode679 {

    class Num{
        public int num1;
        public int num2;
        public Num(int n1,int n2){
            num1 = n1;
            num2 = n2;
        }

        public Num add(Num n){
            int b = this.num2 * n.num2;
            int a = this.num1 * n.num2 + n.num1 * this.num2;
            return new Num(a,b);
        }
        public Num subtract(Num n){
            int b = this.num2 * n.num2;
            int a = this.num1 * n.num2 - n.num1 * this.num2;
            return new Num(a,b);
        }
        public Num multiple(Num n){
            int b = this.num2 * n.num2;
            int a = this.num1 * n.num1;
            return new Num(a,b);
        }
        public Num divide(Num n){
            int b = this.num2 * n.num1;
            int a = this.num1 * n.num2;
            return new Num(a,b);
        }
    }

    private boolean check(LinkedList<Num> stk){
        Num n = stk.peek();
        return 24 == n.num1 / n.num2 && 0 == n.num1 % n.num2;
    }



    private boolean dfs(LinkedList<Num> stk,int[] cards,boolean[] used,int numCount,int opCount){
        if(numCount == 4 && opCount == 3){
            return check(stk);
        }
        boolean rs = false;
        if(numCount < 4){
            for(int i = 0 ; i < cards.length && !rs ; i++){
                if(!used[i]){
                    stk.push(new Num(cards[i],1));
                    used[i] = true;
                    rs = dfs(stk,cards,used,numCount + 1,opCount);
                    used[i] = false;
                    stk.pop();
                }
            }
        }
        if(!rs && numCount - opCount > 1){
            Num n1 = stk.pop();
            Num n2 = stk.pop();

            stk.push(n1.add(n2));
            rs = dfs(stk,cards,used,numCount,opCount + 1);
            stk.pop();

            if(!rs){
                stk.push(n1.subtract(n2));
                rs = dfs(stk,cards,used,numCount,opCount + 1);
                stk.pop();
            }
            if(!rs){
                stk.push(n1.multiple(n2));
                rs = dfs(stk,cards,used,numCount,opCount + 1);
                stk.pop();
            }
            if(!rs && 0 != n2.num1){
                stk.push(n1.divide(n2));
                rs = dfs(stk,cards,used,numCount,opCount + 1);
                stk.pop();
            }
            stk.push(n2);
            stk.push(n1);
        }
        return rs;
    }



    public boolean judgePoint24(int[] cards) {

        if(4 != cards.length)
            return false;
        LinkedList<Num> stk = new LinkedList<>();
        boolean[] used = new boolean[cards.length];
        return dfs(stk,cards,used,0,0);
    }
}
