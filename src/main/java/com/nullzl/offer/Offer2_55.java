package com.nullzl.offer;

import com.nullzl.util.TreeNode;

import java.util.LinkedList;

public class Offer2_55 {

    class BSTIterator {

        private TreeNode cur;
        private LinkedList<TreeNode> stk;

        public BSTIterator(TreeNode root) {
            cur = root;
            stk = new LinkedList<>();
            push();
        }

        private void push(){
            while(null != cur){
                stk.push(cur);
                cur = cur.left;
            }
        }

        public int next() {
            cur = stk.pop();
            int val = cur.val;
            cur = cur.right;
            push();
            return val;
        }

        public boolean hasNext() {
            return !stk.isEmpty();
        }
    }
}
