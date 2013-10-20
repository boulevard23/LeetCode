/**
 * Convert Sorted Array to Binary Search Tree
 *
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
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
  public TreeNode sortedArrayToBST(int[] num) {
    // Note: The Solution object is instantiated only once and is reused by each test case.
    return sortedArrayToBST(num, 0, num.length - 1);
  }

  private TreeNode sortedArrayToBST(int[] num, int left, int right) {
    if (left > right) return null;
    int mid = (left + right) / 2;
    TreeNode node = new TreeNode(num[mid]);
    node.left = sortedArrayToBST(num, left, mid - 1);
    node.right = sortedArrayToBST(num, mid + 1, right);
    return node;
  }
}
