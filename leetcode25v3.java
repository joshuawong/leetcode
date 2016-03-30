/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k < 2){
            return head;
        }
        ListNode vHead = new ListNode(0);
        vHead.next = head;
        ListNode cur = vHead, next, pre = vHead;
        int len = 0;
        while(cur.next != null){
            len++;
            cur = cur.next;
        }
        while(len >= k){
            cur = pre.next;
            next = cur.next;
            int count = k;
            for(int i = 1; i < k ;++i){
                cur.next = next.next;
                next.next = pre.next;
                pre.next = next;
                next = cur.next;
            }
            pre = cur;
            len -= k;
        }
        return vHead.next;
    }
}
