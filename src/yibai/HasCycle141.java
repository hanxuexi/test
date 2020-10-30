package yibai;

import utils.ListNode;
import utils.TreeNode;

public class HasCycle141 {

    /**
     *  通过使用具有 不同速度 的快、慢两个指针遍历链表，空间复杂度可以被降低至 O(1)O(1)。慢指针每次移动一步，而快指针每次移动两步。
     *  若不存在环，快指针首先达到尾部，直接返回false
     *  若存在环，存在一下两种情况
     *  ① 若fast刚好在slow后面一部，那么下次循环他们两就能遇到，从而返回true
     *  ② 若fast在slow后面两步，三步或以上，比如说，在slow后面两步，那么循环一次后，就变成①这种情况了
     *                                           若在slow三步，则循环两次后，就变成①这种情况了
     *                                           三步以上也是一样的，最终也会变成①这种情况
     *
     * */

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            // 这里不用判断slow是否为空，因为slow永远比fast慢
            if (fast == null || fast.next == null) return false;
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
    }
}
