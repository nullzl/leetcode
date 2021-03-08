package com.nullzl.leetcode200;

import com.nullzl.util.TreeNode;

import java.util.Iterator;
import java.util.LinkedList;

public class LeetCode173 {

    class BSTIterator {

        private LinkedList<TreeNode> list;

        public BSTIterator(TreeNode root) {
            list = new LinkedList<>();
            TreeNode node = root;
            while(null != node){
                list.push(node);
                node = node.left;
            }
        }

        /** @return the next smallest number */
        public int next() {
            TreeNode node = this.list.pop();
            if(null != node) {
                int rs = node.val;
                node = node.right;
                while(null != node){
                    this.list.push(node);
                    node = node.left;
                }
                return rs;
            }
            return Integer.MIN_VALUE;
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return !this.list.isEmpty();
        }
    }
}
