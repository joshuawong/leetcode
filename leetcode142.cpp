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
    ListNode *detectCycle(ListNode *head) {
        if(head == NULL || head->next == NULL)
        	return NULL;
        ListNode *first = head;
        ListNode *second = head;
        while(second!=NULL && second->next!=NULL)
        {
        	second = second->next->next;
        	first = first->next;
        	if(first == second)
        	{
        	    first = head;
        	    while(first != second)
        	    {
        	        first = first->next;
        	        second = second->next;
        	    }
        	    return second;
        	}
        }
        return NULL;
    }
};
