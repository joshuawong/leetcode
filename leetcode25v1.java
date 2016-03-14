/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    private void reverseList(ListNode head, ListNode tail){
        ListNode cur = head;
        ListNode next = head.next;
        // ListNode tmp = null;
        while(next != tail){
            ListNode tmp = next.next;
            next.next = cur;
            cur = next;
            next = tmp;
        }
        next.next = cur;
        head.next = null;
    }
    
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k < 2)
            return head;
        ListNode vHead = new ListNode(0);
        vHead.next = head;
        ListNode tail = null;
        ListNode beforeHead = vHead;
        ListNode afterTail = null;
        int count = 0;
        while(head != null){
            tail = head;
            count = k;
            while(tail != null && --count != 0){
                tail = tail.next;
            }
            if(count != 0){
                break;
            }
            afterTail = tail.next;
            reverseList(head,tail);
            beforeHead.next = tail;
            head.next = afterTail;
            beforeHead = head;
            head = afterTail;
        }
        return vHead.next;
    }
}
