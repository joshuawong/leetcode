/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0)
            return null;
        return helper(lists,0,lists.length - 1);
    }

    private ListNode helper(ListNode[] lists, int start, int end){
        if(start == end)
            return lists[start];
        else if(start < end){
            int mid = start + (end - start) / 2;
            ListNode left = helper(lists,start,mid);
            ListNode right = helper(lists,mid+1,end);
            return mergeTwoLists(left,right);
        }
        else
            return null;
    }
    
     public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }

        ListNode mergeHead;
        if(l1.val < l2.val){
            mergeHead = l1;
            mergeHead.next = mergeTwoLists(l1.next, l2);
        }
        else{
            mergeHead = l2;
            mergeHead.next = mergeTwoLists(l1, l2.next);
        }
        return mergeHead;
    }
}
