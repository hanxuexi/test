package yibai;

import utils.ListNode;
import utils.TreeNode;

public class ReorderList143 {

    /**
     * 思路：采用递归方法来解决，
     * 因为每次处理首尾节点都要找到尾节点，但是单链表不允许这么做
     * 于是，我们从内部开始处理，每次处理完，返回当前结点序列的尾节点的next节点
     * 如1->2->3>4>5
     * 整个转换过程中：有如下几步：1->5,5->2,||||  2->4,4->3 ||| 3->null
     * 每次节点交换完后，节点交换的范围就减少了两个
     * 问题的难度就是在于如何找到5，4，3这几个节点
     * 采用递归的思想是：先对内部节点进行处理，然后再处理外面的
     * 如 我们相对3节点进行处理，处理完3，我们可以将3的next节点返回，也就是4
     * 接下来就可以处理以4为尾节点的序列了
     *
     *
     *
     * **/
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        int len = 0;
        ListNode h = head;
        //求出节点数
        while (h != null) {
            len++;
            h = h.next;
        }

        helper(head, len);
    }

    public ListNode helper(ListNode head, int len) {

        /**
         * 说明到了最内部，只需返回该节点的next节点就行，再将该节点的next节点置空就好
         * 也就是当 head = 3 的时候
         * */
        if (len == 1) {
            ListNode outTail = head.next;
            head.next = null;
            return outTail;
        }
        /**
         * 以 1->2->3->4为例
         * 当len = 2 时，则代表对2 ，3 进行操作
         * 显然不需要进行操作，只需返回4即可，并把3.next置空
         *
         * */
        if (len == 2) {
            ListNode outTail = head.next.next;
            head.next.next = null;
            return outTail;
        }

        ListNode tail = helper(head.next, len - 2);

        ListNode subNode = head.next;
        ListNode outTail = tail.next;
        head.next = tail;
        tail.next = subNode;
        return outTail;
    }
}
