package com.jifuwei.offer;

import java.util.Stack;

/**
 * 题目：用两个栈实现一个队列。队列的声明如下，
 * 请实现它的两个函数appendTail 和deleteHead，分别完成在队列尾部插入结点和在队列头部删除结点的功能。
 * Created by JFW on 2017/1/24.
 */
public class Num6<T> {

    //插入栈，只用于插入的数据
    private Stack<T> pushStack = new Stack<T>();
    //弹出栈，只用于弹出数据
    private Stack<T> popStack = new Stack<T>();

    public void appendTail(T t) {
        pushStack.add(t);
    }

    public T deleteHead() {
        //先判断弹出栈是否为空，如果为空则插入栈所有数据
        if (popStack.isEmpty()) {
            while (!pushStack.isEmpty()) {
                popStack.add(popStack.pop());
            }
        }

        if (popStack.isEmpty()) {
            throw new RuntimeException("No more Element.");
        }

        return popStack.pop();
    }
}
