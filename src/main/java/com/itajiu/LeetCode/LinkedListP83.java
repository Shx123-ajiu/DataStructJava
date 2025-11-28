/**
 * @discription 阿鸠本人所著，未经许可，不得转发，否则追求法律责任
 * @author 阿鸠
 * @date 2025/11/24 19:57
 * @param null
 * @return {@code null}
 **/

package com.itajiu.LeetCode;

public class LinkedListP83 {
    //删除链表重复节点
    //方法1   快慢指针
    public ListNode deleteDuplicates1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p1 = head; // 慢指针
        ListNode p2;        // 快指针
        while ((p2 = p1.next) != null) {
            if (p1.val == p2.val) {
                p1.next = p2.next;
            } else {
                p1 = p1.next;
            }
        }
        return head;
    }

    //方法2   递归
    public ListNode deleteDuplicates2(ListNode p) {
        if(p == null || p.next == null){
            return p;
        }
        if(p.val == p.next.val){
            return deleteDuplicates2(p.next);
        }else{
            p.next = deleteDuplicates2(p.next);
            return p;
        }





    }


}
