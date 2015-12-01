/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode* removeNthFromEnd(ListNode* head, int n) {
    	ListNode root= new ListNode(0);
    	root->next = head;
        ListNode* fast = root;
        ListNode* slow = root;
        if(head == NULL)
        	return NULL;
        for (int i = 0; i < n; ++i)
        {
        	fast = fast->next;
        }
        while(fast->next != NULL)
        {
        	fast = fast->next;
        	slow = slow->next;
        }
        slow->next = slow->next->next;
        return root->next;
    }
};