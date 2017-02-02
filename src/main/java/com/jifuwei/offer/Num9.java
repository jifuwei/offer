package com.jifuwei.offer;

/**
 * 题目：数值的整数次方
 * Created by JFW on 2017/2/2.
 */
public class Num9 {

    public static double power(double base, int exponent) {
        if (base == 0 && exponent == 0) {
            throw new RuntimeException("invalid input.base and exponent can both are zero");
        }

        if (exponent == 0) {
            return 1;
        }

        long exp = exponent;
        if (exponent < 0) {
            exp = -exp;
        }

        double result = powerWithUnsignedExponent(base, exp);

        // 指数是负数，要进行求倒数
        if (exponent < 0) {
            result = 1 / result;
        }

        // 返回结果
        return result;
    }

    private static double powerWithUnsignedExponent(double base, long exp) {

        if (exp == 0 ){
            return 1;
        }

        if (exp == 1) {
            return base;
        }

        // 递归求一半的值
        double result = powerWithUnsignedExponent(base, exp >> 1);

        // 求最终的值，如果是奇数就还要乘以一次底数
        result *= result;
        if (exp % 2 != 0) {
            result *= base;
        }

        return result;
    }

    public static void main(String[] args) {

//        System.out.println(0.0000000000000000000000001111 == 0);
//        System.out.println(0.0000000000000000000000000000 == 0);

        System.out.println(power(2, -4));
        System.out.println(power(2, 4));
        System.out.println(power(2, 0));
        System.out.println(power(0.00000000000000000000000000001, -1));
        System.out.println(power(0.00000000000000000000000000001, 1));
        System.out.println(power(0.00000000000000000000000000001, 0));
        System.out.println(power(0.00000000000000000000000000000, 0));
    }
}
