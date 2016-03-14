/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode vHead = new ListNode(0);
        vHead.next = head;
        ListNode pre = vHead;
        while(pre.next != null && pre.next.next != null){
            ListNode cur = pre.next;
            ListNode tmp = pre.next.next;
            cur.next = tmp.next;
            pre.next = tmp;
            pre.next.next = cur;
            pre = pre.next.next;
        }
        return vHead.next;
    }
}
