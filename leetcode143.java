/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
     public ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        while(head != null){
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }
    
    public void reorderList(ListNode head) {
        if(head==null||head.next==null) 
            return;
        ListNode mid = head;
        ListNode end = head;
        // find the middle node, p1 denotes the middle node
        while(end.next != null && end.next.next != null){
            mid = mid.next;
            end = end.next.next;
        }
        
        end = mid.next;
        // divide into two lists
        mid.next = null;
        
        // reverse list after middle node
        mid = reverseList(end);
        
        // reorder list 
        ListNode cur = head;
        while(mid != null){
            ListNode tmp = cur.next;
            cur.next = mid;
            mid = mid.next;
            cur = cur.next;
            cur.next = tmp;
            cur = cur.next;
        }
        
    }
}
