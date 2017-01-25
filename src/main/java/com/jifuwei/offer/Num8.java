package com.jifuwei.offer;

/**
 * 斐波那契数列
 * Created by JFW on 2017/1/25.
 */
public class Num8 {

    public static long fibonacci(int n) {
        if (n <= 0) {
            return 0;
        }

        if (n == 1 || n == 2) {
            return 1;
        }

        long prePre = 1;
        long pre = 1;
        long sum = 2;

        for (int i = 3; i <= n; i++) {
            sum = prePre + pre;
            prePre = pre;
            pre = sum;
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(0));
        System.out.println(fibonacci(1));
        System.out.println(fibonacci(2));
        System.out.println(fibonacci(3));
        System.out.println(fibonacci(4));
        System.out.println(fibonacci(5));
        System.out.println(fibonacci(6));
        System.out.println(fibonacci(7));
    }
}
