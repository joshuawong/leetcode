/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null)
            return false;
        ListNode quicker = head;
        ListNode slower = head;
        while(quicker.next != null && quicker.next.next != null){
            slower = slower.next;
            quicker = quicker.next.next;
            if(slower == quicker)
                return true;
        }
        return false;
    }
}
