package yibai;

import utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;


public class HasPathSum112 {

    /**
     * 递归算法，
     *  从第一个节点开始，如果该节点的val ！= sum，则sum = sum - root.val,
     *  继续遍历该节点的左右孩子，依次判断
     *
     * */
    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) return sum == root.val;
        return hasPathSum(root.left,sum-root.val) || hasPathSum(root.left,sum-root.val);
    }
    /**
     * 首先我们可以想到使用广度优先搜索的方式，记录从根节点到当前节点的路径和，以防止重复计算。
     * 这样我们使用两个队列，分别存储将要遍历的节点，以及根节点到这些节点的路径和即可。
     *
     * */
    public boolean hasPathSum1(TreeNode root, int sum) {
        if (root == null) return false;
        Queue<TreeNode> node = new LinkedList<TreeNode>();
        Queue<Integer> nodeVal = new LinkedList<Integer>();
        node.offer(root);
        nodeVal.offer(root.val);
        while (!node.isEmpty()) {
            TreeNode temp = node.poll();
            int tempVal = nodeVal.poll();
            if (temp.left==null && temp.right==null) {
                if(sum == tempVal) return true;
                continue;
            }
            if (temp.left!=null) {
                node.offer(temp.left);
                nodeVal.offer(temp.left.val + tempVal);
            }
            if (temp.right!=null) {
                node.offer(temp.right);
                nodeVal.offer(temp.right.val + tempVal);
            }
        }
        return false;
    }

}
