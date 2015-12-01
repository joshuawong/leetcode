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
    ListNode* removeElements(ListNode* head, int val) {
        ListNode* proot = new ListNode(0);
        proot->next = head;
        ListNode* cur;
        ListNode* pre;
        pre = proot;
        cur = head;
        if(head == NULL)
            return head;
            
        while(cur)
        {
            if(cur->val != val)
            {
                pre = cur;
                cur = cur->next;
            }
            else
            {
                pre->next = cur->next;
                cur = cur->next;
            }
        }
        return proot->next;
    }
};