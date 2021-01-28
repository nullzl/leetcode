package main.java.com.nullzl.leetcode200;

import main.java.com.nullzl.util.ListNode;

public class LeetCode142 {

    /**
     * 快慢指针，都从head开始，快指针每次两步，慢指针每次一步
     * 假设有环，设环长度为m
     * 设第一次走到环点，慢指针走了k步，则快指针走2k步，则快指针停在了环上k%m处的位置
     * 此时，快指针落后慢指针k-k%m步，所以慢指针再走k-k%m步，二者相遇
     * 相遇点距离环点k%m步，此时将慢指针拉回到head
     * 快慢指针每次都走一步，k步后，慢指针到达环点，快指针也到达环点
     *
     */

    public ListNode detectCycle(ListNode head) {

        if(null == head)
            return null;

        ListNode slow = head;
        ListNode fast = head;

        while(null != fast){
            slow = slow.next;
            fast = (null == fast.next ? null : fast.next.next);
            if(slow == fast)
                break;
        }
        if(null == fast)
            return null;
        slow = head;
        while(fast != slow){
            slow = slow.next;
            fast = fast.next;
        }
        return fast;

    }
}
