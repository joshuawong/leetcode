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
    //mergeSort
    ListNode* sortList(ListNode* head) {

        if(head == NULL || head->next==NULL) return head;

        ListNode *mid = getMid(head);
        ListNode *left = head,*right;

        if(mid){
            //cout<<mid->val<<endl;
            right = mid->next;
            mid->next = NULL;
        }

        return mergeLinkedList(sortList(left),sortList(right));

    }
    //get middle point from ListNode
    ListNode* getMid(ListNode* head){
        if(head==NULL || head->next==NULL ) return head;

        ListNode* first = head,* second = head->next;

        while(second && second->next){
            first = first->next;
            second = second->next->next;
        }
        return first;
    }

    //merge two sorted Linked List
    ListNode* mergeLinkedList(ListNode* first,ListNode* second){
        if(first==NULL) return second;
        if(second==NULL) return first;

        ListNode* tail,* front;
        front = new ListNode(-1);
        tail = front;
        while(first && second){
            if(first->val < second->val){
                tail->next = first;
                first = first->next;
                tail = tail->next;
            }else{
                tail->next = second;
                second = second->next;
                tail = tail->next;
            }
        }
        if(first){
            tail->next =first;
        }
        if(second){
            tail->next = second;
        }
        front = front->next;
        return front;
    }
};