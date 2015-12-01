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
    bool isPalindrome(struct ListNode* head) {
    if (!head || !head->next) {  
        return true;  
    }  
    //快慢指针法，寻找链表中心  
    ListNode * slow, *fast;  
    slow = fast = head;  
    while (fast && fast->next) {  
        slow = slow->next;  
        fast = fast->next->next;  
    }  
    if (fast) {  
        //链表元素奇数个  
        slow->next = resverseList(slow->next);  
        slow = slow->next;  
    }else{  
         //链表元素偶数个  
        slow = resverseList(slow);  
    }  
    while (slow) {  
        if (head->val != slow->val) {  
            return false;  
        }  
        slow = slow->next;  
        head = head->next;  
    }  
    return true;  
}  

ListNode* resverseList(ListNode* head) {
    ListNode node(0);
    ListNode* L = &node;
    L->next = NULL;

    while(head!=NULL)
    {
        ListNode* q = head->next;
        head->next = L->next;
        L->next = head;  
        head = q;
    }

    return L->next;
}
};