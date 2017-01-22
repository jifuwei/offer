package com.jifuwei.offer;

import java.util.Stack;

/**
 * 题目：输入个链表的头结点，从尾到头反过来打印出每个结点的值。
 * Created by JFW on 2017/1/22.
 */
public class Num4 {

    /**
     * 节点对象
     */
    public static class ListNode {
        int val;//节点的值
        ListNode next;//下一个节点
    }

    /**
     * 输入个链表的头结点，从尾到头反过来打印出每个结点的值
     * 使用栈的方式进行
     *
     * @param node 链表头结点
     */
    public static void printListInverselyUsingIteration(ListNode node) {
        Stack<ListNode> stack = new Stack<ListNode>();
        while (node != null) {
            stack.push(node);
            node = node.next;
        }

        ListNode temp;
        while (!stack.isEmpty()) {
            temp = stack.pop();
            System.out.print(temp.val + " ");
        }
    }

    /**
     * 递归调用
     *
     * @param root 链表头结点
     */
    public static void printListInverselyUsingRecursion(ListNode root) {
        if (root != null) {
            printListInverselyUsingRecursion(root.next);
            System.out.print(root.val + " ");
        }
    }

    public static void main(String[] args) {
        ListNode root = new ListNode();
        root.val = 1;
        root.next = new ListNode();
        root.next.val = 2;
        root.next.next = new ListNode();
        root.next.next.val = 3;
        root.next.next.next = new ListNode();
        root.next.next.next.val = 4;
        root.next.next.next.next = new ListNode();
        root.next.next.next.next.val = 5;

        printListInverselyUsingIteration(root);
        System.out.println();
        printListInverselyUsingRecursion(root);
    }
}
