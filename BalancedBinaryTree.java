/**
 * Balanced Binary Tree
 *
 * Given a binary tree, determine if it is height-balanced.
 *
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
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
  public boolean isBalanced(TreeNode root) {
    // Note: The Solution object is instantiated only once and is reused by each test case.
    if (root == null) return true;
    int lDepth = depth(root.left);
    int rDepth = depth(root.right);
    if (lDepth == -1 || rDepth == -1) return false;
    if (Math.abs(lDepth - rDepth) > 1) return false;
    return true;
  }

  private int depth(TreeNode node) {
    if (node == null) return 0;
    int lDepth = depth(node.left);
    int rDepth = depth(node.right);
    if (lDepth == -1 || rDepth == -1) return -1;
    if (Math.abs(lDepth - rDepth) > 1) return -1;
    else return (Math.max(lDepth + 1, rDepth + 1));
  }
}
