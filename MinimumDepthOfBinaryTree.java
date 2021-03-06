/**
 * Minimum Depth of Binary Tree
 *
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 *
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
  public int minDepth(TreeNode root) {
    // Note: The Solution object is instantiated only once and is reused by each test case.
    if (root == null) return 0;
    if (root.left == null && root.right == null) return 1;
    else if (root.left == null || root.right == null) return Math.max(minDepth(root.left), minDepth(root.right)) + 1;
    return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
  }
}
