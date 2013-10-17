/*
 * Construct Binary Tree from Inorder and Postorder Traversal
 *
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 *
 * Note:
 * You may assume that duplicates do not exist in the tree.
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        Map<Integer, Integer> m = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; i++) {
            m.put(inorder[i], i);
        }
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, m);
    }

    private TreeNode buildTree(int[] inorder, int inLeft, int inRight, int[] postorder, int postLeft, int postRight, Map<Integer, Integer> m) {
        if (inLeft > inRight) return null;
        TreeNode node = new TreeNode(postorder[postRight]);
        int index = m.get(postorder[postRight]);
        int leftSize = index - inLeft;
        int rightSize = inRight - index;
        node.left = buildTree(inorder, inLeft, index - 1, postorder, postLeft, postLeft + leftSize - 1, m);
        node.right = buildTree(inorder, index + 1, inRight, postorder, postRight - rightSize, postRight - 1, m);
        return node;
    }
}
