/**
 * Convert Sorted List to Binary Search Tree
 *
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 *
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class Solution {
  public TreeNode sortedListToBST(ListNode head) {
    // Note: The Solution object is instantiated only once and is reused by each test case.
    int size = 0;
    ListNode node = head;
    while (node != null) {
      size++;
      node = node.next;
    }
    return sortedListToBST(head, 0, size - 1);
  }

  private TreeNode sortedListToBST(ListNode node, int left, int right) {
    if (left > right) return null;
    int mid = left + (right - left) / 2;
    TreeNode leftNode = sortedListToBST(node, left, mid - 1);
    TreeNode parent = new TreeNode(node.val);
    parent.left = leftNode;
    if (node.next != null) {
      node.val = node.next.val;
      node.next = node.next.next;
    }
    parent.right = sortedListToBST(node, mid + 1, right);
    return parent;
  }
}
