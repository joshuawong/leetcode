/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null)
            return null;
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode cur = res;
        int dup = 0;
        while(cur.next != null && cur.next.next != null){
            if(cur.next.val == cur.next.next.val){
                dup = cur.next.val;
                while(cur.next != null && cur.next.val == dup){
                    cur.next = cur.next.next;
                }
            }
            else{
                cur = cur.next;
            }
        }
        return res.next;
    }
}
