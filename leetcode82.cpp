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
    ListNode* deleteDuplicates(ListNode* head) {
        ListNode* before = new ListNode(0);
        before->next = head;
        ListNode* cur;
        cur = before;
        if(head == NULL)
        	return NULL;
        int dup;
        while(cur->next != NULL && cur->next->next != NULL){
            if(cur->next->val == cur->next->next->val){
                dup = cur->next->val;
                while(cur->next != NULL && cur->next->val == dup){
                    	cur->next = cur->next->next;
                }
            }
            else{
        	    cur = cur->next;
            }
        }
        return before->next;
    }
};
