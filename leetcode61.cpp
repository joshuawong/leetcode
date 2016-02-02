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
    ListNode* rotateRight(ListNode* head, int k) {
        if(head == NULL)
        	return NULL;
        int size = 0;
        ListNode *p = head;
        ListNode *q = head;
        ListNode *res = head;
        while(p != NULL)
        {
        	// get the size of linked-list
        	p = p->next;
        	size++;
        }
        // q = p;
        if(k >= size) 
        	k %= size;
        if(k == 0)
        	return head;
        p = head;
        for (int i = 0; i < k; ++i)
        {
         	//find the rotate node
        	p = p->next;
        }
        while(p->next != NULL)
        {
        	p = p->next;
        	q = q->next;
        } 
        res = q->next;
        q->next = NULL;
        p->next = head;
        return res;
    }
};
