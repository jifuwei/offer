package com.jifuwei.offer;

/**
 * 题目：输入一个链表，输出该链表中倒数第k 个结点．为了符合大多数人的习惯，本题从1 开始计数，即链表的尾结点是倒数第1 个结点．
 * 例如一个链表有6 个结点，从头结点开始它们的值依次是1 、2、3、4、5 、6。这个个链表的倒数第3 个结点是值为4 的结点．
 * Created by JFW on 2017/2/3.
 */
public class Num13 {

    public static class Node {
        int value;
        Node next;
    }

    public static Node getNodePlaceValue(Node target, int k) {
        if (target == null || k < 1) {
            throw new RuntimeException("invalid input.");
        }

        Node pointer = target;

        for (int i = 1; i < k; i++) {
            if (pointer.next != null) {
                pointer = pointer.next;
            } else {
                return null;
            }
        }

        while (pointer.next != null) {
            target= target.next;
            pointer = pointer.next;
        }

        return target;
    }

    public static void main(String[] args) {
        Node head = new Node();
        head.value = 1;

        head.next = new Node();
        head.next.value = 2;

        head.next.next = new Node();
        head.next.next.value = 3;

        head.next.next.next = new Node();
        head.next.next.next.value = 4;

        head.next.next.next.next = new Node();
        head.next.next.next.next.value = 5;

        head.next.next.next.next.next = new Node();
        head.next.next.next.next.next.value = 6;

        head.next.next.next.next.next.next = new Node();
        head.next.next.next.next.next.next.value = 7;

        head.next.next.next.next.next.next.next = new Node();
        head.next.next.next.next.next.next.next.value = 8;

        head.next.next.next.next.next.next.next.next = new Node();
        head.next.next.next.next.next.next.next.next.value = 9;

        System.out.println(getNodePlaceValue(head, 1).value); // 倒数第一个
        System.out.println(getNodePlaceValue(head, 5).value); // 中间的一个
        System.out.println(getNodePlaceValue(head, 9).value); // 倒数最后一个就是顺数第一个

        System.out.println(getNodePlaceValue(head, 10));
    }
}
