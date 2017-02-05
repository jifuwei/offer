package com.jifuwei.offer;

import java.util.Stack;

/**
 * 题目： 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小素的min 函数。
 * 在该栈中，调用min、push 及pop的时间复杂度都是0(1)
 * Created by JFW on 2017/2/5.
 */
public class Num19 {

    public static class StackWithMin<T extends Comparable<T>> {
        //数据栈
        public Stack<T> dataStack;
        //辅助栈
        public Stack<Integer> minStack;

        public StackWithMin() {
            this.dataStack = new Stack<T>();
            this.minStack = new Stack<Integer>();
        }

        /**
         * 出栈方法
         */
        public T pop() {
            if (dataStack.isEmpty()) {
                throw new RuntimeException("null stack.");
            }

            minStack.pop();
            return dataStack.pop();
        }

        /**
         * 入栈
         */
        public void push(T t) {
            if (t == null) {
                throw new RuntimeException("invalid input.");
            }

            if (dataStack.isEmpty()) {
                dataStack.push(t);
                minStack.push(0);
            } else {
                // 获取数据栈中的最小元素（未插入t之前的）
                T e = dataStack.get(minStack.peek());
                dataStack.push(t);
                if (t.compareTo(e) < 0) {
                    // 将新的最小元素的位置入最小栈
                    minStack.push(dataStack.size() - 1);
                } else {
                    // 插入的元素不比原来的最小元素小，复制最小栈栈顶元素，将其入栈
                    minStack.push(minStack.peek());
                }
            }
        }

        /**
         * 获取栈中的最小元素
         * @return 栈中的最小元素
         */
        public T min() {
            // 如果最小数公位置栈已经为空（数据栈中已经没有数据了），则抛出异常
            if (minStack.isEmpty()) {
                throw new RuntimeException("No element in stack.");
            }

            // 获取数据栈中的最小元素，并且返回结果
            return dataStack.get(minStack.peek());
        }
    }

    public static void main(String[] args) {
        StackWithMin<Integer> stack = new StackWithMin<Integer>();
        stack.push(3);
        System.out.println(stack.min() == 3);
        stack.push(4);
        System.out.println(stack.min() == 3);
        stack.push(2);
        System.out.println(stack.min() == 2);
        stack.push(3);
        System.out.println(stack.min() == 2);
        stack.pop();
        System.out.println(stack.min() == 2);
        stack.pop();
        System.out.println(stack.min() == 3);
        stack.push(0);
        System.out.println(stack.min() == 0);
    }
}
