/**
 * Populating Next Right Pointers in Each Node II
 *
 * Follow up for problem "Populating Next Right Pointers in Each Node".
 *
 * What if the given tree could be any binary tree? Would your previous solution still work?
 *
 * Note:
 * You may only use constant extra space.
 *
 * For example,
 * Given the following binary tree,
 *
 *        1
 *      /  \
 *     2    3
 *    / \    \
 *   4   5    7
 *
 * After calling your function, the tree should look like:
 *
 *        1 -> NULL
 *      /  \
 *     2 -> 3 -> NULL
 *    / \    \
 *   4-> 5 -> 7 -> NULL
 *
 */

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
  public void connect(TreeLinkNode root) {
    // Note: The Solution object is instantiated only once and is reused by each test case.
    if (root == null) return;

    while (root != null) {
      TreeLinkNode prev = null;
      TreeLinkNode next = null;

      for (; root != null; root = root.next) {
        if (root.left == null && root.right == null) continue;

        if (next == null) next = root.left != null ? root.left : root.right;

        if (root.left != null) {
          if (prev != null) prev.next = root.left;
          prev = root.left;
        }

        if (root.right != null) {
          if (prev != null) prev.next = root.right;
          prev = root.right;
        }
      }

      root = next;
    }
  }
}
