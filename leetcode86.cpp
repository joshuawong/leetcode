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
    ListNode* partition(ListNode* head, int x) {
  		ListNode less_head(0);
  		ListNode large_head(0);
  		ListNode* less = &less_head;
  		ListNode* larger = &large_head;
  		while(head)
  		{
  			if(head->val < x)
  			{
  				less->next = head;
  				less = less->next;
  			}

  			else
  			{
  				larger->next = head;
  				larger = larger->next;
  			}
  			head = head->next;
  		}      
  		less->next = large_head.next;
  		larger->next = NULL;
  		return less_head.next;
    }
};
