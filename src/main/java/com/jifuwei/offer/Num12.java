package com.jifuwei.offer;

/**
 * 题目:输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位予数组的后半部分。
 * Created by JFW on 2017/2/3.
 */
public class Num12 {

    public static void sortArr(int[] arr) {

        if (arr == null || arr.length < 2) {
            throw new RuntimeException("invalid input. arr");
        }

        int start = 0;//首位
        int end = arr.length - 1;//末尾

        while (start < end) {
            if (start < end && arr[start] % 2 != 0) {
                start++;
            }

            if (start < end && arr[end] % 2 == 0) {
                end--;
            }

            int temp = arr[end];
            arr[end] = arr[start];
            arr[start] = temp;
        }
    }

    public static void printArray(int[] arr) {
        if (arr != null && arr.length > 0) {
            for (int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        sortArr(array);
        printArray(array);
    }
}
