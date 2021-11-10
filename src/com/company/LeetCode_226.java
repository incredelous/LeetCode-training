package com.company;

public class LeetCode_226 {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return root;
        return invertTreeNode(root);
    }

    private TreeNode invertTreeNode(TreeNode treeNode){
        if(treeNode == null) return treeNode;
        invertTreeNode(treeNode.left);
        invertTreeNode(treeNode.right);
        TreeNode temp = treeNode.left;
        treeNode.left = treeNode.right;
        treeNode.right = temp;
        return treeNode;
    }
}
