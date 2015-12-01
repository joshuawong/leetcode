/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
private:
	int lengthoflist(ListNode *head)
	{
		if(head == NULL)
			return 0;
		int result = 0;
		ListNode* node;
		node = head;
		while(node != NULL)
		{
			result++;
			node = node->next;
		}
		return result;
	}

public:
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
        int aLen,bLen;
        if(headA == NULL || headB == NULL)
            return NULL;
        else{
            aLen = lengthoflist(headA);
            bLen = lengthoflist(headB);
            int dist;
            if(aLen < bLen){
                dist = bLen - aLen;
                while(dist){
                    headB = headB->next;
                    dist--;
                }
            }
            if(aLen > bLen){
                dist = aLen - bLen;
                while(dist){
                    headA = headA->next;
                    dist--;
                }
            }
            while(headB != headA){
                    headB = headB->next;
                    headA = headA->next;
            }
           return headB;
        }
    }
};