/**
 * Symmetric Tree
 *
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * For example, this binary tree is symmetric:
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *
 * But the following is not:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *     3    3
 *
 * Note:
 * Bonus points if you could solve it both recursively and iteratively.
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
  public boolean isSymmetric(TreeNode root) {
    // Note: The Solution object is instantiated only once and is reused by each test case.
    if (root == null) return true;
    ArrayList<Integer> order = new ArrayList<Integer>();
    inorder(root, order);
    int size = order.size();
    if (size % 2 != 1) return false;
    for (int i = 0; i < size / 2 + 1; i++) {
      if (order.get(i) != order.get(size - i - 1)) return false;
    }
    return true;
  }

  private void inorder(TreeNode node, ArrayList<Integer> order) {
    if (node == null) return;
    inorder(node.left, order);
    visit(node, order);
    inorder(node.right, order);
  }

  private void visit(TreeNode node, ArrayList<Integer> order) {
    order.add(node.val);
  }
}
