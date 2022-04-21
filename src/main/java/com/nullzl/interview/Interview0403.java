package com.nullzl.interview;

import com.nullzl.util.ListNode;
import com.nullzl.util.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class Interview0403 {

    private ListNode addNode(List<TreeNode> nodes,ListNode tail,TreeNode node){
        if(null == node)
            return tail;
        nodes.add(node);
        tail.next = new ListNode(node.val);
        return tail.next;
    }

    public ListNode[] listOfDepth(TreeNode tree) {
        if(null == tree)
            return new ListNode[0];

        List<ListNode> lists = new LinkedList<>();
        List<TreeNode> cur = new LinkedList<>();
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        lists.add(new ListNode(tree.val));
        cur.add(tree);

        while(!cur.isEmpty()){
            List<TreeNode> next = new LinkedList<>();
            for(TreeNode node : cur){
                tail = addNode(next,tail,node.left);
                tail = addNode(next,tail,node.right);
            }
            cur = next;
            if(null != dummy.next)
                lists.add(dummy.next);
            dummy.next = null;
            tail = dummy;
        }
        return lists.toArray(new ListNode[0]);
    }
}
