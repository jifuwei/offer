package com.jifuwei.offer;

/**
 * 题目：一个整型数组里除了两个数字之外，其他的数字都出现了两次，
 * 请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)
 * Created by JFW on 2017/2/7.
 */
public class Num37 {
    public static int[] findNumbersAppearanceOnce(int[] data) {
        int[] result = {0, 0};

        if (data == null || data.length < 2) {
            return result;
        }

        int xor = 0;
        for (int i : data) {
            xor ^= i;
        }

        int indexOf1 = findFirstBit1(xor);

        for (int i : data) {
            if (isBit1(i, indexOf1)) {
                result[0] ^= i;
            } else {
                result[1] ^= i;
            }
        }

        return result;
    }

    private static int findFirstBit1(int num) {
        int index = 0;
        while ((num & 1) == 0 && index < 32) {
            num >>>= 1;
            index++;
        }

        return index;
    }

    private static boolean isBit1(int num, int indexBit) {
        num >>>= indexBit;
        return (num & 1) == 1;
    }

    public static void main(String[] args) {
//        int[] data1 = {2, 4, 3, 6, 3, 2, 5, 5};
//        int[] result1 = findNumbersAppearanceOnce(data1);
//        System.out.println(result1[0] + " " + result1[1]);
//
//        int[] data2 = {4, 6};
//        int[] result2 = findNumbersAppearanceOnce(data2);
//        System.out.println(result2[0] + " " + result2[1]);
//
//        int[] data3 = {4, 6, 1, 1, 1, 1};
//        int[] result3 = findNumbersAppearanceOnce(data3);
//        System.out.println(result3[0] + " " + result3[1]);
        System.out.println(-6 >> 1);
    }
}
