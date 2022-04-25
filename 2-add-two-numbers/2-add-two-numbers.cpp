
class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        
        ListNode* temp1=l1; ListNode* temp2=l2; ListNode* head=NULL; ListNode* tail=NULL;
        int s,c,v; s=0; c=0;
        while(temp1!=NULL && temp2!=NULL)
        {
             v=temp1->val+temp2->val+c;
             s=v%10;
             c=v/10;
            
           ListNode *newnode = new ListNode(s);
            if(head==NULL && tail==NULL)
            {
                head=newnode;
                tail=newnode;
            }
            else
            {
                tail->next= newnode;
                tail=newnode;
            }
            
            temp1=temp1->next;
            temp2=temp2->next;
        }
        
        if(temp1==NULL && temp2==NULL && c==0)
            return head;
        
        if(temp1==NULL && temp2==NULL && c!=0)
        {
         ListNode *newnode = new ListNode(c);
             tail->next= newnode;
                tail=newnode;
            return head;
        }
        
        else
        {
            while(temp1!=NULL)
            {
                
             v=temp1->val+c;
             s=v%10;
             c=v/10;
            
           ListNode *newnode = new ListNode(s);
            tail->next= newnode;
             tail=newnode; 
                temp1=temp1->next;
            }
            
             while(temp2!=NULL)
            {
                
             v=temp2->val+c;
             s=v%10;
             c=v/10;
            
           ListNode *newnode = new ListNode(s);
            tail->next= newnode;
             tail=newnode; 
                temp2=temp2->next;
            }
            if(c==0)
           return head; 
            else
            {
                 ListNode *newnode = new ListNode(c);
             tail->next= newnode;
                tail=newnode;
            return head;
            }
        }
        
        
        
    }
};