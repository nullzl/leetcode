package com.nullzl.offer;

import com.nullzl.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Offer2_43 {


    class CBTInserter {

        private List<TreeNode> list = new ArrayList<>();

        public CBTInserter(TreeNode root) {
            add(root);
            int i = 0;
            while(i < list.size()){
                TreeNode node = list.get(i++);
                add(node.left);
                add(node.right);
            }
        }

        private void add(TreeNode node){
            if(null != node)
                list.add(node);
        }

        public int insert(int v) {
            TreeNode node = new TreeNode(v);
            add(node);
            int idx = list.size() - 1;
            TreeNode parent = list.get((idx - 1) >> 1);
            if(0 != (1 & idx))
                parent.left = node;
            else
                parent.right = node;
            return parent.val;
        }

        public TreeNode get_root() {
            return 0 == list.size() ? null : list.get(0);
        }
    }
}
