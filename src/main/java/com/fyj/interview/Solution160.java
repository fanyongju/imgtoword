package com.fyj.interview;

/**
 * @author fanyongju
 * @Title: Solution160
 * @date 2019/12/27 14:40
 */
public class Solution160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != pB) {
            pA = pA.next;
            pB = pB.next;
            if (pA == null && pB == null) {
                return null;
            }
            if (pA == null) {
                pA = headB;
            }
            if (pB == null) {
                pB = headA;
            }
        }
        return pA;
    }

    public static void main(String[] args) {
        Solution160 solution160 = new Solution160();
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        ListNode f = new ListNode(6);
        a.next = d;
        d.next = e;
        e.next = f;

        b.next = c;
        c.next = f;

        System.out.println(solution160.getIntersectionNode(a,b).val);
    }
}
