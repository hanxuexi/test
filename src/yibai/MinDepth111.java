package yibai;

import utils.TreeNode;

public class MinDepth111 {

    /**
     * 这是大佬的代码
     * 简单易懂
     */

    public int minDepth(TreeNode root) {
        // return dept(root);
        if (root==null) return 0;
        int m1 = minDepth(root.left);
        int m2 = minDepth(root.right);
        return (m1!=0 && m2!=0)?Math.min(m1 , m2) + 1:m1 + m2 + 1;
    }
}
