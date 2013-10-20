/**
 * Binary Tree Zigzag Level Order Traversal
 *
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
 *
 * For example:
 * Given binary tree {3,9,20,#,#,15,7},
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * return its zigzag level order traversal as:
 *
 * [
 *  [3],
 *  [20,9],
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
  public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> al = new ArrayList<Integer>();
    if (root == null) {
      return result;
    }
    int current = 1;
    int next = 0;
    boolean isOdd = true;
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
      result.add(copy(al, isOdd));
      al.clear();
      current = next;
      next = 0;
      isOdd = !isOdd;
    }
    return result;
  }

  private ArrayList<Integer> copy(ArrayList<Integer> origin, boolean isOdd) {
    ArrayList<Integer> result = new ArrayList<Integer>();
    if (!isOdd) {
      Stack<Integer> stack = new Stack<Integer>();
      for (int i : origin) {
        stack.push(i);
      }
      while (!stack.isEmpty()) {
        result.add(stack.pop());
      }
    } else {
      for (int i : origin) {
        result.add(i);
      }
    }
    return result;
  }
}
