package main.java.com.nullzl.leetcode200;


import java.util.LinkedList;

class MinStack {

    LinkedList<Integer> stk;
    LinkedList<Integer> minStk;
    public MinStack() {
        this.stk = new LinkedList<>();
        this.minStk = new LinkedList<>();

    }

    public void push(int x) {
        this.stk.push(x);
        if(this.minStk.isEmpty() || x <= this.minStk.peek()){
            this.minStk.push(x);
        }

    }

    public void pop() {
        int rs = this.stk.pop();
        if(rs == this.minStk.peek())
            this.minStk.pop();

    }

    public int top() {
        return this.stk.peek();
    }

    public int getMin() {
        return this.minStk.peek();
    }
}

public class LeetCode155 {


}
