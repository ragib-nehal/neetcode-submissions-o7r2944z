/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        Set<Integer> set = new HashSet<>();

        while (head != null) {
            if (set.contains(head.val) && head.next != null) {
                return true;
            }

            set.add(head.val);
            head = head.next;
            if (head == null) return false;
        }

        return false;
    }
}