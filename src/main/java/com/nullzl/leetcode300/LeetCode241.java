package com.nullzl.leetcode300;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode241 {

    List<Integer> ans = new ArrayList<>();

    public void visit(String[][] strs,int size,String[][] ops,int i,String[][] exp,int idx){
        if(idx == exp.length) {
            for(int j = i - 1 ; j >= 0 ; j--)
                strs[size++] = ops[j];
            ans.add(compute(strs));
            return;
        }
        if("0".equals(exp[idx][0])){
            strs[size++] = exp[idx];
            visit(strs,size,ops,i,exp,idx + 1);
            return ;
        }

        for(int j = 0 ; j <= i ; j++){
            for(int k = 0 ; k < j ; k++)
                strs[size + k] = ops[i - k - 1];
            ops[i - j] = exp[idx];
            visit(strs,size + j,ops,i - j + 1,exp,idx + 1);
            for(int k = 0 ; k < j ; k++)
                ops[i - j + k] = strs[size + j - 1 - k];
        }
    }

    public int compute(String[][] strs){
        LinkedList<Integer> stk = new LinkedList<>();
        for(String[] s : strs){
            if("0".equals(s[0]))
                stk.push(Integer.parseInt(s[1]));
            else{
                int op1 = stk.pop();
                int op2 = stk.pop();
                if("+".equals(s[1])){
                    stk.push(op1 + op2);
                }else if("*".equals(s[1])){
                    stk.push(op1 * op2);
                }else{
                    stk.push(op1 - op2);
                }
            }
        }
        return stk.pop();
    }

    public List<Integer> diffWaysToCompute(String expression) {
        int idx = 0;
        char[] arr = expression.toCharArray();
        List<String[]> list = new ArrayList<>();
        while(idx < arr.length){
            if(arr[idx] < '0' || arr[idx] > '9') {
                list.add(new String[]{"1", new String(arr, idx++, 1)});
            }else {
                int j = idx;
                while (idx < arr.length && arr[idx] >= '0' && arr[idx] <= '9') idx++;
                list.add(new String[]{"0", new String(arr, j, idx - j)});
            }
        }
        String[][] exp = list.toArray(new String[0][]);
        String[][] strs = new String[exp.length][];
        String[][] ops = new String[exp.length][];
        visit(strs,0,ops,0,exp,0);
        return ans;
    }

}
