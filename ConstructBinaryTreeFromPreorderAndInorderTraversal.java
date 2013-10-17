/**
 * Construct Binary Tree from Preorder and Inorder Traversal
 *
 * Given preorder and inorder traversal of a tree, construct the binary tree.
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        Map<Integer, Integer> m = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; i++) {
            m.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, m);
    }

    private TreeNode buildTree(int[] preorder, int preLeft, int preRight, int[] inorder, int inLeft, int inRight, Map<Integer, Integer> m) {
        if (inLeft > inRight) return null;
        TreeNode node = new TreeNode(preorder[preLeft]);
        int index = m.get(preorder[preLeft]);
        int leftSize = index - inLeft;
        int rightSize = inRight - index;
        node.left = buildTree(preorder, preLeft + 1, preLeft + leftSize, inorder, inLeft, index - 1, m);
        node.right = buildTree(preorder, preRight - rightSize + 1, preRight, inorder, index + 1, inRight, m);
        return node;
    }
}
