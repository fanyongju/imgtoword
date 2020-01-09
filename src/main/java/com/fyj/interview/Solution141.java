package com.fyj.interview;

/**
 * @author fanyongju
 * @Title: Solution141
 * @date 2020/1/9 14:19
 */
public class Solution141 {
    //141
    public boolean hasCycle(ListNode head) {
        ListNode tortoise = head;
        ListNode hare = head;
        while (hare != null && hare.next != null) {
            tortoise = tortoise.next;
            hare = hare.next.next;
            if (tortoise == hare) {
                return true;
            }
        }
        return false;
    }

    //142
    public ListNode detectCycle(ListNode head) {
        ListNode meetNode = hasCycleWithReturnNode(head);
        if (meetNode == null) {
            return null;
        }
        ListNode part1 = head;
        ListNode part2 = meetNode;
        while (part1 != part2) {
            part1 = part1.next;
            part2 = part2.next;
        }
        return part1;
    }

    public ListNode hasCycleWithReturnNode(ListNode head) {
        ListNode tortoise = head;
        ListNode hare = head;
        while (hare != null && hare.next != null) {
            tortoise = tortoise.next;
            hare = hare.next.next;
            if (tortoise == hare) {
                return hare;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode node0 = new ListNode(3);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(-4);

        node0.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node1;

        Solution141 solution141 = new Solution141();
        System.out.println(solution141.detectCycle(node0).val);
    }
}
