/**
 * Binary Tree Level Order Traversal
 *
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 *
 * For example:
 * Given binary tree {3,9,20,#,#,15,7},
 *
 *   3
 *  / \
 * 9  20
 *   /  \
 *  15   7
 *
 * return its level order traversal as:
 *
 * [
 *  [3],
 *  [9,20],
 *  [15,7]
 * ]
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
  public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
    // Note: The Solution object is instantiated only once and is reused by each test case.
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> al = new ArrayList<Integer>();
    if (root == null) {
      return result;
    }
    int current = 1;
    int next = 0;
    LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
    queue.add(root);
    while (!queue.isEmpty()) {
      for (int j = 0; j < current; j++) {
        TreeNode node = queue.remove();
        al.add(node.val);
        if (node.left != null) {
          queue.add(node.left);
          next++;
        }
        if (node.right != null) {
          queue.add(node.right);
          next++;
        }
      }
      result.add(copy(al));
      al.clear();
      current = next;
      next = 0;
    }
    return result;
  }

  private ArrayList<Integer> copy(ArrayList<Integer> origin) {
    ArrayList<Integer> result = new ArrayList<Integer>();
    for (int i : origin) {
      result.add(i);
    }
    return result;
  }
}
