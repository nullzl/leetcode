package main.java.com.nullzl.leetcode200;

import main.java.com.nullzl.util.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class LeetCode145 {

    public List<Integer> postorderTraversal(TreeNode root) {

        LinkedList<Integer> rs = new LinkedList<Integer>();
        if(null == root)
            return rs;

        LinkedList<TreeNode> stk = new LinkedList<>();
        TreeNode cur = root;

        while(null != cur || !stk.isEmpty()){

            while(null != cur){
                stk.push(cur);
                cur = cur.left;
            }

            while(!stk.isEmpty() && (null == stk.peek().right || stk.peek().right == cur)){
                cur = stk.pop();
                rs.add(cur.val);
            }
            if(!stk.isEmpty())
                cur = stk.peek().right;
            else
                cur = null;

        }
        return rs;

    }
}
