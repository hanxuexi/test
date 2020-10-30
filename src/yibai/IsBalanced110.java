package yibai;

import utils.TreeNode;

public class IsBalanced110 {

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        // 判断当前节点以及当前节点的左右孩子是否满足高度平衡的二叉树的定义
        return Math.abs(length(root.left) - length(root.right)) <=1 && isBalanced(root.left) && isBalanced(root.right);
    }

    // 计算以当前节点为根节点的子树的高度
    public int length(TreeNode root) {
        if (root==null) return 0;
        return Math.max(length(root.left) , length(root.right)) + 1;
    }
//    ---------------------------------------------------------------------
    /**
     * 第二种解法：也是最优解
     * recur(root):
     * 递归返回值：
     * 当节点root 左 / 右子树的高度差 < 2 ：则返回以节点root为根节点的子树的最大高度，即节点 root 的左右子树中最大高度加1：（ max(left, right) + 1 ）；
     * 当节点root 左 / 右子树的高度差 ≥2 ：则返回 -1 ，代表此子树不是平衡树 。
     * 递归终止条件：
     * 当越过叶子节点时，返回高度 0 ；
     * 当左（右）子树高度 left== -1 时，代表此子树的 左（右）子树 不是平衡树，因此直接返回 -1 ；
     * isBalanced(root) ：
     *
     * 返回值： 若 recur(root) != 1 ，则说明此树平衡，返回 truetrue ； 否则返回 falsefalse 。
     * */
    public boolean isBalanced1(TreeNode root) {
        return recur(root) != -1;
    }

    private int recur(TreeNode root) {
        if (root == null) return 0;
        int left = recur(root.left);
        if(left == -1) return -1;
        int right = recur(root.right);
        if(right == -1) return -1;
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }
}
