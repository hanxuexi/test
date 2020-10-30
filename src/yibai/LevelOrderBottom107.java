package yibai;

import java.util.*;

public class LevelOrderBottom107 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
    /**
     * 思路：按层次遍历，把每一层的节点值放在一个集合里面
     *      层次遍历借助队列来实现，
     *      每次循环出队列时，先统计队列中有多少个节点（为该层的节点数），然后依次吧这些节点出队列
     *      出队列的同时，将左右孩子不为空的入队列
     *      继续遍历知道队列为空
     *
     * */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        // 如果为空，则返回一个空的集合
        if(root == null) return Collections.emptyList();
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        while (!q.isEmpty()) {
            List<Integer> temp = new ArrayList<Integer>();
            int size = q.size();
            for (int i = 0; i < size; i++) {
                root = q.poll();
                temp.add(root.val);
                if (root.left != null)  q.offer(root.left);
                if (root.right != null) q.offer(root.right);
            }
            list.add(temp);
        }
        Collections.reverse(list);
        return list;
    }
}
