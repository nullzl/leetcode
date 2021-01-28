package main.java.com.nullzl.leetcode100;

import main.java.com.nullzl.util.ListNode;

public class LeetCode23 {

    private void heapify(ListNode[] lists, int root, int len ){
        int left = (root << 1) + 1;
        int right = (root << 1) + 2;
        int min = root;
        if(left < len && lists[left].val < lists[min].val){
            min = left;
        }
        if(right < len && lists[right].val < lists[min].val){
            min = right;
        }
        if(min != root){
            ListNode temp = lists[root];
            lists[root] = lists[min];
            lists[min]= temp;
            heapify(lists,min,len);
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if(null == lists)
            return null;
        if(1 == lists.length)
            return lists[0];

        int len = lists.length;
        for(int i = 0 ; i < len ; ){
            if(null == lists[i]){
                len--;
                lists[i] = lists[len];
                lists[len] = null;
            }else{
                i++;
            }
        }

        for(int i = ((len - 2) / 2) ; i > 0 ; i--)
            heapify(lists,i,len);

        ListNode curNode = new ListNode(0);
        ListNode head = curNode;

        while(len > 0){
            heapify(lists,0,len);
            curNode.next = lists[0];
            curNode = lists[0];
            lists[0] = curNode.next;

            if(null == lists[0]){
                len--;
                lists[0] = lists[len];
                lists[len] = null;
            }
        }
        return head.next;
    }
}
