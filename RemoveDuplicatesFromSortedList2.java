/**
 * Remove Duplicates from Sorted List 2
 *
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 *
 * For example,
 * Given 1->2->3->3->4->4->5, return 1->2->5.
 * Given 1->1->1->2->3, return 2->3.
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
  public ListNode deleteDuplicates(ListNode head) {
    // Note: The Solution object is instantiated only once and is reused by each test case.
    Map<Integer, Integer> s = new HashMap<Integer, Integer>();
    for (ListNode node = head; node != null; node = node.next) {
      if (s.containsKey(node.val)) {
        int i = s.get(node.val);
        s.put(node.val, i + 1);
      } else {
        s.put(node.val, 1);
      }
    }
    head = deleteDuplicates(head, s);
    return head;
  }

  private ListNode deleteDuplicates(ListNode node, Map<Integer, Integer> s) {
    if (node == null)
      return null;
    if (s.get(node.val) == 1) {
      node.next = deleteDuplicates(node.next, s);
    } else if (node.next != null) {
      node.val = node.next.val;
      node = deleteDuplicates(node.next, s);
    } else
      node = null;
    return node;
  }
}
