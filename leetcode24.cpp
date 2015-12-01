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
    ListNode* swapPairs(ListNode* head) {
        ListNode* first;
        ListNode* second;
        if (head == NULL || head->next == NULL)
        {
        	return head;
        }
        first = head;
        second = head->next;
        while(second != NULL && first != NULL)
        {
        	int tmp = first->val;
        	first->val = second->val;
        	second->val = tmp; 
        	if(first->next!=NULL)
        		first = first->next->next;
        	if(second->next!=NULL)
        		second = second->next->next;
        }
        return head;
    }
};