/**
 * Path Sum II
 *
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 *
 * For example:
 * Given the below binary tree and sum = 22,
 *
 *             5
 *            / \
 *           4   8
 *          /   / \
 *         11  13  4
 *        /  \    / \
 *       7    2  5   1
 *
 * return
 *
 * [
 *  [5,4,11,2],
 *  [5,8,4,5]
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
  public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
    // Note: The Solution object is instantiated only once and is reused by each test case.
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> al = new ArrayList<Integer>();
    sumPath(root, al, sum, result);
    return result;
  }

  private void sumPath(TreeNode node, ArrayList<Integer> al, int sum, ArrayList<ArrayList<Integer>> result) {
    if (node == null) return;
    al.add(node.val);
    if (node.left == null && node.right == null) {
      if (computeSum(al) == sum) {
        result.add(copy(al));
      }
    } else {
      sumPath(node.left, al, sum, result);
      sumPath(node.right, al, sum, result);
    }

    al.remove(al.size() - 1);
    return;
  }

  private int computeSum(ArrayList<Integer> al) {
    int result = 0;
    for (int i : al) {
      result += i;
    }
    return result;
  }    private ArrayList<Integer> copy(ArrayList<Integer> origin) {
    ArrayList<Integer> result = new ArrayList<Integer>();
    for (int i :origin) {
      result.add(i);
    }
    return result;
  }
}
