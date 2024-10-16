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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode first = l1;
        ListNode second = l2;
        if(first == null)
            return second;
        if(second == null)
            return first;
        int carryover = 0; int value = 0; int add = 0; ListNode head = null;ListNode tail = null;
        while(first != null || second != null){
            ListNode node = new ListNode();
            if(head == null && tail == null){
                head = tail = node;
            }else{
                tail.next = node;
                tail = node;
            }
            add = carryover;
            if(first != null){
                add = add + first.val;
            }
            if(second != null){
                add = add + second.val;
            }
            value = add % 10;
            carryover = add/10;
            node.val = value;
            if(first != null)
                first = first.next;
            if(second != null)
                second = second.next;
        }
       
        while(carryover != 0){
            ListNode node = new ListNode();
             if(head == null && tail == null){
                head = tail = node;
            }else{
                tail.next = node;
                tail = node;
            }
            node.val = carryover%10;
            carryover = carryover /10;
        }
        return head;
}
}