package com.jifuwei.offer;

/**
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，
 * 输入这样的一个二维数组和一个整数，判断数组中是否含有该整数
 * Created by JFW on 2017/1/21.
 */
public class Num2 {

    public static boolean find(int[][] matrix, int number) {

        //输入判断条件
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return false;
        }

        int rows = matrix.length;//数组行数
        int cols = matrix[0].length;//数组列数

        int row = 0; // 起始开始的行号
        int col = cols - 1; // 起始开始的列号

        while (row >= 0 && row < rows && col >= 0 && col < cols) {
            if (number == matrix[row][col]) {//如果找到直接退出
                return true;
            } else if (matrix[row][col] > number) {//如果找到的数比要找的数大，说明要找的数在当前数的左边
                col--;// 列数减一，代表向左移动
            } else {// 如果找到的数比要找的数小，说明要找的数在当前数的下边
                row++;// 行数加一，代表向下移动
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}
        };
        System.out.println(find(matrix, 7));    // 要查找的数在数组中
        System.out.println(find(matrix, 5));    // 要查找的数不在数组中
        System.out.println(find(matrix, 1));    // 要查找的数是数组中最小的数字
        System.out.println(find(matrix, 15));   // 要查找的数是数组中最大的数字
        System.out.println(find(matrix, 0));    // 要查找的数比数组中最小的数字还小
        System.out.println(find(matrix, 16));   // 要查找的数比数组中最大的数字还大
        System.out.println(find(null, 16));     // 健壮性测试，输入空指针
    }
}
