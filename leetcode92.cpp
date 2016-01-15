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
    ListNode* reverseBetween(ListNode* head, int m, int n) {
        ListNode* new_head = new ListNode(0);
        new_head->next = head;
        ListNode* pre = new_head;
        for (int i = 0; i < m-1; ++i)
        {
        	pre = pre->next;
        }
        ListNode* mth = pre->next;  			// find the mth Node
        for (int i = 0; i < n-m; ++i)
        {
        	ListNode* tmp = mth->next; 			//use tmp to store temp node until find the nth Node
        	mth->next = tmp->next;
        	tmp->next = pre->next;
        	pre->next = tmp
        }
        ListNode* nth = tmp;  //find the nth Node and finish the reverse

        return new_head->next;
    }
};
