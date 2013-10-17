/**
 * Sum Root to Leaf Numbers
 *
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * Find the total sum of all root-to-leaf numbers.
 *
 * For example,
 *   1
 *  / \
 * 2   3
 *
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * Return the sum = 12 + 13 = 25.
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
  public int sumNumbers(TreeNode root) {
    // Note: The Solution object is instantiated only once and is reused by each test case.
    ArrayList<Integer> al = new ArrayList<Integer>();
    return sumNumbers(root, al);
  }

  private int sumNumbers(TreeNode node, ArrayList<Integer> al) {
    if (node == null) return 0;
    al.add(node.val);
    int left = sumNumbers(node.left, al);
    int right = sumNumbers(node.right, al);
    int result = 0;
    if (left == 0 && right == 0) result = computeSum(al);
    else result = left + right;
    al.remove(al.size() - 1);
    return result;
  }

  private int computeSum(ArrayList<Integer> al) {
    double result = 0;
    for (int i = 0; i < al.size(); i++) {
      result += al.get(i) * Math.pow(10, al.size() - i - 1);
    }
    return (int) result;
  }
}
