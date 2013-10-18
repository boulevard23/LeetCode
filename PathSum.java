/**
 * Path Sum
 *
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 *
 * For example:
 * Given the below binary tree and sum = 22,
 *
 *             5
 *            / \
 *           4   8
 *          /   / \
 *         11  13  4
 *        /  \      \
 *       7    2      1
 *
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
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
  public boolean hasPathSum(TreeNode root, int sum) {
    // Note: The Solution object is instantiated only once and is reused by each test case.
    ArrayList<Integer> al = new ArrayList<Integer>();
    return sumPath(root, al, sum);
  }

  private boolean sumPath(TreeNode node, ArrayList<Integer> al, int sum) {
    if (node == null) return false;
    boolean result = false;
    al.add(node.val);
    if (node.left == null && node.right == null) {
      if (computeSum(al) == sum) {
        result = true;
      } else {
        result = false;
      }
    } else {
      result = sumPath(node.left, al, sum) || sumPath(node.right, al, sum);
    }

    al.remove(al.size() - 1);
    return result;
  }

  private int computeSum(ArrayList<Integer> al) {
    int result = 0;
    for (int i : al) {
      result += i;
    }
    return result;
  }
}
