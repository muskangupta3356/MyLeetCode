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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null)
            return head;
        if(left == right)
            return head;
        
        ListNode curr = head;
        ListNode prev = null;
        
        for(int i=1;i<left;i++){
            prev= curr;
            curr = curr.next;
        }
        int count = right - left +1;
        ListNode beforeLeft = prev;
        ListNode leftNode = curr;
        
        
        prev= null;
        ListNode next = null;
        while(count!=0){
            next= curr.next;
            curr.next =prev;
            prev = curr;
            curr= next;
            count--;
        }
        if(beforeLeft != null)
        beforeLeft.next = prev;
        leftNode.next = curr;
        
        // if(curr != null)
        //     return head;
        // else
        //     return prev;
        if(beforeLeft != null)
            return head;
        else
            return prev;
        
    }
}