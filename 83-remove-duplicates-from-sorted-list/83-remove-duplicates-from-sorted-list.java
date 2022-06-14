/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null)
            return head;
        ListNode curr = head.next;
        ListNode prev = head;
        while(curr!=null)
        {
            if(curr.val==prev.val)
            {   ListNode temp=curr;
                curr=curr.next;
                prev.next=curr;
             temp.next=null;
            }
            else
            {
                prev=curr;
                curr=curr.next;
            }
        }
        
        return head;
    }
}