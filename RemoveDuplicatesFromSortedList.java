/**
 * Remove Duplicates from Sorted List
 *
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 *
 * For example,
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
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
    Set<Integer> s = new HashSet<Integer>();
    head = deleteDuplicates(head, s);
    return head;
  }

  private ListNode deleteDuplicates(ListNode node, Set<Integer> s) {
    if (node == null) return null;
    if (!s.contains(node.val)) {
      s.add(node.val);
      node.next = deleteDuplicates(node.next, s);
    } else if (node.next != null) {
      node.val = node.next.val;
      node = deleteDuplicates(node.next, s);
    } else node = null;
    return node;
  }
}
