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
    ListNode* reverseList(ListNode* head) {
        ListNode node(0);
        ListNode* L = &node;
        L->next = NULL;
        while(head != NULL)
        {
        	ListNode* q = head->next;
        	head->next = L->next;
        	L->next = head;
        	head = q;
        }
        return L->next;
    }
};