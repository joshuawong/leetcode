/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null)
            return head;
        ListNode small = new ListNode(0);
        ListNode large = new ListNode(0);
        ListNode p1 = small, p2 = large;

        p1.next = head;
        while(p1.next != null){
            if(p1.next.val >= x){
                // 将large组成链表
                ListNode tmp = p1.next;
                p1.next = tmp.next;
                p2.next = tmp;
                p2 = p2.next;
            }
            else
                p1 = p1.next;
        }
        p2.next = null;
        p1.next = large.next;
        return small.next;
    }
}
