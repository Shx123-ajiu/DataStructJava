/**
 * @discription 阿鸠本人所著，未经许可，不得转发，否则追求法律责任
 * @author 阿鸠
 * @date 2025/11/24 19:57
 * @param null
 * @return {@code null}
 **/

package com.itajiu.LeetCode;

public class LinkedListP82 {
    //删除链表中所有重复的元素
    //方法1   递归
    public ListNode deleteDuplicates(ListNode p) {
        if (p == null || p.next == null) {
            return p;
        }
        if (p.val == p.next.val) {
            ListNode x = p.next.next;
            while (x != null && x.val == p.val) {
                x = x.next;
            }
            return deleteDuplicates(x);
        } else {
            p.next = deleteDuplicates(p.next);
            return p;
        }
    }

    //方法2   快慢指针
    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode s = new ListNode(-1, head);
        ListNode p1 = s;
        ListNode p2, p3;

        while ((p2 = p1.next) != null && (p3 = p2.next) != null) {
            if (p2.val == p3.val) {
                while ((p3 = p3.next) != null && p3.val == p2.val) {
                }
                p1.next = p3;
            } else {
                p1 = p1.next;
            }
        }
        return s.next;
    }

}
